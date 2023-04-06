package com.ming.web.servlet;

import com.ming.service.HxzyExamCategoryService;
import com.ming.service.impl.HxzyExamCategoryServiceImpl;
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
import java.util.Iterator;
import java.util.List;

@WebServlet("/api/DelCate")
public class DelCateServlet extends HttpServlet {
	private HxzyExamCategoryService service = new HxzyExamCategoryServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List list = RequestUtil.post(req, List.class);
//		System.out.println(list.);
		Iterator iterator = list.iterator();
		while (iterator.hasNext()){
			System.out.println(iterator.next());
		}
		Result result = service.BashDelCate(list);
		ResponseUtil.result2Client(resp,result);
	}
}
