package com.hxzy.waimai;

import cn.hutool.core.lang.Assert;
import com.hxzy.entity.Employee;
import com.hxzy.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class WaimaiApplicationTests {

    @Autowired
    private EmployeeService  employeeService;

    @Test
    void contextLoads() {
    }


    /**
     * 向数据库中新增员工信息
     */
    @Test
    public void addEmployee(){
        Employee employee=new Employee();
        employee.setLoginName("admin");
        employee.setGender((short) 1);
        employee.setLoginPwd("admin8888");
        employee.setStatus((short) 0);
        employee.setAvatar("https://plus.hutool.cn/images/ad/ccflow2.png");
        employee.setCreateBy("admin");
        employee.setCreateTime(new Date());

        int insert = this.employeeService.insert(employee);

        Assert.equals(1, insert);

    }
}
