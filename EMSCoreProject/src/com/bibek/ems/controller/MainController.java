package com.bibek.ems.controller;


import java.sql.SQLException;
import java.util.Scanner;

import com.bibek.ems.exception.DatabaseException;
import com.bibek.ems.exception.InvalidInputException;
import com.bibek.ems.login.service.LoginService;
import com.bibek.ems.login.service.impl.LoginServiceImpl;
import com.bibek.ems.model.User;
import com.bibek.ems.user.controller.UserController;

import ems.bibek.ems.dao.UserRole;

public class MainController {
	LoginService loginservice = new LoginServiceImpl();
	UserController userController=new UserController();
	public static void main(String[] args) throws SQLException {
		MainController mainController = new MainController();
		Scanner sc = new Scanner(System.in);
		System.out.println("\t\t\t\t ~~Employee Managment System~~");
		for (;;) {
			try {
				System.out.println("Enter UserName::");
				String userName = sc.nextLine();
				if (!mainController.loginservice.VerifyUserName(userName)) {
					System.out.println("User name is not present. Login failed");
					continue;
				}
				System.out.println("Enter Password::");
				String password =sc.nextLine();
				User user = mainController.loginservice.Login(userName, password);
				/**
				 * checking user name is null
				 */
				if (user != null && user.getId() != null) {
					System.out.println("Login Succesfull.");
					System.out.printf("Welcome back %s ", userName);
				}else {
					System.out.println("Login failed. Try Again");
					continue;
				}
				int option;
				if(UserRole.ADMIN.getRole().equalsIgnoreCase(user.getRole())) {
					for (;;) {
						System.out.println("\n\n");
						System.out.println("1. Add Employee \t\t\t 2. Edit Employee \t\t\t");
						System.out.println("3. Delete Employee \t\t\t 4. Search Employee \t\t\t");
						System.out.println("5. Add Attendance \t\t\t 6. Edit Attendance \t\t\t");
						System.out.println("7. Change Password");
						System.out.println("8. Logout");
						System.out.println("Select an option");
						option = sc.nextInt();
						mainController.handleOption(user, option, sc);
					}
				}else if(UserRole.User.getRole().equalsIgnoreCase(user.getRole())) {
					for (;;) {
						System.out.println("\n\n");
						System.out.println("1. Edit Employee Information");
						System.out.println("2. Search Employee");
						System.out.println("3. Add Attendance");
						System.out.println("4. Change Password");
						System.out.println("5. Logout");
						System.out.println("Select an option");
						option = sc.nextInt();
						mainController.handleOption(user, option, sc);
					}
				}
			} catch (InvalidInputException | DatabaseException e1) {
				e1.printStackTrace();
				
			}

		}
		
		

	}
	
	public void handleOption(User user,int option,Scanner sc) {
		if(UserRole.ADMIN.getRole().equals(user.getRole())) {
			switch(option) {
				case 7:
					changePassword(user,sc);
					break;
				default:
					break;
			}
		}else if(UserRole.User.getRole().equals(user.getRole())) {
			switch(option) {
			case 4:
				changePassword(user,sc);
				break;
			default:
				break;
		}
	}
}
	
	public void changePassword(User user,Scanner sc) {
		
		System.out.println("Enter password::");
		String password1=sc.next();
		System.out.println("RE-Enter Password::");
		String password2=sc.next();
		if(password1.equals(password2))
		{
			try {
				Boolean result=userController.changePassword(user, password1);
				if(result==Boolean.TRUE) {
					System.out.println("password succesfully changed");
				}
			} catch (InvalidInputException | DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("Invalid Password!! Password donot match");
		}
		
	}

}
