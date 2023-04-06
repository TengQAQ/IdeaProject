package com.ming.web.servlet;

import com.ming.entity.HxzyExamGoodsCategory;
import com.ming.service.HxzyExamGoodsCategoryService;
import com.ming.service.impl.HxzyExamGoodsCategoryServiceImpl;
import com.ming.utils.RequestUtil;
import com.ming.utils.ResponseUtil;
import com.ming.vo.CodeEnum;
import com.ming.vo.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/api/updateCate")
public class UpdateServlet extends HttpServlet {
	private HxzyExamGoodsCategoryService service = new HxzyExamGoodsCategoryServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HxzyExamGoodsCategory category = RequestUtil.post(req, HxzyExamGoodsCategory.class);
		if (category == null){
			Result result = Result.of(CodeEnum.FAILURE);
			ResponseUtil.result2Client(resp,result);
		}
		Result result = service.updateByPrimaryKeySelective(category);
		ResponseUtil.result2Client(resp,result);
	}
}
