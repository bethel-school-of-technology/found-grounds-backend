package com.foundgrounds.roles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

	@Autowired
	RoleRepository doa;
}
