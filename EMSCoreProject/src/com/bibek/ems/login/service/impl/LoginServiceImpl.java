package com.bibek.ems.login.service.impl;


import java.sql.SQLException;

import com.bibek.ems.exception.DatabaseException;
import com.bibek.ems.exception.InvalidInputException;
import com.bibek.ems.login.dao.LoginDao;
import com.bibek.ems.login.dao.impl.LoginDaoImpl;
import com.bibek.ems.login.service.LoginService;
import com.bibek.ems.model.User;


public class LoginServiceImpl implements LoginService {
	LoginDao loginDao = new LoginDaoImpl();

	@Override
	public Boolean VerifyUserName(String userName) throws InvalidInputException, DatabaseException {
		if (userName == null || userName.isEmpty()) {
			throw new InvalidInputException("UserName should not be empty or null");
		}
		try {
			return loginDao.verifyUserName(userName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException("Some error while connecting to database");
		}
		

	}

	@Override
	public User Login(String userName, String password) throws InvalidInputException, DatabaseException {
		if(userName==null || userName.isEmpty()) {
			throw new InvalidInputException("UserName should not be empty or null");
		}
		if(password==null ||password.isEmpty()) {
			throw new InvalidInputException("Password should not be empty or null");
		}
		try {
			return loginDao.login(userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException("Some error while connecting to database");
		}
		
	}

}
