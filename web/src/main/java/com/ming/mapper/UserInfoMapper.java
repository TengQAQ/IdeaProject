package com.ming.mapper;

import com.ming.entity.DeliveryAddr;
import com.ming.entity.UserInfo;

import java.util.List;

/**
* @author QinTeng
* @description 针对表【user_info】的数据库操作Mapper
* @createDate 2023-02-13 16:58:34
* @Entity com.ming.entity.UserInfo
*/
public interface UserInfoMapper extends BaseMapper<Long,UserInfo>{

    @Override
    Long deleteByPrimaryKey(Long id);

    @Override
    Long insert(UserInfo record);

    @Override
    Long insertSelective(UserInfo record);

    @Override
    UserInfo selectByPrimaryKey(Long id);

    @Override
    Long updateByPrimaryKeySelective(UserInfo record);

    @Override
    Long updateByPrimaryKey(UserInfo record);

}
