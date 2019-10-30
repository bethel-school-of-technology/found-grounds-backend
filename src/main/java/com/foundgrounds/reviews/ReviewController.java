package com.foundgrounds.reviews;

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

import com.foundgrounds.reviews.Review;
import com.foundgrounds.reviews.ReviewRepository;
//import com.foundgrounds.users.User;

@RestController
@RequestMapping("/api")
public class ReviewController {

	@Autowired
	ReviewRepository dao;

	@GetMapping("/reviews")
	public List<Review> getReview() {
		List<Review> foundReviews = dao.findAll();
		return foundReviews;
	}

	@GetMapping("/reviews/{reviewId}")
	public ResponseEntity<Review> getUser(@PathVariable(value = "reviewId") Integer reviewId) {
		Review foundReview = dao.findById(reviewId).orElse(null);

		if (foundReview == null) {
			return ResponseEntity.notFound().header("Review", "Nothing found with that id").build();
		}
		return ResponseEntity.ok(foundReview);
	}

	@PostMapping("/reviews")
	public ResponseEntity<Review> postReview(@RequestBody Review review) {
		// Sets the date and time of each comment
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		review.setTimePosted(dateFormat.format(date));
		// saving to DB using instance of the repo interface
		Review createdReview = dao.save(review);

		// RespEntity crafts response to include correct status codes.
		return ResponseEntity.ok(createdReview);
	}

	@PutMapping("/reviews/{reviewId}")
	public ResponseEntity<Review> putReview(@PathVariable Integer reviewId, @RequestBody Review review) {
		Review foundReview = dao.findById(reviewId).orElse(null);
		if (foundReview == null) {
			return ResponseEntity.notFound().header("Review", "Nothing found with that id").build();
		} else {
//			if (User.getUsername() != null) {
//				User.setUsername(User.getUsername());
//			}
//			if (User.getPassword() != null) {
//				User.setPassword(User.getPassword());
//			}
			foundReview.setShopId(review.getShopId());
			foundReview.setUserId(review.getUserId());
			foundReview.setText(review.getText());
			foundReview.setRating(review.getRating());
			foundReview.setDeleted(review.getDeleted());
			foundReview.setTimePosted(review.getTimePosted());
			
			dao.save(foundReview);
		}
		return ResponseEntity.ok(foundReview);
	}

	@DeleteMapping("/reviews/{reviewId}")
	public ResponseEntity<Review> deleteReview(@PathVariable(value = "reviewId") Integer reviewId) {
		Review foundReview = dao.findById(reviewId).orElse(null);

		if (foundReview == null) {
			return ResponseEntity.notFound().header("Review", "Nothing found with that id").build();
		} else {
			dao.delete(foundReview);
		}
		return ResponseEntity.ok().build();
	}
}
