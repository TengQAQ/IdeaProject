package com.hxzy.mapper;

import com.hxzy.entity.HxzyExamAdminUserToken;

/**
* @author Administrator
* @description 针对表【hxzy_exam_admin_user_token】的数据库操作Mapper
* @createDate 2023-03-13 09:46:35
* @Entity com.hxzy.entity.HxzyExamAdminUserToken
*/
public interface HxzyExamAdminUserTokenMapper extends BaseMapper<Long,HxzyExamAdminUserToken> {
    HxzyExamAdminUserToken selectByToken(String token);

    /**
     * 根据令牌删除登录信息
     * @param token
     * @return
     */
    int deleteByToken(String token);


}
