package com.foundgrounds.users;

//import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserRepository dao;

	
	@GetMapping("/users")
	public List<User> getUsers() {
		List<User> foundUsers = dao.findAll();
		return foundUsers;
	}

	@GetMapping("/users/{userId}")
	public ResponseEntity<User> getUser(@PathVariable(value = "userId") Integer userId) {
		User foundUser = dao.findById(userId).orElse(null);

		if (foundUser == null) {
			return ResponseEntity.notFound().header("User", "Nothing found with that id").build();
		}
		return ResponseEntity.ok(foundUser);
	}

	@PostMapping("/users")
	public ResponseEntity<User> postUser(@RequestBody User user) {

		// saving to DB using instance of the repo interface
		User createdUser = dao.save(user);

		// RespEntity crafts response to include correct status codes.
		return ResponseEntity.ok(createdUser);
	}

	@SuppressWarnings("static-access")
	@PutMapping("/users/{userId}")
	public ResponseEntity<User> putUser(@PathVariable Integer userId, @RequestBody User user) {
		User foundUser = dao.findById(userId).orElse(null);
		if (foundUser == null) {
			return ResponseEntity.notFound().header("User", "Nothing found with that id").build();
		} else {
//			if (User.getUsername() != null) {
//				User.setUsername(User.getUsername());
//			}
//			if (User.getPassword() != null) {
//				User.setPassword(User.getPassword());
//			}
			foundUser.setUsername(user.getUsername());
			foundUser.setPassword(user.getPassword());
			foundUser.setRoleId(user.getRoleId());
			foundUser.setEmail(user.getEmail());
			foundUser.setAuthToken(user.getAuthToken());
			foundUser.setFirstName(user.getFirstName());
			foundUser.setLastName(user.getLastName());
			foundUser.setCanAdvertise(user.getCanAdvertise());
			foundUser.setStreetAddress1(user.getStreetAddress1());
			foundUser.setStreetAddress2(user.getStreetAddress2());
			foundUser.setCity(user.getCity());
			foundUser.setState(user.getState());
			foundUser.setZip(user.getZip());
			foundUser.setAmHome(user.getAmHome());
			foundUser.setBirthday(user.getBirthday());
			foundUser.setImageUrl(user.getImageUrl());
			foundUser.setDeleted(user.getDeleted());
			foundUser.setDateJoined(user.getDateJoined());
			foundUser.setBio(user.getBio());
			foundUser.setEdited(user.getEdited());
			
			dao.save(foundUser);
		}
		return ResponseEntity.ok(foundUser);
	}

	@DeleteMapping("/users/{userId}")
	public ResponseEntity<User> deleteUser(@PathVariable(value = "userId") Integer userId) {
		User foundUser = dao.findById(userId).orElse(null);

		if (foundUser == null) {
			return ResponseEntity.notFound().header("User", "Nothing found with that id").build();
		} else {
			dao.delete(foundUser);
		}
		return ResponseEntity.ok().build();
	}

}


