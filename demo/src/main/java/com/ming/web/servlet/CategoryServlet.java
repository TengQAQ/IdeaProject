package com.ming.web.servlet;

import com.alibaba.fastjson2.JSONObject;
import com.ming.dto.PageDto;
import com.ming.service.HxzyExamGoodsCategoryService;
import com.ming.service.impl.HxzyExamGoodsCategoryServiceImpl;
import com.ming.utils.RequestUtil;
import com.ming.vo.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;

@WebServlet("/api/category")
public class CategoryServlet extends HttpServlet {
	private HxzyExamGoodsCategoryService service = new HxzyExamGoodsCategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PageDto dto = RequestUtil.of(req, PageDto.class);
		Result result = service.selectAll(dto);
		String toJSONString = JSONObject.toJSONString(result);
		try(Writer writer = resp.getWriter()){
			writer.write(toJSONString);
			writer.flush();
		}

	}
}
