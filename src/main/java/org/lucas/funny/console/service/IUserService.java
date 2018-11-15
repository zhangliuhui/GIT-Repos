package org.lucas.funny.console.service;

import org.lucas.funny.console.model.TUserModel;

public interface IUserService {
	TUserModel login(String username, String password);
	TUserModel selectByUsername(String username);
}
