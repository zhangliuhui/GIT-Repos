package org.lucas.funny.console.mapper;

import org.lucas.funny.console.model.TMenuModel;

public interface TMenuMapper {
    int deleteByPrimaryKey(String id);

    int insert(TMenuModel model);

    int insertSelective(TMenuModel model);

    TMenuModel selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TMenuModel model);

    int updateByPrimaryKey(TMenuModel model);
}