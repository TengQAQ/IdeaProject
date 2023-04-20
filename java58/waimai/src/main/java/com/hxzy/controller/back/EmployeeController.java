package com.hxzy.controller.back;

import cn.hutool.crypto.digest.BCrypt;
import com.alibaba.excel.EasyExcel;
import com.github.pagehelper.PageHelper;
import com.hxzy.common.annons.Admin;
import com.hxzy.common.controller.BaseController;
import com.hxzy.common.enums.AckCode;
import com.hxzy.common.vo.PageVO;
import com.hxzy.common.vo.R;
import com.hxzy.config.WaimaiThreadLocal;
import com.hxzy.dto.back.EmployeeAddDTO;
import com.hxzy.dto.back.EmployeeEditDTO;
import com.hxzy.dto.back.EmployeeSearchDTO;
import com.hxzy.entity.Employee;
import com.hxzy.service.EmployeeService;
import com.hxzy.vo.back.AdminLoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author wy
 * @Description TODO
 * @Date 2023/4/6 17:11
 * @Version 1.0
 */
@Api(tags = "员工API")
@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController  extends BaseController {


    @Autowired
    private EmployeeService  employeeService;

    @ApiOperation(value = "分页查询")
    @GetMapping(value = "/data")
    public R<PageVO<Employee>>  search(EmployeeSearchDTO  employeeSearchDTO){
        //开启分页
        PageHelper.startPage(employeeSearchDTO.getPage(),employeeSearchDTO.getSize());
        //普通查询
        List<Employee> arr=this.employeeService.search(employeeSearchDTO);
        //转换成自己的对象
        return super.pageToPageVO(arr);
    }

    @Admin
    @ApiOperation(value = "新增")
    @PostMapping
    public R  insert(@RequestBody @Valid EmployeeAddDTO addDTO) {

        if(!addDTO.getLoginPwd().equals(addDTO.getLoginPwdConfirm())){
            return R.build(AckCode.SET_PASSWORD_INVALID);
        }
        //判断用户名是否被占用
        int number=this.employeeService.selectLoginNameCount(addDTO.getLoginName());
        if(number>0){
            return R.build(AckCode.EXISTS_VALUE_ACCOUNT);
        }


        AdminLoginVO adminLoginVO = WaimaiThreadLocal.adminThreadLocal.get();

        Employee employee=new Employee();
        BeanUtils.copyProperties(addDTO,employee);
        employee.setCreateTime(new Date());
        employee.setCreateBy(adminLoginVO.getName());
        //密码还需要加密
        employee.setLoginPwd(BCrypt.hashpw(employee.getLoginPwd()));
        //保存
        int count = this.employeeService.insert(employee);
        return super.toR(count);
    }

    @Admin
    @ApiOperation(value = "修改")
    @PutMapping
    public R  update(@RequestBody @Valid EmployeeEditDTO editDTO) {
        Employee employee=this.employeeService.selectByPrimaryKey(editDTO.getId());
        if(employee==null){
            return R.build(AckCode.NOT_FOUND_DATA);
        }

        //复制数据
        BeanUtils.copyProperties(editDTO,employee);
        employee.setUpdateTime(new Date());

        AdminLoginVO adminLoginVO = WaimaiThreadLocal.adminThreadLocal.get();
        employee.setUpdateBy(adminLoginVO.getName());

        //执行
        int count = this.employeeService.updateByPrimaryKeySelective(employee);

        return  super.toR(count);
    }

    @ApiOperation(value = "根据主键查询")
    @GetMapping(value = "/{id}")
    public R<Employee> findById(@PathVariable(value = "id") BigDecimal id){
        Employee employee=this.employeeService.selectByPrimaryKey(id);
        if(employee==null){
            return R.build(AckCode.NOT_FOUND_DATA);
        }
        return R.okHasData(employee);
    }

    @ApiOperation(value = "导出查询数据到excel")
    @PostMapping(value = "/download")
    public void downloadExcel(@RequestBody EmployeeSearchDTO  employeeSearchDTO, HttpServletResponse response) throws IOException {
        //普通查询
        List<Employee> arr=this.employeeService.search(employeeSearchDTO);

        //对接easyexcel
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        // String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
        String fileName = "Employee_data_" + System.currentTimeMillis() + ".xlsx";


        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), Employee.class).sheet("result").doWrite(arr);
    }
}
