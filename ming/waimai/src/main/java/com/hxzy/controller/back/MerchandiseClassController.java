package com.hxzy.controller.back;

import com.hxzy.common.annontation.Shop;
import com.hxzy.common.eunms.AckCode;
import com.hxzy.config.WaimaiThreadLocal;
import com.hxzy.dto.MerchandiseClassSearchDTO;
import com.hxzy.vo.PageVO;
import com.hxzy.vo.Result;
import com.hxzy.vo.back.AdminLoginVO;
import com.alibaba.excel.EasyExcel;
import com.github.pagehelper.PageHelper;
import com.hxzy.common.controller.BaseController;
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
import com.hxzy.entity.MerchandiseClass;
import com.hxzy.service.MerchandiseClassService;
import java.lang.Long;

/**
* @Author 商品分类表
* @Description TODO
* @Date 2023/4/6 17:11
* @Version 1.0
*/
@Api(tags = "商品分类表API")
@RestController
@RequestMapping(value = "/api/merchandiseclass")
public class MerchandiseClassController extends BaseController {


    @Autowired
    private MerchandiseClassService  merchandiseClassService;

    @ApiOperation(value = "分页查询")
    @GetMapping(value = "/data")
    public Result<PageVO<MerchandiseClass>> search(MerchandiseClassSearchDTO searchDTO){
        //开启分页
        PageHelper.startPage(searchDTO.getPageNum(),searchDTO.getPageSize());
        //普通查询
        List<MerchandiseClass> arr=this.merchandiseClassService.search(searchDTO);
        //转换成自己的对象
        return super.pageToPageVO(arr);
    }

    @Shop
    @ApiOperation(value = "新增")
    @PostMapping
    public Result  insert(@RequestBody @Valid MerchandiseClass entity) {
        AdminLoginVO adminLoginVO = WaimaiThreadLocal.adminThreadLocal.get();

        entity.setCreateTime(new Date());
        entity.setCreateBy(adminLoginVO.getName());
        entity.setMId(adminLoginVO.getId());

        //保存
        int count = this.merchandiseClassService.insert(entity);
        return super.toR(count);
    }

    @Shop
    @ApiOperation(value = "修改")
    @PutMapping
    public Result  update(@RequestBody @Valid MerchandiseClass entity) {
        AdminLoginVO adminLoginVO = WaimaiThreadLocal.adminThreadLocal.get();

        MerchandiseClass db=this.merchandiseClassService.selectByPrimaryKey(entity.getId());
        if(db==null){
           return Result.build(AckCode.NOT_FOUND_DATA);
        }

        db.setUpdateTime(new Date());
        db.setUpdateBy(adminLoginVO.getName());
        //执行
        int count = this.merchandiseClassService.updateByPrimaryKeySelective(entity);
        return  super.toR(count);
    }

    @ApiOperation(value = "根据主键查询")
    @GetMapping(value = "/{id}")
    public Result<MerchandiseClass> findById(@PathVariable(value = "id") Long id){
         MerchandiseClass db=this.merchandiseClassService.selectByPrimaryKey(Math.toIntExact(id));
        if(db==null){
           return Result.build(AckCode.NOT_FOUND_DATA);
        }
        return Result.okHasData(db);
    }

    @ApiOperation(value = "导出查询数据到excel")
    @PostMapping(value = "/download")
    public void downloadExcel(@RequestBody MerchandiseClassSearchDTO  searchDTO , HttpServletResponse response) throws IOException {
        //普通查询
        List<MerchandiseClass> arr=this.merchandiseClassService.search(searchDTO);

        String fileName = "MerchandiseClass_data_" + System.currentTimeMillis() + ".xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), MerchandiseClass.class).sheet("result").doWrite(arr);
    }

}