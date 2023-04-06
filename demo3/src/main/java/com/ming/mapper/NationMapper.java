package com.ming.mapper;

import com.ming.entity.Nation;
import com.ming.entity.Politicsstatus;

import java.util.List;

/**
* @author QinTeng
* @description 针对表【nation(籍贯表)】的数据库操作Mapper
* @createDate 2023-03-24 14:07:03
* @Entity com.ming.entity.Nation
*/
public interface NationMapper extends BaseMapper<Integer,Nation>{
	List<Nation> allNation();
}
