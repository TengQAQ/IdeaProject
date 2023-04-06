package com.ming.servlet;

import com.alibaba.fastjson2.JSONObject;
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

@WebServlet("/api/delete")
public class deleteServlet extends HttpServlet {
	// 业务逻辑层
	private final GoodsInfoService service = new GoodsInfoServiceImpl();

//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String pageNum = req.getParameter("goodId");
//		if (pageNum != null && pageNum.trim().length() > 0) {
//			// 设置分页查询的页码
//
//		}
//	}

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
				Result result = null;
				System.out.println(goodsInfo.toString());
				if (goodsInfo.getGoodsId() == null) {
					result = service.deleteByPrimaryKey(goodsInfo.getGoodsId());
				}
				String toJSONString = JSONObject.toJSONString(result);
				printWriter.write(toJSONString);
				printWriter.close();
			}else {
				System.out.println("已经获取到请求，但是没有接收到参数值");
			}

		}
	}
}
