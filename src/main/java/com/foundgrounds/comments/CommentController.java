package com.foundgrounds.comments;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.foundgrounds.comments.Comment;
import com.foundgrounds.comments.CommentRepository;
import com.foundgrounds.users.User;

@RestController
@RequestMapping("/api")
public class CommentController {

	@Autowired
	CommentRepository dao;

	@GetMapping("/comments")
	public List<Comment> getComment() {
		List<Comment> foundComments = dao.findAll();
		return foundComments;
	}

	@GetMapping("/comments/{id}")
	public ResponseEntity<Comment> getUser(@PathVariable(value = "id") Long id) {
		Comment foundComment = dao.findById(id).orElse(null);

		if (foundComment == null) {
			return ResponseEntity.notFound().header("Comment", "Nothing found with that id").build();
		}
		return ResponseEntity.ok(foundComment);
	}

	@PostMapping("/comments/{id}")
	public ResponseEntity<Comment> postComment(@RequestBody Comment comment) {
		// Sets the date and time of each comment
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        comment.setTimePosted(dateFormat.format(date));
		// saving to DB using instance of the repo interface
		Comment createdComment = dao.save(comment);

		// RespEntity crafts response to include correct status codes.
		return ResponseEntity.ok(createdComment);
	}

	@PutMapping("/comments/{id}")
	public ResponseEntity<Comment> putComment(@PathVariable Long id, @RequestBody Comment comment) {
		Comment foundComment = dao.findById(id).orElse(null);
		if (foundComment == null) {
			return ResponseEntity.notFound().header("Comment", "Nothing found with that id").build();
		} else {
			if (User.getUsername() != null) {
				User.setUsername(User.getUsername());
			}
			if (User.getPassword() != null) {
				User.setPassword(User.getPassword());
			}
			dao.save(foundComment);
		}
		return ResponseEntity.ok(foundComment);
	}

	@DeleteMapping("/comments/{id}")
	public ResponseEntity<Comment> deleteComment(@PathVariable(value = "id") Long id) {
		Comment foundComment = dao.findById(id).orElse(null);

		if (foundComment == null) {
			return ResponseEntity.notFound().header("Comment", "Nothing found with that id").build();
		} else {
			dao.delete(foundComment);
		}
		return ResponseEntity.ok().build();
	}
}

