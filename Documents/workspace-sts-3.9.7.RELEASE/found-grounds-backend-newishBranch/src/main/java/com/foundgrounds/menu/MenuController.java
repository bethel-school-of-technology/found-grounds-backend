package com.foundgrounds.menu;

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

import com.foundgrounds.users.User;
import com.foundgrounds.menu.Menu;
import com.foundgrounds.menu.MenuRepository;

@RestController
@RequestMapping("/api")
public class MenuController {

	@Autowired
	MenuRepository dao;

	@GetMapping("/menu")
	public List<Menu> getMenu() {
		List<Menu> foundMenu = dao.findAll();
		return foundMenu;
	}

	@GetMapping("/menu/{menuId}")
	public ResponseEntity<Menu> getMenu(@PathVariable(value = "menuId") Integer menuId) {
		Menu foundMenu = dao.findById(menuId).orElse(null);

		if (foundMenu == null) {
			return ResponseEntity.notFound().header("User", "Nothing found with that id").build();
		}
		return ResponseEntity.ok(foundMenu);
	}

	@PostMapping("/menu")
	public ResponseEntity<Menu> postMenu(@RequestBody Menu menu) {

		// saving to DB using instance of the repo interface
		Menu createdMenu = dao.save(menu);

		// RespEntity crafts response to include correct status codes.
		return ResponseEntity.ok(createdMenu);
	}

	@PutMapping("/menu/{menuId}")
	public ResponseEntity<Menu> putMenu(@PathVariable Integer menuId, @RequestBody Menu menu) {
		Menu foundMenu = dao.findById(menuId).orElse(null);
		if (foundMenu == null) {
			return ResponseEntity.notFound().header("User", "Nothing found with that id").build();
		} else {
			if (User.getUsername() != null) {
				User.setUsername(User.getUsername());
			}
			if (User.getPassword() != null) {
				User.setPassword(User.getPassword());
			}
			dao.save(foundMenu);
		}
		return ResponseEntity.ok(foundMenu);
	}

	@DeleteMapping("/menu/{menuId}")
	public ResponseEntity<Menu> deleteMenu(@PathVariable(value = "menuId") Integer menuId) {
		Menu foundMenu = dao.findById(menuId).orElse(null);

		if (foundMenu == null) {
			return ResponseEntity.notFound().header("User", "Nothing found with that id").build();
		} else {
			dao.delete(foundMenu);
		}
		return ResponseEntity.ok().build();
	}
}


