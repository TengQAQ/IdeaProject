package com.hxzy.service;

import com.hxzy.Dto.PageDto;
import com.hxzy.Dto.SearchDto;
import com.hxzy.entity.Elementary;
import com.hxzy.vo.Result;

import java.util.List;

public interface ElementaryService extends BaseService<String, Elementary>{
	Result SelectAllElementary(SearchDto dto);
}
