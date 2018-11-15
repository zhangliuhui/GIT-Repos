package org.lucas.funny.console.service.impl;

import java.util.List;

import org.lucas.funny.console.mapper.TPermissionMapper;
import org.lucas.funny.console.model.TPermissionModel;
import org.lucas.funny.console.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements IPermissionService {
	@Autowired
	TPermissionMapper permissionMapper;

	@Override
	public List<TPermissionModel> selectPermissionsByRoleid(String id) {
		return permissionMapper.selectPermissionsByRoleid(id);
	}

	@Override
	public List<TPermissionModel> selectPermissionsByUserid(String id) {
		return permissionMapper.selectPermissionsByUserid(id);
	}

}
