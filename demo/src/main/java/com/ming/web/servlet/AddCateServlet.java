package com.ming.web.servlet;

import com.ming.dto.DelateCateDto;
import com.ming.entity.HxzyExamGoodsCategory;
import com.ming.service.HxzyExamGoodsCategoryService;
import com.ming.service.impl.HxzyExamGoodsCategoryServiceImpl;
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

@WebServlet("/api/addcate")
public class AddCateServlet extends HttpServlet {
	private HxzyExamGoodsCategoryService service = new HxzyExamGoodsCategoryServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		HxzyExamGoodsCategory dto = RequestUtil.post(req, HxzyExamGoodsCategory.class);
		//获取当前时间
		Date date = new Date(System.currentTimeMillis());
		dto.setIsDeleted(0);
		dto.setCreateTime(date);
		dto.setUpdateTime(date);
		System.out.println(dto.toString());
		Result result = service.insertSelective(dto);
		ResponseUtil.result2Client(resp,result);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DelateCateDto dto = RequestUtil.of(req, DelateCateDto.class);
		System.out.println("删除数据=========dto》" + dto);
		Result result = service.DeleteCategory(dto);
		ResponseUtil.result2Client(resp,result);
	}
}
