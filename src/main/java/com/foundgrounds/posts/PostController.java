package com.foundgrounds.posts;

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

import com.foundgrounds.posts.Post;
import com.foundgrounds.posts.PostRepository;
import com.foundgrounds.users.User;

@RestController
@RequestMapping("/api")
public class PostController {

	@Autowired
	PostRepository dao;

	@GetMapping("/posts")
	public List<Post> getPost() {
		List<Post> foundMessages = dao.findAll();
		return foundMessages;
	}

	@GetMapping("/posts/{id}")
	public ResponseEntity<Post> getUser(@PathVariable(value = "id") Long id) {
		Post foundMessage = dao.findById(id).orElse(null);

		if (foundMessage == null) {
			return ResponseEntity.notFound().header("Message", "Nothing found with that id").build();
		}
		return ResponseEntity.ok(foundMessage);
	}

	@PostMapping("/posts/{id}")
	public ResponseEntity<Post> postMessage(@RequestBody Post message) {

		// saving to DB using instance of the repo interface
		Post createdMessage = dao.save(message);

		// RespEntity crafts response to include correct status codes.
		return ResponseEntity.ok(createdMessage);
	}

	@PutMapping("/posts/{id}")
	public ResponseEntity<Post> putMessage(@PathVariable Long id, @RequestBody Post message) {
		Post foundMessage = dao.findById(id).orElse(null);
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

	@DeleteMapping("/posts/{id}")
	public ResponseEntity<Post> deleteMessage(@PathVariable(value = "id") Long id) {
		Post foundMessage = dao.findById(id).orElse(null);

		if (foundMessage == null) {
			return ResponseEntity.notFound().header("Message", "Nothing found with that id").build();
		} else {
			dao.delete(foundMessage);
		}
		return ResponseEntity.ok().build();
	}
}
