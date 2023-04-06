package com.ming.mapper;

import com.ming.entity.Joblevel;
import com.ming.entity.Nation;

import java.util.List;

/**
* @author QinTeng
* @description 针对表【joblevel(职称表)】的数据库操作Mapper
* @createDate 2023-03-24 14:27:32
* @Entity com.ming.entity.Joblevel
*/
public interface JoblevelMapper extends BaseMapper<Integer,Joblevel>{
    List<Joblevel> allJoblevel();

}
