package com.foundgrounds.shops;


//import java.sql.Date;
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

import com.foundgrounds.shops.Shop;
import com.foundgrounds.shops.ShopRepository;
//import com.foundgrounds.users.User;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ShopController {

	@Autowired
	ShopRepository dao;
	
	@GetMapping("/shops")
	public List<Shop> getShops() {
		List<Shop> foundShops = dao.findAll();
		return foundShops;
	}
		@GetMapping("shops/{shopId}")
		public ResponseEntity<Shop> getShop(@PathVariable(value = "shopId") Integer shopId) {
			Shop foundShop = dao.findById(shopId).orElse(null);

			if (foundShop == null) {
				return ResponseEntity.notFound().header("Shop", "Nothing found with that id").build();
			}
			return ResponseEntity.ok(foundShop);
		}

		@PostMapping("/shops")
		public ResponseEntity<Shop> postShop(@RequestBody Shop shop) {

			// saving to DB using instance of the repo interface
			Shop createdShop = dao.save(shop);

			// RespEntity crafts response to include correct status codes.
			return ResponseEntity.ok(createdShop);
		}

		@PutMapping("/shops/{shopId}")
		public ResponseEntity<Shop> putShop(@PathVariable Integer shopId, @RequestBody Shop shop) {
			Shop foundShop = dao.findById(shopId).orElse(null);
			if (foundShop == null) {
				return ResponseEntity.notFound().header("Shop", "Nothing found with that id").build();
			} else {
//				if (User.getUsername() != null) {
//					User.setUsername(User.getUsername());
//				}
//				if (User.getPassword() != null) {
//					User.setPassword(User.getPassword());
//				}
				
				foundShop.setAbout(shop.getAbout());
				foundShop.setName(shop.getName());
				foundShop.setStreetAddress1(shop.getStreetAddress1());
				foundShop.setStreetAddress2(shop.getStreetAddress2());
				foundShop.setCity(shop.getCity());
				foundShop.setState(shop.getState());
				foundShop.setZip(shop.getZip());
				foundShop.setHoursOfOperation(shop.getHoursOfOperation());
				foundShop.setRating(shop.getRating());
				foundShop.setImageUrl(shop.getImageUrl());
				foundShop.setDeleted(shop.getDeleted());
				foundShop.setAdminId(shop.getAdminId());

				dao.save(foundShop);
			}
			return ResponseEntity.ok(foundShop);
		}

		@DeleteMapping("/shops/{shopId}")
		public ResponseEntity<Shop> deleteShop(@PathVariable(value = "shopId") Integer shopId) {
			Shop foundShop = dao.findById(shopId).orElse(null);

			if (foundShop == null) {
				return ResponseEntity.notFound().header("Shop", "Nothing found with that id").build();
			} else {
				dao.delete(foundShop);
			}
			return ResponseEntity.ok().build();
		}
	}

