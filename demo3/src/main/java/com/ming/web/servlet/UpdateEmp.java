package com.ming.web.servlet;

import com.ming.entity.Employee;
import com.ming.service.EmployeeService;
import com.ming.service.impl.EmployeeServiceImpl;
import com.ming.util.RequestUtil;
import com.ming.util.ResponseUtil;
import com.ming.vo.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/api/update")
public class UpdateEmp extends HttpServlet {
	EmployeeService service = new EmployeeServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Employee of = RequestUtil.post(req, Employee.class);
		System.out.println(of.toString());
		Result result = service.updateByPrimaryKeySelective(of);
		ResponseUtil.result2Client(resp,result);
	}
}
