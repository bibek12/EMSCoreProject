package com.bibek.ems.user.service;

import com.bibek.ems.exception.DatabaseException;
import com.bibek.ems.exception.InvalidInputException;
import com.bibek.ems.model.User;

public interface UserService {
	
	Boolean changePassword(User user,String newPassword) throws InvalidInputException, DatabaseException;

}
