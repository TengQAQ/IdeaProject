package com.ming.web.servlet;

import com.alibaba.fastjson2.JSONObject;
import com.ming.service.EmployeeService;
import com.ming.service.impl.EmployeeServiceImpl;
import com.ming.util.toIntArray;
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

@WebServlet("/api/delete")
public class deleteServlet extends HttpServlet implements toIntArray {
	private EmployeeService service = new EmployeeServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
			json = json.replace("[","");
			json = json.replace("]","");
			String[] ids=json.split(",");
//			int[] ints = toIntArray(ids);
			Result result;
			result = service.toDelete(ids);

			System.out.println(result.toString());

			String toJSONString = JSONObject.toJSONString(result);
			printWriter.write(toJSONString);
			printWriter.close();
		}
	}
}
