package com.bibek.ems.login.service;

import java.sql.SQLException;

import com.bibek.ems.exception.DatabaseException;
import com.bibek.ems.exception.InvalidInputException;
import com.bibek.ems.model.User;

public interface LoginService {
	
	 Boolean VerifyUserName(String userName) throws InvalidInputException, DatabaseException;
	 User Login(String userName,String password) throws SQLException, InvalidInputException, DatabaseException;
}
