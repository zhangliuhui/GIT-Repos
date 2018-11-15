package org.lucas.funny.console.service;

import java.util.List;

import org.lucas.funny.console.model.TRoleModel;

public interface IRoleService {
	List<TRoleModel> selectRolesByUserid(String id);
}
