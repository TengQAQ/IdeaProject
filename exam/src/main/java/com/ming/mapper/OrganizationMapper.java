package com.ming.mapper;

import com.ming.entity.Organization;

import java.util.List;

/**
* @author QinTeng
* @description 针对表【organization】的数据库操作Mapper
* @createDate 2023-02-27 18:51:13
* @Entity com.ming.entity.Organization
*/
public interface OrganizationMapper {
	List<Organization> selectAll();
}
