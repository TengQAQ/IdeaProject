package com.hxzy.service;

import com.hxzy.vo.Result;

public interface BaseService<fk,model>{
  Result deleteByPrimaryKey(fk id);

    Result insert(model record);

    Result insertSelective(model record);

    Result selectByPrimaryKey(fk id);

    Result updateByPrimaryKeySelective(model record);

    Result updateByPrimaryKey(model record);
}
