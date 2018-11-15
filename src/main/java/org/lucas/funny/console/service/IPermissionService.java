package org.lucas.funny.console.service;

import java.util.List;

import org.lucas.funny.console.model.TPermissionModel;

public interface IPermissionService {
	List<TPermissionModel> selectPermissionsByRoleid(String id);
	List<TPermissionModel> selectPermissionsByUserid(String id);
}
