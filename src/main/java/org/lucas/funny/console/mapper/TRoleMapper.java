package org.lucas.funny.console.mapper;

import java.util.List;

import org.lucas.funny.console.model.TRoleModel;

public interface TRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(TRoleModel model);

    int insertSelective(TRoleModel model);

    TRoleModel selectByPrimaryKey(String id);
    
    List<TRoleModel> selectRolesByUserid(String id);

    int updateByPrimaryKeySelective(TRoleModel model);

    int updateByPrimaryKey(TRoleModel model);
}