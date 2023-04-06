package com.hxzy.service.Impl;

import com.hxzy.Dto.PageDto;
import com.hxzy.Dto.SearchDto;
import com.hxzy.service.ElementaryService;
import org.junit.Test;

import static org.junit.Assert.*;

public class ElementaryServiceImplTest {
	private ElementaryService service = new ElementaryServiceImpl();

	@Test
	public void selectAllElementary(SearchDto dto) {
		dto.setPageNum(2);
		service.SelectAllElementary(dto);
	}
}