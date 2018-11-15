package org.lucas.funny.console.mapper;

import org.apache.ibatis.annotations.Param;
import org.lucas.funny.console.model.TUserModel;

public interface TUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(TUserModel model);

    int insertSelective(TUserModel model);

    TUserModel selectByPrimaryKey(String id);
    
    TUserModel selectByUsername(String username);
    
    TUserModel selectByUsernameAndPasswd(@Param("username")String username, @Param("password")String password);

    int updateByPrimaryKeySelective(TUserModel model);

    int updateByPrimaryKey(TUserModel model);
}