package org.lucas.funny.console.mapper;

import java.util.List;

import org.lucas.funny.console.model.TPermissionModel;

public interface TPermissionMapper {
    int deleteByPrimaryKey(String id);

    int insert(TPermissionModel model);

    int insertSelective(TPermissionModel model);

    TPermissionModel selectByPrimaryKey(String id);
    
    List<TPermissionModel> selectPermissionsByRoleid(String id);
    
    List<TPermissionModel> selectPermissionsByUserid(String id);

    int updateByPrimaryKeySelective(TPermissionModel model);

    int updateByPrimaryKey(TPermissionModel model);
}