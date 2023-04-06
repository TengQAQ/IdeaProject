package com.hxzy.mapper;

import com.hxzy.Dto.PageDto;
import com.hxzy.Dto.SearchDto;
import com.hxzy.entity.Elementary;

import java.util.List;

/**
* @author QinTeng
* @description 针对表【elementary(孕妇表)】的数据库操作Mapper
* @createDate 2023-03-06 21:55:19
* @Entity com.hxzy.entity.Elementary
*/
public interface ElementaryMapper extends BaseMapper<String,Elementary>{


    List<Elementary> SelectAllElementary(SearchDto dto);
}
