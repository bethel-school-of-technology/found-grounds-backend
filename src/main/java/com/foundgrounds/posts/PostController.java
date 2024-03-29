package com.foundgrounds.posts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
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

import com.foundgrounds.posts.Post;
import com.foundgrounds.posts.PostRepository;
//import com.foundgrounds.users.User;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PostController {

	@Autowired
	PostRepository dao;

	@GetMapping("/posts")
	public List<Post> getPosts() {
		List<Post> foundPosts = dao.findAll();
		return foundPosts;
	}

	@GetMapping("/posts/{postId}")
	public ResponseEntity<Post> getPost(@PathVariable(value = "postId") Integer postId) {
		Post foundPost = dao.findById(postId).orElse(null);

		if (foundPost == null) {
			return ResponseEntity.notFound().header("Message", "Nothing found with that id").build();
		}
		return ResponseEntity.ok(foundPost);
	}

	@PostMapping("/posts")
	public ResponseEntity<Post> postPost(@RequestBody Post post) {
		// Sets the date and time of each comment
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		post.setTimePosted(dateFormat.format(date));
		// saving to DB using instance of the repo interface
		Post createdPost = dao.save(post);

		// RespEntity crafts response to include correct status codes.
		return ResponseEntity.ok(createdPost);
	}

	@PutMapping("/posts/{postId}")
	public ResponseEntity<Post> putPost(@PathVariable Integer postId, @RequestBody Post post) {
		Post foundPost = dao.findById(postId).orElse(null);
		if (foundPost == null) {
			return ResponseEntity.notFound().header("Message", "Nothing found with that id").build();
		} else {
//			if (User.getUsername() != null) {
//				User.setUsername(User.getUsername());
//			}
//			if (User.getPassword() != null) {
//				User.setPassword(User.getPassword());
//			}

			foundPost.setUserId(post.getUserId());
			foundPost.setShopId(post.getShopId());
			foundPost.setText(post.getText());
			foundPost.setImageUrl(post.getImageUrl());
			foundPost.setDeleted(post.getDeleted());
			foundPost.setEdited(post.getEdited());
			foundPost.setTimePosted(post.getTimePosted());

			dao.save(foundPost);
		}
		return ResponseEntity.ok(foundPost);
	}

	@DeleteMapping("/posts/{postId}")
	public ResponseEntity<Post> deletePost(@PathVariable(value = "postId") Integer postId) {
		Post foundPost = dao.findById(postId).orElse(null);

		if (foundPost == null) {
			return ResponseEntity.notFound().header("Message", "Nothing found with that id").build();
		} else {
			dao.delete(foundPost);
		}
		return ResponseEntity.ok().build();
	}
}
