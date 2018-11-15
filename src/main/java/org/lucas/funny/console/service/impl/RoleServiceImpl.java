package org.lucas.funny.console.service.impl;

import java.util.List;

import org.lucas.funny.console.mapper.TRoleMapper;
import org.lucas.funny.console.model.TRoleModel;
import org.lucas.funny.console.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleService {
	@Autowired
	TRoleMapper roleMapper;

	@Override
	public List<TRoleModel> selectRolesByUserid(String id) {
		return roleMapper.selectRolesByUserid(id);
	}

}
