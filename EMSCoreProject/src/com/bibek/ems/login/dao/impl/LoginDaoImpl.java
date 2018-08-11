package com.bibek.ems.login.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bibek.ems.login.dao.LoginDao;
import com.bibek.ems.model.User;
import com.bibek.ems.utils.DatabaseConnection;

public class LoginDaoImpl implements LoginDao{

	@Override
	public Boolean verifyUserName(String userName) throws SQLException {
		Connection conn=DatabaseConnection.getInstance();
		PreparedStatement ps=conn.prepareStatement("select * from user where user_name=?");
		ps.setString(1, userName);
		ResultSet rs=ps.executeQuery();
		Integer id=null;
		while(rs.next()) {
			id=rs.getInt(1);
		}
		if(id!=null) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
		
	}

	@Override
	public User login(String userName, String password) throws SQLException {
		Connection conn=DatabaseConnection.getInstance();
		PreparedStatement ps=conn.prepareStatement("select * from user where user_name = ? and password = password(?)");
		ps.setString(1, userName);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		User user=new User();
		while(rs.next()) {
			user.setId(rs.getInt(1));
			user.setUserName(rs.getString(2));
			user.setRole(rs.getString(4));
		}
		return user;
	}
	
	

}
