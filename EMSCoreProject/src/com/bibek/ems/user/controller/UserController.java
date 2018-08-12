package com.bibek.ems.user.controller;

import com.bibek.ems.exception.DatabaseException;
import com.bibek.ems.exception.InvalidInputException;
import com.bibek.ems.model.User;
import com.bibek.ems.user.service.UserService;
import com.bibek.ems.user.service.impl.UserServiceImpl;

public class UserController {
	
	UserService userService=new UserServiceImpl();
	
	public Boolean changePassword(User user, String newPassword) throws InvalidInputException, DatabaseException {
		return userService.changePassword(user, newPassword);
	}

}
