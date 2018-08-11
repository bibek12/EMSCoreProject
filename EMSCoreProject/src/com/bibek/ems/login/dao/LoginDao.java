package com.bibek.ems.login.dao;

import java.sql.SQLException;

import com.bibek.ems.model.User;

public interface LoginDao {
	
	Boolean verifyUserName(String userName) throws SQLException;
	User login(String userName,String password) throws SQLException;

}
