package com.foundgrounds.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foundgrounds.users.User;
import com.foundgrounds.users.UserRepository;

@RestController
@RequestMapping("/api")
public class MenuController {

	@Autowired
	UserRepository dao;

	@GetMapping("/user")
	public List<User> getUser() {
		List<User> foundUsers = dao.findAll();
		return foundUsers;
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable(value = "id") Long id) {
		User foundUser = dao.findById(id).orElse(null);

		if (foundUser == null) {
			return ResponseEntity.notFound().header("User", "Nothing found with that id").build();
		}
		return ResponseEntity.ok(foundUser);
	}

	@PostMapping("/user")
	public ResponseEntity<User> postUser(@RequestBody User user) {

		// saving to DB using instance of the repo interface
		User createdUser = dao.save(user);

		// RespEntity crafts response to include correct status codes.
		return ResponseEntity.ok(createdUser);
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<User> putUser(@PathVariable Long id, @RequestBody User user) {
		User foundUser = dao.findById(id).orElse(null);
		if (foundUser == null) {
			return ResponseEntity.notFound().header("User", "Nothing found with that id").build();
		} else {
			if (User.getUsername() != null) {
				User.setUsername(User.getUsername());
			}
			if (User.getPassword() != null) {
				User.setPassword(User.getPassword());
			}
			dao.save(foundUser);
		}
		return ResponseEntity.ok(foundUser);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable(value = "id") Long id) {
		User foundUser = dao.findById(id).orElse(null);

		if (foundUser == null) {
			return ResponseEntity.notFound().header("User", "Nothing found with that id").build();
		} else {
			dao.delete(foundUser);
		}
		return ResponseEntity.ok().build();
	}
}
//	public Boolean IsAuthenticated(String UserName, String Password) {
//		Boolean success = false;
//		
//		//Create SQL statement to grab row with username and password
//		
//		if() {
//			success = true;
//			GetUserInfo();
//		}
//		else {
//			success = false;
//		}
//
//		return success;
//
//	}
//	
//	public static void InsertUser() {
//		
//		//Create a sql statement that takes the User info and
//		//Inserts it into the database. 
//	}
//	
//	public User GetUserInfo() {
//		User newUser = new User();
//
//		newUser{
//			
//		}
//		
//		return newUser
//	}

