package com.hxzy.waimai;

import com.hxzy.entity.TplAutocolumn;
import com.hxzy.service.TplAutocolumnService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author wy
 * @Description TODO
 * @Date 2023/4/8 16:54
 * @Version 1.0
 */
@SpringBootTest
public class FreemarkerTest {

    @Autowired
    private Configuration configuration;

    /**
     * 生成文件测试
     */
    @Test
    public void testService() throws IOException, TemplateException {
        Map<String,Object>  params=new HashMap<>();
        params.put("entityName","Contamer");
        params.put("tableNameDesc","前台用户表");
        params.put("primaryType", BigDecimal.class.getSimpleName());

        //导入的数据类型
        List<String> javaTypeList=new ArrayList<>();
        javaTypeList.add("java.math.BigDecimal");
        javaTypeList.add("java.util.List");
        params.put("javaTypeList",javaTypeList);

        //使用freemarker来生成字符串
        Template template = configuration.getTemplate("service.ftlh");

        FileWriter writer=new FileWriter(new File("D:\\tpl\\ContamerService.java"));

        template.process(params,writer);
        writer.close();


    }

    /**
     * 生成文件测试
     */
    @Test
    public void testServiceImpl() throws IOException, TemplateException {
        Map<String,Object>  params=new HashMap<>();
        params.put("entityName","Contamer");
        params.put("entityNameLower","contamer");
        params.put("tableNameDesc","前台用户表");
        params.put("primaryType", BigDecimal.class.getSimpleName());

        //导入的数据类型
        List<String> javaTypeList=new ArrayList<>();
        javaTypeList.add("java.math.BigDecimal");
        javaTypeList.add("java.util.List");
        params.put("javaTypeList",javaTypeList);

        //使用freemarker来生成字符串
        Template template = configuration.getTemplate("serviceImpl.ftlh");

        FileWriter writer=new FileWriter(new File("D:\\tpl\\impl\\ContamerServiceImpl.java"));

        template.process(params,writer);
        writer.close();


    }


    @Autowired
    private TplAutocolumnService tplAutocolumnService;

    /**
     * 生成文件测试
     */
    @Test
    public void testSearchDTO() throws IOException, TemplateException {
        Map<String,Object>  params=new HashMap<>();
        params.put("entityName","Contamer");
        params.put("tableNameDesc","前台用户表");

        //导入的数据类型
        List<String> javaTypeList=new ArrayList<>();
        javaTypeList.add("java.math.BigDecimal");
        javaTypeList.add("java.util.List");
        params.put("javaTypeList",javaTypeList);

        //从数据库查询要导出的数据
        List<TplAutocolumn> tplAutocolumnList = this.tplAutocolumnService.findByTableName("CONTAMER");

        //生成查询字段
        List<TplAutocolumn> searchList = tplAutocolumnList.stream().filter(p -> p.getSearchField()!=null && p.getSearchField() == true).collect(Collectors.toList());
        params.put("searchParams", searchList);

        //使用freemarker来生成字符串
        Template template = configuration.getTemplate("searchdto.ftlh");

        FileWriter writer=new FileWriter(new File("D:\\tpl\\ContamerSearchDTO.java"));

        template.process(params,writer);
        writer.close();


    }
}
