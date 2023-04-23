package com.hxzy.controller.back;

import com.hxzy.common.annons.Shop;
import com.hxzy.config.WaimaiThreadLocal;
import com.hxzy.vo.back.AdminLoginVO;
import com.alibaba.excel.EasyExcel;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hxzy.common.controller.BaseController;
import com.hxzy.common.vo.PageVO;
import com.hxzy.common.enums.AckCode;
import com.hxzy.common.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Date;
import javax.validation.Valid;
import com.hxzy.dto.back.${entityName}SearchDTO;
import com.hxzy.entity.${entityName};
import com.hxzy.service.${entityName}Service;
<#if javaTypeList??>
    <#list javaTypeList as value >
import ${value};
    </#list>
</#if>

/**
* @Author ${tableNameDesc}
* @Description TODO
* @Date 2023/4/6 17:11
* @Version 1.0
*/
@Api(tags = "${tableNameDesc}API")
@RestController
@RequestMapping(value = "/api/${entityName?uncap_first}")
public class ${entityName}Controller  extends BaseController {


    @Autowired
    private ${entityName}Service  ${entityName?uncap_first}Service;

    @ApiOperation(value = "分页查询")
    @GetMapping(value = "/data")
    public R<PageVO<${entityName}>>  search(${entityName}SearchDTO  searchDTO){
        //开启分页
        PageHelper.startPage(searchDTO.getPage(),searchDTO.getSize());
        //普通查询
        List<${entityName}> arr=this.${entityName?uncap_first}Service.search(searchDTO);
        //转换成自己的对象
        return super.pageToPageVO(arr);
    }

    @Shop
    @ApiOperation(value = "新增")
    @PostMapping
    public R  insert(@RequestBody @Valid ${entityName} entity) {
        AdminLoginVO adminLoginVO = WaimaiThreadLocal.adminThreadLocal.get();

        entity.setCreateTime(new Date());
        entity.setCreateBy(adminLoginVO.getName());
        entity.setMId(adminLoginVO.getId());

        //保存
        int count = this.${entityName?uncap_first}Service.insert(entity);
        return super.toR(count);
    }

    @Shop
    @ApiOperation(value = "修改")
    @PutMapping
    public R  update(@RequestBody @Valid ${entityName} entity) {
        AdminLoginVO adminLoginVO = WaimaiThreadLocal.adminThreadLocal.get();

        ${entityName} db=this.${entityName?uncap_first}Service.selectByPrimaryKey(entity.getId());
        if(db==null){
           return R.build(AckCode.NOT_FOUND_DATA);
        }

        db.setUpdateTime(new Date());
        db.setUpdateBy(adminLoginVO.getName());
        //执行
        int count = this.${entityName?uncap_first}Service.updateByPrimaryKeySelective(entity);
        return  super.toR(count);
    }

    @ApiOperation(value = "根据主键查询")
    @GetMapping(value = "/{id}")
    public R<${entityName}> findById(@PathVariable(value = "id") ${primaryKeyType} id){
         ${entityName} db=this.${entityName?uncap_first}Service.selectByPrimaryKey(id);
        if(db==null){
           return R.build(AckCode.NOT_FOUND_DATA);
        }
        return R.okHasData(db);
    }

    @ApiOperation(value = "导出查询数据到excel")
    @PostMapping(value = "/download")
    public void downloadExcel(@RequestBody ${entityName}SearchDTO  searchDTO , HttpServletResponse response) throws IOException {
        //普通查询
        List<${entityName}> arr=this.${entityName?uncap_first}Service.search(searchDTO);

        String fileName = "${entityName}_data_" + System.currentTimeMillis() + ".xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), ${entityName}.class).sheet("result").doWrite(arr);
    }

}