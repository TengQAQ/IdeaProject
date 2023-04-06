package com.ming.web.servlet;

import com.alibaba.fastjson2.JSONObject;
import com.ming.dto.PageDto;
import com.ming.service.HxzyExamCategoryService;
import com.ming.service.impl.HxzyExamCategoryServiceImpl;
import com.ming.utils.RequestUtil;
import com.ming.utils.ResponseUtil;
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
	private HxzyExamCategoryService service = new HxzyExamCategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		PageDto dto = RequestUtil.of(req, PageDto.class);
		Result result = service.selectAll();
		System.out.println(result);
		ResponseUtil.result2Client(resp,result);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String post = RequestUtil.post(req, String.class);
		System.out.println(post);
		Result result = service.gradeJudgment(Long.valueOf(post));
		ResponseUtil.result2Client(resp,result);

	}

}
