package com.foundgrounds.food;


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

import com.foundgrounds.food.Food;
import com.backendfinal.food.FoodRepository;
import com.backendfinal.users.Users;


@RestController
public class FoodController {

	@Autowired
	FoodRepository doa;
	
	@GetMapping("/food")
	public List<Food> getFood() {
		List<Food> foundFood = dao.findAll();
		return foundFood;
		
		@GetMapping("/food/{id}")
		public ResponseEntity<Food> getUser(@PathVariable(value = "id") Integer id) {
			Food foundFood = dao.findById(id).orElse(null);

			if (foundFood == null) {
				return ResponseEntity.notFound().header("Message", "Nothing found with that id").build();
			}
			return ResponseEntity.ok(foundFood);
		}

		@PostMapping("/food/{id}")
		public ResponseEntity<Food> postFood(@RequestBody Post food) {

			// saving to DB using instance of the repo interface
			Food createdFood = dao.save(food);

			// RespEntity crafts response to include correct status codes.
			return ResponseEntity.ok(createdFood);
		}

		@PutMapping("/food/{id}")
		public ResponseEntity<Food> putFood(@PathVariable Integer id, @RequestBody Post food) {
			Food foundFood = dao.findById(id).orElse(null);
			if (foundFood == null) {
				return ResponseEntity.notFound().header("Message", "Nothing found with that id").build();
			} else {
				if (Users.getUsername() != null) {
					Users.setUsername(Users.getUsername());
				}
				if (Users.getPassword() != null) {
					Users.setPassword(Users.getPassword());
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
}
