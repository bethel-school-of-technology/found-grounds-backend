package com.foundgrounds.drinks;


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

import com.foundgrounds.drinks.Drink;
import com.foundgrounds.drinks.DrinkRepository;
import com.foundgrounds.users.User;


@RestController
@RequestMapping("/api")
public class DrinkController {

	@Autowired
	DrinkRepository dao;
	
	@GetMapping("/drinks")
	public List<Drink> getDrink() {
		List<Drink> foundDrink = dao.findAll();
		return foundDrink;
	}
		@GetMapping("/drinks/{id}")
		public ResponseEntity<Drink> getDrink(@PathVariable(value = "id") Integer id) {
			Drink foundDrink = dao.findById(id).orElse(null);

			if (foundDrink == null) {
				return ResponseEntity.notFound().header("Drink", "Nothing found with that id").build();
			}
			return ResponseEntity.ok(foundDrink);
		}

		@PostMapping("/drinks/{id}")
		public ResponseEntity<Drink> postDrink(@RequestBody Drink drinks) {

			// saving to DB using instance of the repo interface
			Drink createdDrink = dao.save(drinks);

			// RespEntity crafts response to include correct status codes.
			return ResponseEntity.ok(createdDrink);
		}

		@PutMapping("/drinks/{id}")
		public ResponseEntity<Drink> putDrink(@PathVariable Integer id, @RequestBody Drink drinks) {
			Drink foundDrink = dao.findById(id).orElse(null);
			if (foundDrink == null) {
				return ResponseEntity.notFound().header("Drink", "Nothing found with that id").build();
			} else {
				if (User.getUsername() != null) {
					User.setUsername(User.getUsername());
				}
				if (User.getPassword() != null) {
					User.setPassword(User.getPassword());
				}
				dao.save(foundDrink);
			}
			return ResponseEntity.ok(foundDrink);
		}

		@DeleteMapping("/drinks/{id}")
		public ResponseEntity<Drink> deleteDrink(@PathVariable(value = "id") Integer id) {
			Drink foundDrink = dao.findById(id).orElse(null);

			if (foundDrink == null) {
				return ResponseEntity.notFound().header("Drink", "Nothing found with that id").build();
			} else {
				dao.delete(foundDrink);
			}
			return ResponseEntity.ok().build();
		}
	}

