package com.foundgrounds.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	UserRepository dao;
	
	
	public Boolean IsAuthenticated(String UserName, String Password) {
		Boolean success = false;
		
		//Create SQL statement to grab row with username and password
		
		if() {
			success = true;
			GetUserInfo();
		}
		else {
			success = false;
		}

		return success;

	}
	
	public static void InsertUser() {
		
		//Create a sql statement that takes the User info and
		//Inserts it into the database. 
	}
	
	public User GetUserInfo() {
		User newUser = new User();

		newUser{
			
		}
		
		return newUser
	}
}
