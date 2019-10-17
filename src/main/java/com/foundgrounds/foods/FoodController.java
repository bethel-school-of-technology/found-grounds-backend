package com.foundgrounds.foods;


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

import com.foundgrounds.foods.Food;
import com.foundgrounds.foods.FoodRepository;
import com.foundgrounds.users.User;


@RestController
@RequestMapping("/api")
public class FoodController {

	@Autowired
	FoodRepository dao;
	
	@GetMapping("/food")
	public List<Food> getFood() {
		List<Food> foundFood = dao.findAll();
		return foundFood;
	}
		@GetMapping("/food/{id}")
		public ResponseEntity<Food> getFood(@PathVariable(value = "id") Integer id) {
			Food foundFood = dao.findById(id).orElse(null);

			if (foundFood == null) {
				return ResponseEntity.notFound().header("Message", "Nothing found with that id").build();
			}
			return ResponseEntity.ok(foundFood);
		}

		@PostMapping("/food/{id}")
		public ResponseEntity<Food> postFood(@RequestBody Food food) {

			// saving to DB using instance of the repo interface
			Food createdFood = dao.save(food);

			// RespEntity crafts response to include correct status codes.
			return ResponseEntity.ok(createdFood);
		}

		@PutMapping("/food/{id}")
		public ResponseEntity<Food> putFood(@PathVariable Integer id, @RequestBody Food food) {
			Food foundFood = dao.findById(id).orElse(null);
			if (foundFood == null) {
				return ResponseEntity.notFound().header("Message", "Nothing found with that id").build();
			} else {
				if (User.getUsername() != null) {
					User.setUsername(User.getUsername());
				}
				if (User.getPassword() != null) {
					User.setPassword(User.getPassword());
				}
				dao.save(foundFood);
			}
			return ResponseEntity.ok(foundFood);
		}

		@DeleteMapping("/food/{id}")
		public ResponseEntity<Food> deleteFood(@PathVariable(value = "id") Integer id) {
			Food foundFood = dao.findById(id).orElse(null);

			if (foundFood == null) {
				return ResponseEntity.notFound().header("Message", "Nothing found with that id").build();
			} else {
				dao.delete(foundFood);
			}
			return ResponseEntity.ok().build();
		}
	}

