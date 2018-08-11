package com.bibek.ems.controller;


import java.sql.SQLException;
import java.util.Scanner;

import com.bibek.ems.exception.DatabaseException;
import com.bibek.ems.exception.InvalidInputException;
import com.bibek.ems.login.service.LoginService;
import com.bibek.ems.login.service.impl.LoginServiceImpl;
import com.bibek.ems.model.User;

public class MainController {
	LoginService loginservice = new LoginServiceImpl();

	public static void main(String[] args) throws SQLException {
		MainController mainController = new MainController();
		Scanner sc = new Scanner(System.in);
		for (;;) {
			User user=null;
			System.out.println("\t\t\t\t ~~Employee Managment System~~");
			
			try {
				System.out.println("Enter UserName:");
				String userName = null;
				userName=sc.nextLine();
				if(userName.isEmpty())
					continue;
				if (!mainController.loginservice.VerifyUserName(userName)) {
					System.out.println("User name is not present. Login failed");
					continue;
				}
				System.out.println("Enter Password:");
				String password = null;
				if(sc.hasNext()) {
					password=sc.nextLine();
				}
				user = mainController.loginservice.Login(userName, password);
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
				break;
			} catch (InvalidInputException | DatabaseException e1) {
				e1.printStackTrace();
				System.out.println("\n\n\n\n");
				sc.nextLine();
			}

		}

	}

}
