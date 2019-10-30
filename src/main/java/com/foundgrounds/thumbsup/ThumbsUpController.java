package com.foundgrounds.thumbsup;


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

import com.foundgrounds.thumbsup.ThumbsUp;
import com.foundgrounds.thumbsup.ThumbsUpRepository;
import com.foundgrounds.users.User;

@RestController
@RequestMapping("/api")
public class ThumbsUpController {

	
	@Autowired
	ThumbsUpRepository dao;

	@GetMapping("/thumbsup")
	public List<ThumbsUp> getThumbsUp() {
		List<ThumbsUp> foundThumbsUp = dao.findAll();
		return foundThumbsUp;
	}

	@GetMapping("/thumbsup/{thumbsUpId}")
	public ResponseEntity<ThumbsUp> getThumbsUp(@PathVariable(value = "thumbsUpId") Integer thumbsUpId) {
		ThumbsUp foundThumbsUp = dao.findById(thumbsUpId).orElse(null);

		if (foundThumbsUp == null) {
			return ResponseEntity.notFound().header("User", "Nothing found with that id").build();
		}
		return ResponseEntity.ok(foundThumbsUp);
	}

	@PostMapping("/thumbsup")
	public ResponseEntity<ThumbsUp> postLike(@RequestBody ThumbsUp thumbsUp) {

		// saving to DB using instance of the repo interface
		ThumbsUp createdThumbsUp = dao.save(thumbsUp);

		// RespEntity crafts response to include correct status codes.
		return ResponseEntity.ok(createdThumbsUp);
	}

	@PutMapping("/thumbsup/{thumbsUpId}")
	public ResponseEntity<ThumbsUp> putThumbsUp(@PathVariable Integer thumbsUpId, @RequestBody ThumbsUp thumbsUp) {
		ThumbsUp foundThumbsUp = dao.findById(thumbsUpId).orElse(null);
		if (foundThumbsUp == null) {
			return ResponseEntity.notFound().header("User", "Nothing found with that id").build();
		} else {
//			if (User.getUsername() != null) {
//				User.setUsername(User.getUsername());
//			}
//			if (User.getPassword() != null) {
//				User.setPassword(User.getPassword());
//			}
			foundThumbsUp.setPostId(thumbsUp.getPostId());
			foundThumbsUp.setUserId(thumbsUp.getUserId());
			foundThumbsUp.setThumbsUp(thumbsUp.getThumbsUp());

			dao.save(foundThumbsUp);
		}
		return ResponseEntity.ok(foundThumbsUp);
	}

	@DeleteMapping("/thumbsup/{thumbsUpId}")
	public ResponseEntity<ThumbsUp> deleteThumbsUp(@PathVariable(value = "thumbsUpId") Integer thumbsUpId) {
		ThumbsUp foundThumbsUp = dao.findById(thumbsUpId).orElse(null);

		if (foundThumbsUp == null) {
			return ResponseEntity.notFound().header("User", "Nothing found with that id").build();
		} else {
			dao.delete(foundThumbsUp);
		}
		return ResponseEntity.ok().build();
	}
}
