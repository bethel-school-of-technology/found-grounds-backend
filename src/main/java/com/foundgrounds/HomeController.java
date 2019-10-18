package com.foundgrounds;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index() {
		return "index.html";
	}

	@RequestMapping("/foods")
	public String foods() {
		return "food.html";
	}

	@RequestMapping("/users")
	public String users() {
		return "users.html";
	}

	@RequestMapping("/shops")
	public String shops() {
		return "shops.html";
	}

	@RequestMapping("/drinks")
	public String drinks() {
		return "drinks.html";
	}
}
