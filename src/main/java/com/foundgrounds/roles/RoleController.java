package com.foundgrounds.roles;

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

import com.foundgrounds.roles.Role;
import com.foundgrounds.roles.RoleRepository;
import com.foundgrounds.users.User;

@RestController
@RequestMapping("/api")
public class RoleController {

	@Autowired
	RoleRepository dao;
	
	
	@GetMapping("/roles")
	public List<Role> getRoles() {
		List<Role> foundRoles = dao.findAll();
		return foundRoles;
	}

	@GetMapping("/roles/{roleId}")
	public ResponseEntity<Role> getRole(@PathVariable(value = "roleId") Integer roleId) {
		Role foundRole = dao.findById(roleId).orElse(null);

		if (foundRole == null) {
			return ResponseEntity.notFound().header("Roles", "Nothing found with that id").build();
		}
		return ResponseEntity.ok(foundRole);
	}

	@PostMapping("/roles")
	public ResponseEntity<Role> postRole(@RequestBody Role role) {

		// saving to DB using instance of the repo interface
		Role createdRole = dao.save(role);

		// RespEntity crafts response to include correct status codes.
		return ResponseEntity.ok(createdRole);
	}

	@PutMapping("/roles/{roleId}")
	public ResponseEntity<Role> putRole(@PathVariable Integer roleId, @RequestBody Role role) {
		Role foundRole = dao.findById(roleId).orElse(null);
		if (foundRole == null) {
			return ResponseEntity.notFound().header("Roles", "Nothing found with that id").build();
		} else {
//			if (User.getUsername() != null) {
//				User.setUsername(User.getUsername());
//			}
//			if (User.getPassword() != null) {
//				User.setPassword(User.getPassword());
//			}
			dao.save(foundRole);
		}
		return ResponseEntity.ok(foundRole);
	}

	@DeleteMapping("/roles/{roleId}")
	public ResponseEntity<Role> deleteRole(@PathVariable(value = "roleId") Integer roleId) {
		Role foundRole = dao.findById(roleId).orElse(null);

		if (foundRole == null) {
			return ResponseEntity.notFound().header("Role", "Nothing found with that id").build();
		} else {
			dao.delete(foundRole);
		}
		return ResponseEntity.ok().build();
	}
}
