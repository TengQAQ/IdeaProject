package com.ming.web.servlet;

import com.alibaba.fastjson2.JSONObject;
import com.ming.Dto.EmployeeDto;
import com.ming.Dto.PageDto;
import com.ming.entity.Employee;
import com.ming.service.EmployeeService;
import com.ming.service.impl.EmployeeServiceImpl;
import com.ming.util.RequestUtil;
import com.ming.vo.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet("/api/employee")
public class EmployeeServlet extends HttpServlet {
	EmployeeService service = new EmployeeServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PageDto pageDto = new PageDto();
		// 从request请求中获取所有的url参数名
		Enumeration<String> parameterNames = req.getParameterNames();
		JSONObject jsonObject = new JSONObject();
		// 类似于一个迭代器
		while (parameterNames.hasMoreElements()) {
			// 得到参数名
			String key = parameterNames.nextElement();
			// 从request中根据参数名获取值
			String parameter = req.getParameter(key);
			System.out.println(key + " --------------------->" + parameter);
			// 将url参数以及值插入到map集合
			jsonObject.put(key, parameter);
		}
		if(jsonObject.containsKey("pageNum")) {
			Object pageNum = jsonObject.get("pageNum");
			System.out.println(pageNum);
		}
		EmployeeDto dto = jsonObject.to(EmployeeDto.class);
//		System.out.println("============>"+pageDto.getPageNum());
//		System.out.println("============>"+pageDto.getSize());
//		dto.setPageNum(pageDto.getPageNum());
//		dto.setSize(pageDto.getSize());
//		System.out.println("================emp:" + dto.toString() + "dto.getPageNum()" + dto.getPageNum() + dto.getSize());
		Result result = service.selectAll(dto);
		// 记住fast json将java对象转换为json字符串
		/*
		 * JSONObject:  提供了java对象和json字符串的相互转换
		 *               toJSONString(javaObject) 将java对象转换为json字符串
		 *               parseObject(json) 将字符串json还原为Java对象；默认是一个Map集合
		 *               parseObject(json,Class<?>) 将json还原为指定类型的java对象
		 * JSONArray: 提供共java集合和json字符串的相互转换
		 * */
		String jsonString = JSONObject.toJSONString(result);
		try (PrintWriter writer = resp.getWriter()) {
			writer.write(jsonString);
			writer.flush();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try (
				ServletInputStream inputStream = req.getInputStream();
				InputStreamReader reader = new InputStreamReader(inputStream, "utf-8");
				BufferedReader bufferedReader = new BufferedReader(reader);
				PrintWriter printWriter = resp.getWriter()
		) {
			String line;
			StringBuilder builder = new StringBuilder();
			while ((line = bufferedReader.readLine()) != null) {
				builder.append(line);
			}
			String json = builder.toString();
			System.out.println("==========输出json：（" + json);
			Employee employee = JSONObject.parseObject(json, Employee.class);
			System.out.println("==========输出json：（" + employee.toString());
			if (employee != null) {
				Result result;
				result = service.insertSelective(employee);

				String toJSONString = JSONObject.toJSONString(result);
				printWriter.write(toJSONString);
				printWriter.close();
			}else {
				System.out.println("==========输出json：（" + json + "）");
			}
		}
//		EmployeeDto dto = RequestUtil.of(req, EmployeeDto.class);
//		service.selectAll(dto);
	}
}
