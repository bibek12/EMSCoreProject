package com.bibek.ems.user.service.impl;

import java.sql.SQLException;

import com.bibek.ems.exception.DatabaseException;
import com.bibek.ems.exception.InvalidInputException;
import com.bibek.ems.model.User;
import com.bibek.ems.user.dao.UserDao;
import com.bibek.ems.user.dao.impl.UserDaoImpl;
import com.bibek.ems.user.service.UserService;

public class UserServiceImpl implements UserService {

	UserDao userDao=new UserDaoImpl();
	@Override
	public Boolean changePassword(User user, String newPassword) throws InvalidInputException, DatabaseException {
		if(newPassword==null || newPassword.isEmpty()) {
			throw new InvalidInputException("password should not be null or empty");
		}
		try {
			return userDao.changePassword(user, newPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException("Failed to changed password");
		}
		
	}

}
