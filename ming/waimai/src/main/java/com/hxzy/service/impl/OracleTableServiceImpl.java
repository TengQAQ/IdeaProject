package com.hxzy.service.impl;

import cn.hutool.core.util.CharUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.template.TemplateException;
import com.hxzy.common.eunms.AckCode;
import com.hxzy.common.exception.WaiMaiException;
import com.hxzy.entity.TplAutocolumn;
import com.hxzy.mapper.OracleTableMapper;
import com.hxzy.service.OracleTableService;
import com.hxzy.service.TplAutocolumnService;
import com.hxzy.vo.back.TableNameColumnsVO;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/18-13:49
 * @description TODO
 */
@Service
public class OracleTableServiceImpl  implements OracleTableService {
    @Autowired
    private OracleTableMapper oracleTableMapper;

    @Autowired
    private TplAutocolumnService tplAutocolumnService;


    @Autowired
    private Configuration configuration;

    @Override
    public List<Map<String, Object>> searchAllTables() {
        return oracleTableMapper.searchAllTables();
    }

    @Override
    public Map<String, Object> columnsForTableName(String tableName) {
        Map<String, Object> data = new HashMap<>(16);

        List<TableNameColumnsVO> columnsVOList = null;

        // 查询数据库是否有保存过数据
        List<TplAutocolumn> tplAutocolumnList = this.tplAutocolumnService.findByTableName(tableName);
        if (tplAutocolumnList != null && tplAutocolumnList.size() > 0) {

            data.put("allowdownload", true);

            columnsVOList = new ArrayList<>(tplAutocolumnList.size());
            //复制值
            for (TplAutocolumn ac : tplAutocolumnList) {
                TableNameColumnsVO vo = new TableNameColumnsVO();
                //复制属性
                BeanUtils.copyProperties(ac, vo);
                columnsVOList.add(vo);
            }
        } else {
            // 没有配置过，读oracle的数据格式
            columnsVOList = this.oracleTableMapper.columnsForTableName(tableName);

            data.put("allowdownload", false);
        }

        data.put("data", columnsVOList);

        return data;
    }
    @Override
    public byte[] generatorCode(String tableName, String tableDesc) {
        //MERCHANDISE_CLASS
        String oracleTableName=tableName;
        String entityName= entityName(oracleTableName);
        String desc=tableDesc;

        TplAutocolumn tplAutocolumn = this.tplAutocolumnService.searchTablePrimaryKeyAndJavaType(oracleTableName);
        if(tplAutocolumn==null){
            throw new WaiMaiException.WaimaiException(AckCode.NOT_FOUND_DATA);
        }
        byte[] data=null;

        try(ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            CheckedOutputStream checkedOutputStream = new CheckedOutputStream(outputStream, new CRC32());
            ZipOutputStream zip = new ZipOutputStream(checkedOutputStream)){
            // 生成 EntityName+SearchDTO.java
            generatorCodeSerchDTO(oracleTableName,desc, zip);

            //生成 EntityName+Mapper.java
            generatorCodeMapper(entityName,desc, tplAutocolumn.getJavaDataType(), zip);

            //生成 EntityName+Service.java
            generatorCodeService(entityName,desc, tplAutocolumn.getJavaDataType(), zip);

            //生成impl/EntityName+ServiceImpl.java
            generatorCodeServiceImpl(entityName,desc, tplAutocolumn.getJavaDataType(), zip);

            // 生成 mapper/EntityName+Mapper.xml
            generatorCodeMapperXml(oracleTableName,zip);

            // 生成 controller/EntityName+Controller.java
            generatorCodeController(entityName,desc, tplAutocolumn.getJavaDataType(), zip);

            //zip文件数据，转换成二进制流
            data= outputStream.toByteArray();

        } catch (IOException | TemplateException | freemarker.template.TemplateException e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * 生成分页查询语句
     * @param oracleTableName
     * @param zip
     */
    private void generatorCodeMapperXml(String oracleTableName, ZipOutputStream zip) throws IOException, TemplateException, freemarker.template.TemplateException {
        Map<String,Object>  params=new HashMap<>();
        params.put("oracleTableName",oracleTableName);

        //从数据库查询要导出的数据
        List<TplAutocolumn> tplAutocolumnList = this.tplAutocolumnService.findByTableName(oracleTableName.toUpperCase());

        //生成查询字段
        List<TplAutocolumn> searchList = tplAutocolumnList.stream().filter(p -> p.getSearchField()!=null && p.getSearchField() == true).collect(Collectors.toList());
        params.put("searchParams", searchList);

        //生成要查询的列的字段
        List<TplAutocolumn> tableFieldList = tplAutocolumnList.stream().filter(p -> p.getTableField()!=null && p.getTableField() == true).collect(Collectors.toList());
        //显示所有的列
        if(tableFieldList.isEmpty()){
            params.put("allFields","*");
        }else {
            params.put("tableFieldList", tableFieldList);
        }
        //使用freemarker来生成字符串
        Template template = configuration.getTemplate("pageSearchXml.ftlh");

        //定义字符流Writer  FileWriter
        StringWriter sw=new StringWriter();
        //执行模板引擎，把参数合并的模板中，输出到StringBuffer里面
        template.process(params,sw);
        // 添加到zip
        zip.putNextEntry(new ZipEntry("resources/mapper/"+ oracleTableName+"Mapper.xml" ));
        // 把stringbuffer中的内容，写入到zip中去
        IOUtils.write(sw.toString(), zip, "UTF-8");
        IOUtils.closeQuietly(sw);
        zip.flush();
        zip.closeEntry();
    }

    /**
     * 生成controller文件
     * @param entityName
     * @param desc
     * @param primaryKeyType
     * @param zip
     */
    private void generatorCodeController(String entityName, String desc, String primaryKeyType, ZipOutputStream zip) throws IOException, TemplateException, freemarker.template.TemplateException {
        Map<String,Object>  params=new HashMap<>();
        params.put("entityName",entityName);
        params.put("tableNameDesc",desc);
        params.put("primaryKeyType",primaryKeyType);

        //导入的数据类型
        List<String> javaTypeList=new ArrayList<>();
        String typeValue=stringToJavaType( primaryKeyType);
        if(StrUtil.isNotBlank(typeValue)){
            javaTypeList.add(typeValue);
        }
        params.put("javaTypeList",javaTypeList);

        //使用freemarker来生成字符串
        Template template = configuration.getTemplate("controller.ftlh");

        //定义字符流Writer  FileWriter
        StringWriter sw=new StringWriter();
        //执行模板引擎，把参数合并的模板中，输出到StringBuffer里面
        template.process(params,sw);
        // 添加到zip
        zip.putNextEntry(new ZipEntry("com/hxzy/controller/back/"+ entityName+"Controller.java" ));
        // 把stringbuffer中的内容，写入到zip中去
        IOUtils.write(sw.toString(), zip, "UTF-8");
        IOUtils.closeQuietly(sw);
        zip.flush();
        zip.closeEntry();

    }

    /**
     * 生成serviceImpl文件
     * @param entityName
     * @param desc
     * @param primaryKeyType
     * @param zip
     */
    private void generatorCodeServiceImpl(String entityName, String desc, String primaryKeyType, ZipOutputStream zip) throws IOException, TemplateException, freemarker.template.TemplateException {
        Map<String,Object>  params=new HashMap<>();
        params.put("entityName",entityName);
        params.put("tableNameDesc",desc);
        params.put("primaryKeyType",primaryKeyType);

        //导入的数据类型
        List<String> javaTypeList=new ArrayList<>();
        String typeValue=stringToJavaType( primaryKeyType);
        if(StrUtil.isNotBlank(typeValue)){
            javaTypeList.add(typeValue);
        }
        params.put("javaTypeList",javaTypeList);

        //使用freemarker来生成字符串
        Template template = configuration.getTemplate("serviceImpl.ftlh");

        //定义字符流Writer  FileWriter
        StringWriter sw=new StringWriter();
        //执行模板引擎，把参数合并的模板中，输出到StringBuffer里面
        template.process(params,sw);
        // 添加到zip
        zip.putNextEntry(new ZipEntry("com/hxzy/service/impl/"+ entityName+"Service.java" ));
        // 把stringbuffer中的内容，写入到zip中去
        IOUtils.write(sw.toString(), zip, "UTF-8");
        IOUtils.closeQuietly(sw);
        zip.flush();
        zip.closeEntry();
    }

    /**
     * 生成service文件
     * @param entityName
     * @param desc
     * @param primaryKeyType
     * @param zip
     */
    private void generatorCodeService(String entityName, String desc, String primaryKeyType, ZipOutputStream zip) throws IOException, TemplateException, freemarker.template.TemplateException {
        Map<String,Object>  params=new HashMap<>();
        params.put("entityName",entityName);
        params.put("tableNameDesc",desc);
        params.put("primaryKeyType",primaryKeyType);

        //导入的数据类型
        List<String> javaTypeList=new ArrayList<>();
        String typeValue=stringToJavaType( primaryKeyType);
        if(StrUtil.isNotBlank(typeValue)){
            javaTypeList.add(typeValue);
        }
        params.put("javaTypeList",javaTypeList);

        //使用freemarker来生成字符串
        Template template = configuration.getTemplate("service.ftlh");

        //定义字符流Writer  FileWriter
        StringWriter sw=new StringWriter();
        //执行模板引擎，把参数合并的模板中，输出到StringBuffer里面
        template.process(params,sw);
        // 添加到zip
        zip.putNextEntry(new ZipEntry("com/hxzy/service/"+ entityName+"Service.java" ));
        // 把stringbuffer中的内容，写入到zip中去
        IOUtils.write(sw.toString(), zip, "UTF-8");
        IOUtils.closeQuietly(sw);
        zip.flush();
        zip.closeEntry();
    }

    /**
     * 生成mapper
     * @param entityName
     * @param desc
     * @param primaryKeyType
     * @param zip
     */
    private void generatorCodeMapper(String entityName, String desc,String primaryKeyType, ZipOutputStream zip) throws IOException, TemplateException, freemarker.template.TemplateException {
        Map<String,Object>  params=new HashMap<>();
        params.put("entityName",entityName);
        params.put("tableNameDesc",desc);
        params.put("primaryKeyType",primaryKeyType);

        //导入的数据类型
        List<String> javaTypeList=new ArrayList<>();
        String typeValue=stringToJavaType( primaryKeyType);
        if(StrUtil.isNotBlank(typeValue)){
            javaTypeList.add(typeValue);
        }
        params.put("javaTypeList",javaTypeList);

        //使用freemarker来生成字符串
        Template template = configuration.getTemplate("mapper.ftlh");

        //定义字符流Writer  FileWriter
        StringWriter sw=new StringWriter();
        //执行模板引擎，把参数合并的模板中，输出到StringBuffer里面
        template.process(params,sw);
        // 添加到zip
        zip.putNextEntry(new ZipEntry("com/hxzy/mapper/"+ entityName+"Mapper.java" ));
        // 把stringbuffer中的内容，写入到zip中去
        IOUtils.write(sw.toString(), zip, "UTF-8");
        IOUtils.closeQuietly(sw);
        zip.flush();
        zip.closeEntry();

    }

    private void generatorCodeSerchDTO(String tableName,String desc, ZipOutputStream zip) throws IOException, TemplateException, freemarker.template.TemplateException {
        Map<String,Object>  params=new HashMap<>();
        params.put("entityName",tableName);
        params.put("tableNameDesc",desc);

        //从数据库查询要导出的数据
        List<TplAutocolumn> tplAutocolumnList = this.tplAutocolumnService.findByTableName(tableName.toUpperCase());

        //生成查询字段
        List<TplAutocolumn> searchList = tplAutocolumnList.stream().filter(p -> p.getSearchField()!=null && p.getSearchField() == true).collect(Collectors.toList());
        params.put("searchParams", searchList);

        //导入的数据类型
        List<String> javaTypeList=new ArrayList<>();
        searchList.stream().forEach(p-> {
            String typeValue=stringToJavaType( p.getJavaDataType());
            if(StrUtil.isNotBlank(typeValue)){
                javaTypeList.add(typeValue);
            }
        });
        params.put("javaTypeList",javaTypeList);


        //使用freemarker来生成字符串
        Template template = configuration.getTemplate("searchdto.ftlh");

        //定义字符流Writer  FileWriter
        StringWriter sw=new StringWriter();
        //执行模板引擎，把参数合并的模板中，输出到StringBuffer里面
        template.process(params,sw);

        // 添加到zip
        zip.putNextEntry(new ZipEntry("com/hxzy/dto/back/"+ tableName+"SearchDTO.java" ));

        // 把stringbuffer中的内容，写入到zip中去
        /**
         * <dependency>
         *             <groupId>commons-io</groupId>
         *             <artifactId>commons-io</artifactId>
         *             <version>2.11.0</version>
         *         </dependency>
         *
         *     IOUtils.write() 实现了以下的功能
         *     int count;
         *             byte[] data = new byte[1024];
         *             while ((count = bis.read(data, 0, 1024)) != -1) {
         *                 zipOut.write(data, 0, count);
         *             }
         */
        IOUtils.write(sw.toString(), zip, "UTF-8");
        IOUtils.closeQuietly(sw);
        zip.flush();
        zip.closeEntry();
    }

    private String  stringToJavaType(String str){
        Map<String,String>  map=new HashMap<>();
        map.put("Long",  "java.lang.Long");
        map.put("Short",  "java.lang.Short");
        map.put("BigDecimal",  "java.math.BigDecimal");
        map.put("Date",  "java.util.Date");

        String result=map.get(str);
        return  result;
    }

    private String entityName(String name) {
        int index = name.indexOf(CharUtil.UNDERLINE);
        String tableName="";
        if (index >= 0) {
            tableName= StrUtil.toCamelCase(name);
        }else{
            tableName =name.toLowerCase(Locale.ROOT);
        }

        //a=97  A=65  =97-65=32    b=98   B=66
        char firstLetter=(char)(tableName.charAt(0)-32);

        return firstLetter+ tableName.substring(1);
    }
}