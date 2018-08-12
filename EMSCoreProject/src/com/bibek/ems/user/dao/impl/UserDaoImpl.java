package com.bibek.ems.user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bibek.ems.model.User;
import com.bibek.ems.user.dao.UserDao;
import com.bibek.ems.utils.DatabaseConnection;

public class UserDaoImpl  implements UserDao{

	@Override
	public Boolean changePassword(User user, String newPassword) throws SQLException {
		Connection conn=DatabaseConnection.getInstance();
		PreparedStatement ps=conn.prepareStatement("UPDATE user SET password=password('?') where id =?");
		ps.setString(1, newPassword);
		ps.setInt(1,user.getId() );
		ps.executeUpdate();
		return Boolean.TRUE;
	}
	
	

}
