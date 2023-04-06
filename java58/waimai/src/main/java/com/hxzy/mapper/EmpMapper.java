package com.hxzy.mapper;

import com.hxzy.entity.Emp;
import java.math.BigDecimal;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpMapper extends BaseMapper<Emp,BigDecimal>{
    Emp selectByUserName(String name);
}