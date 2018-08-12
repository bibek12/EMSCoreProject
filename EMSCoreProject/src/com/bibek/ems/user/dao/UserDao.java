package com.bibek.ems.user.dao;

import java.sql.SQLException;

import com.bibek.ems.model.User;

public interface UserDao {
	
	Boolean changePassword(User user,String newPassword) throws SQLException;

}
