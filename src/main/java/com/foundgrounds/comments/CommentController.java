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
	public List<Comment> getComments() {
		List<Comment> foundComments = dao.findAll();
		return foundComments;
	}

	@GetMapping("/comments/{commentId}")
	public ResponseEntity<Comment> getComment(@PathVariable(value = "commentId") Integer commentId) {
		Comment foundComment = dao.findById(commentId).orElse(null);

		if (foundComment == null) {
			return ResponseEntity.notFound().header("Comment", "Nothing found with that id").build();
		}
		return ResponseEntity.ok(foundComment);
	}

	@PostMapping("/comments")
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

	@PutMapping("/comments/{commentId}")
	public ResponseEntity<Comment> putComment(@PathVariable Integer commentId, @RequestBody Comment comment) {
		Comment foundComment = dao.findById(commentId).orElse(null);
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

	@DeleteMapping("/comments/{commentId}")
	public ResponseEntity<Comment> deleteComment(@PathVariable(value = "commentId") Integer commentId) {
		Comment foundComment = dao.findById(commentId).orElse(null);

		if (foundComment == null) {
			return ResponseEntity.notFound().header("Comment", "Nothing found with that id").build();
		} else {
			dao.delete(foundComment);
		}
		return ResponseEntity.ok().build();
	}
}

