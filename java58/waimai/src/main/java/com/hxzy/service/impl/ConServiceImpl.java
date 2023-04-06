package com.hxzy.service.impl;


import com.hxzy.entity.Contamer;
import com.hxzy.mapper.ConMapper;
import com.hxzy.service.ConService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConServiceImpl extends BaseServiceImpl<Contamer,Long> implements ConService {

	private ConMapper conMapper;
	@Autowired
	public void setConMapper(ConMapper conMapper) {
		this.conMapper = conMapper;
		setMapper(conMapper);
	}

}
