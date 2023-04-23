package com.hxzy.mapper;

import com.hxzy.dto.ContamerSearchDTO;
import com.hxzy.entity.Cont;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author QinTeng
* @description 针对表【CONTAMER】的数据库操作Mapper
* @createDate 2023-04-13 00:25:27
* @Entity com.hxzy.entity.Cont
*/
@Mapper
public interface ContMapper extends BaseMapper<Long,Cont>{

    List<Cont> search(@Param("dto") ContamerSearchDTO dto);
}
