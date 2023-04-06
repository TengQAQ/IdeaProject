package com.ming.web.servlet;

import com.ming.dto.PageDto;
import com.ming.entity.DeliveryAddr;
import com.ming.service.DeliveryAddrService;
import com.ming.service.impl.DeliveryAddrServiceImpl;
import com.ming.util.RequestUtil;
import com.ming.util.ResponseUtil;
import com.ming.vo.Result;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/api/addDel")
public class addDelServlet extends HttpServlet {
	private DeliveryAddrService service = new DeliveryAddrServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DeliveryAddr dto = RequestUtil.post(req, DeliveryAddr.class);
		System.out.println(dto.toString());
//		PageDto dto = new PageDto();
		Result result = service.insertSelective(dto);
		ResponseUtil.result2Client(resp,result);
	}
}
