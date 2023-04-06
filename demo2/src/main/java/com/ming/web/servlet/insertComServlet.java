package com.ming.web.servlet;

import com.ming.entity.HxzyExamProduct;
import com.ming.service.HxzyExamProductService;
import com.ming.service.impl.HxzyExamProductServiceImpl;
import com.ming.utils.RequestUtil;
import com.ming.utils.ResponseUtil;
import com.ming.vo.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@WebServlet("/api/insertcom")
public class insertComServlet extends HttpServlet {
	HxzyExamProductService service = new HxzyExamProductServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HxzyExamProduct hxzyExamProduct = RequestUtil.post(req, HxzyExamProduct.class);
		String uuid = UUID.randomUUID().toString().replace("-","").substring(0,4);
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String str = format.format(new Date());
		System.out.println(str);
		hxzyExamProduct.setId("HK" + str + uuid);
		Result result = service.insertSelective(hxzyExamProduct);
		ResponseUtil.result2Client(resp,result);
	}
}
