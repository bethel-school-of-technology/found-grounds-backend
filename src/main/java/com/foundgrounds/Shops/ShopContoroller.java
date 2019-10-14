package com.foundgrounds.shops;


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

import com.foundgrounds.shops.Shop;
import com.backendfinal.shops.ShopRepository;
import com.backendfinal.users.Users;


@RestController
public class ShopController {

	@Autowired
	ShopRepository doa;
	
	@GetMapping("/shops")
	public List<Shop> getShop() {
		List<Shop> foundShop = dao.findAll();
		return foundShop;
		
		@GetMapping("/shops/{id}")
		public ResponseEntity<Shop> getShop(@PathVariable(value = "id") Integer id) {
			Shop foundShop = dao.findById(id).orElse(null);

			if (foundShop == null) {
				return ResponseEntity.notFound().header("Message", "Nothing found with that id").build();
			}
			return ResponseEntity.ok(foundShop);
		}

		@PostMapping("/shops/{id}")
		public ResponseEntity<Shop> postShop(@RequestBody Post shops) {

			// saving to DB using instance of the repo interface
			Shop createdShop = dao.save(shops);

			// RespEntity crafts response to include correct status codes.
			return ResponseEntity.ok(createdShop);
		}

		@PutMapping("/shops/{id}")
		public ResponseEntity<Shop> putShop(@PathVariable Integer id, @RequestBody Post shops) {
			Shop foundShop = dao.findById(id).orElse(null);
			if (foundShop == null) {
				return ResponseEntity.notFound().header("Message", "Nothing found with that id").build();
			} else {
				if (Users.getUsername() != null) {
					Users.setUsername(Users.getUsername());
				}
				if (Users.getPassword() != null) {
					Users.setPassword(Users.getPassword());
				}
				dao.save(foundShop);
			}
			return ResponseEntity.ok(foundShop);
		}

		@DeleteMapping("/shops/{id}")
		public ResponseEntity<Shop> deleteShop(@PathVariable(value = "id") Integer id) {
			Shop foundShop = dao.findById(id).orElse(null);

			if (foundShop == null) {
				return ResponseEntity.notFound().header("Message", "Nothing found with that id").build();
			} else {
				dao.delete(foundShop);
			}
			return ResponseEntity.ok().build();
		}
	}
}
