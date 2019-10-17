package com.foundgrounds.users;

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
public class UserController {

	@Autowired
	UserRepository dao;

	@GetMapping("/user")
	public List<User> getUser() {
		List<User> foundMessages = dao.findAll();
		return foundMessages;
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable(value = "id") Long id) {
		User foundMessage = dao.findById(id).orElse(null);

		if (foundMessage == null) {
			return ResponseEntity.notFound().header("Message", "Nothing found with that id").build();
		}
		return ResponseEntity.ok(foundMessage);
	}

	@PostMapping("/user")
	public ResponseEntity<User> postMessage(@RequestBody User message) {

		// saving to DB using instance of the repo interface
		User createdMessage = dao.save(message);

		// RespEntity crafts response to include correct status codes.
		return ResponseEntity.ok(createdMessage);
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<User> putMessage(@PathVariable Long id, @RequestBody User message) {
		User foundMessage = dao.findById(id).orElse(null);
		if (foundMessage == null) {
			return ResponseEntity.notFound().header("Message", "Nothing found with that id").build();
		} else {
			if (User.getUsername() != null) {
				User.setUsername(User.getUsername());
			}
			if (User.getPassword() != null) {
				User.setPassword(User.getPassword());
			}
			dao.save(foundMessage);
		}
		return ResponseEntity.ok(foundMessage);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<User> deleteMessage(@PathVariable(value = "id") Long id) {
		User foundMessage = dao.findById(id).orElse(null);

		if (foundMessage == null) {
			return ResponseEntity.notFound().header("Message", "Nothing found with that id").build();
		} else {
			dao.delete(foundMessage);
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

