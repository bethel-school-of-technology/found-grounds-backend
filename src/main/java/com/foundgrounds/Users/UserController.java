package com.foundgrounds.Users;

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

import com.backendfinal.users.User;
import com.backendfinal.users.UserRepository;

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
		Users foundMessage = dao.findById(id).orElse(null);

		if (foundMessage == null) {
			return ResponseEntity.notFound().header("Message", "Nothing found with that id").build();
		}
		return ResponseEntity.ok(foundMessage);
	}

	@PostMapping("/user")
	public ResponseEntity<User> postMessage(@RequestBody Users message) {

		// saving to DB using instance of the repo interface
		Users createdMessage = dao.save(message);

		// RespEntity crafts response to include correct status codes.
		return ResponseEntity.ok(createdMessage);
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<User> putMessage(@PathVariable Long id, @RequestBody Users message) {
		Users foundMessage = dao.findById(id).orElse(null);
		if (foundMessage == null) {
			return ResponseEntity.notFound().header("Message", "Nothing found with that id").build();
		} else {
			if (Users.getUsername() != null) {
				Users.setUsername(Users.getUsername());
			}
			if (Users.getPassword() != null) {
				Users.setPassword(Users.getPassword());
			}
			dao.save(foundMessage);
		}
		return ResponseEntity.ok(foundMessage);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<User> deleteMessage(@PathVariable(value = "id") Long id) {
		Users foundMessage = dao.findById(id).orElse(null);

		if (foundMessage == null) {
			return ResponseEntity.notFound().header("Message", "Nothing found with that id").build();
		} else {
			dao.delete(foundMessage);
		}
		return ResponseEntity.ok().build();
	}


