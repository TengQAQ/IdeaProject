package com.ming.web.servlet;

import com.ming.entity.HxzyExamCategory;
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
import java.util.Date;

@WebServlet("/api/addCate")
public class AddCateServlet extends HttpServlet {
	private HxzyExamCategoryService service = new HxzyExamCategoryServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		HxzyExamCategory dto = RequestUtil.post(req, HxzyExamCategory.class);
		//获取当前时间
		Date date = new Date(System.currentTimeMillis());
		dto.setCreateTime(date);
		dto.setModifyTime(date);
		System.out.println(dto.toString());
		Result result = service.insertSelective(dto);
		ResponseUtil.result2Client(resp,result);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HxzyExamCategory category = RequestUtil.of(req, HxzyExamCategory.class);
		System.out.println("查询父类目的" + category);
		Result result = service.selectByPrimaryKey(Long.valueOf(category.getParentId()));
		System.out.println(result.toString());
		ResponseUtil.result2Client(resp,result);
	}
}
