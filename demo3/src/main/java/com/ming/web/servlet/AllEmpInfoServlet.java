package com.ming.web.servlet;

import com.ming.dto.EmpDto;
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

@WebServlet("/api/allempinfo")
public class AllEmpInfoServlet extends HttpServlet {
	private EmployeeServiceImpl service = new EmployeeServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmpDto empDto = RequestUtil.post(req, EmpDto.class);
		System.out.println(empDto.toString());
		Result result = service.allEmpInfo(empDto);
		ResponseUtil.result2Client(resp,result);
	}
}
