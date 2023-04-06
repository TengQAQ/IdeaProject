package com.ming.mapper;

import com.ming.entity.Politicsstatus;

import java.security.AllPermission;
import java.util.List;

/**
* @author QinTeng
* @description 针对表【politicsstatus(政治面貌表)】的数据库操作Mapper
* @createDate 2023-03-24 13:12:28
* @Entity com.ming.entity.Politicsstatus
*/
public interface PoliticsstatusMapper extends BaseMapper<Integer,Politicsstatus>{
    List<Politicsstatus> allPoliticsstatus();
}
