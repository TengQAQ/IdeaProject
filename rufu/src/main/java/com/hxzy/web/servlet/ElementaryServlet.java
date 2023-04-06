package com.hxzy.web.servlet;

import com.alibaba.fastjson2.JSONObject;
import com.hxzy.Dto.PageDto;
import com.hxzy.Dto.SearchDto;
import com.hxzy.entity.Elementary;
import com.hxzy.service.ElementaryService;
import com.hxzy.service.Impl.ElementaryServiceImpl;
import com.hxzy.vo.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/api/ele")
public class ElementaryServlet extends HttpServlet {
	private ElementaryService service =new ElementaryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		PageDto pageDto = new PageDto();
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
		SearchDto dto = jsonObject.to(SearchDto.class);
		System.out.println(dto.toString());
		Result result = service.SelectAllElementary(dto);
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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try (BufferedReader reader = req.getReader()) {
			StringBuilder builder = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}

			String json = builder.toString();

			Elementary elementary = JSONObject.parseObject(json, Elementary.class);
			elementary.setElementaryId(elementary.getNumberId());
			System.out.println("ele =======================" + elementary);
			Result result = service.insertSelective(elementary);
			String jsonString = JSONObject.toJSONString(result);
			PrintWriter writer = resp.getWriter();
			writer.write(jsonString);
			writer.flush();
			writer.close();
		}
	}
}
