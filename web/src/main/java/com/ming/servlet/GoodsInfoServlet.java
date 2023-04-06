package com.ming.servlet;


import com.alibaba.fastjson2.JSONObject;
import com.ming.Dto.PageDto;
import com.ming.entity.GoodsInfo;
import com.ming.service.GoodsInfoService;
import com.ming.service.Impl.GoodsInfoServiceImpl;
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

@WebServlet("/api/goods")
public class GoodsInfoServlet extends HttpServlet {
	// 业务逻辑层
	private final GoodsInfoService service = new GoodsInfoServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PageDto dto = new PageDto();

		String pageNum = req.getParameter("pageNum");
		if (pageNum != null && pageNum.trim().length() > 0) {
			// 设置分页查询的页码
			dto.setPageNum(Integer.valueOf(pageNum));
		}

		String pageSize = req.getParameter("pageSize");
		if (pageSize != null && pageSize.trim().length() > 0) {
			dto.setSize(Integer.valueOf(pageSize));
		}

		// 执行分页查询，得到结果
		Result result = service.selectAll(dto);
		System.out.println(result.toString());
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
			GoodsInfo goodsInfo = JSONObject.parseObject(json, GoodsInfo.class);
			if (goodsInfo != null) {
				Result result;
				if (goodsInfo.getGoodsId() == null) {
					result = service.insertSelective(goodsInfo);
				} else {
					result = service.updateByPrimaryKeySelective(goodsInfo);
				}
				String toJSONString = JSONObject.toJSONString(result);
				printWriter.write(toJSONString);
				printWriter.close();
			}

		}

	}
}
