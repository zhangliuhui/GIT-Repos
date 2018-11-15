package org.lucas.funny.console.service.impl;

import org.lucas.funny.console.mapper.TUserMapper;
import org.lucas.funny.console.model.TUserModel;
import org.lucas.funny.console.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	TUserMapper userMapper;

	@Override
	public TUserModel login(String username, String password) {
		return userMapper.selectByUsernameAndPasswd(username, password);
	}
	
	@Override
	public TUserModel selectByUsername(String username) {
		return userMapper.selectByUsername(username);
	}

}
