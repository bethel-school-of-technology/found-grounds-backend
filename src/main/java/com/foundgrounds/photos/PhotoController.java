package com.foundgrounds.photos;

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

import com.foundgrounds.photos.Photo;
import com.foundgrounds.photos.PhotoRepository;
import com.foundgrounds.users.User;

@RestController
@RequestMapping("/api")
public class PhotoController {
	
	@Autowired
	PhotoRepository dao;
	
	
	@GetMapping("/photos")
	public List<Photo> getPhotos() {
		List<Photo> foundPhotos = dao.findAll();
		return foundPhotos;
	}

	@GetMapping("/photos/{photoId}")
	public ResponseEntity<Photo> getPhoto(@PathVariable(value = "photoId") Integer photoId) {
		Photo foundPhoto = dao.findById(photoId).orElse(null);

		if (foundPhoto == null) {
			return ResponseEntity.notFound().header("Message", "Nothing found with that id").build();
		}
		return ResponseEntity.ok(foundPhoto);
	}

	@PostMapping("/photos")
	public ResponseEntity<Photo> postPhoto(@RequestBody Photo photo) {

		// saving to DB using instance of the repo interface
		Photo createdPhoto = dao.save(photo);

		// RespEntity crafts response to include correct status codes.
		return ResponseEntity.ok(createdPhoto);
	}

	@PutMapping("/photos/{photoId}")
	public ResponseEntity<Photo> putPhoto(@PathVariable Integer photoId, @RequestBody Photo photo) {
		Photo foundPhoto = dao.findById(photoId).orElse(null);
		if (foundPhoto == null) {
			return ResponseEntity.notFound().header("Message", "Nothing found with that id").build();
		} else {
			if (User.getUsername() != null) {
				User.setUsername(User.getUsername());
			}
			if (User.getPassword() != null) {
				User.setPassword(User.getPassword());
			}
			dao.save(foundPhoto);
		}
		return ResponseEntity.ok(foundPhoto);
	}

	@DeleteMapping("/photos/{photoId}")
	public ResponseEntity<Photo> deletePost(@PathVariable(value = "photoId") Integer photoId) {
		Photo foundPhoto = dao.findById(photoId).orElse(null);

		if (foundPhoto == null) {
			return ResponseEntity.notFound().header("Message", "Nothing found with that id").build();
		} else {
			dao.delete(foundPhoto);
		}
		return ResponseEntity.ok().build();
	}
}

