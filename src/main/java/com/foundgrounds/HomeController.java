package com.foundgrounds;

//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;

//import com.foundgrounds.shops.Shop;
//import com.foundgrounds.shops.ShopRepository;


import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index() {
		return "index.html";
	}

	@RequestMapping("/users")
	public String users() {
		return "users.html";
	}

	@RequestMapping("/shops")
	public String shops() {
		return "shops.html";
	}
	
	@RequestMapping("/comments")
	public String comments() {
		return "comments.html";
	}
	
//	This might be another way to set the params:
//	@GetMapping("/comments")
//	public String shopsParam(@RequestParam String group, Shop comment) {
//		{ comment.addAttribute("comment", comment.ShopRepository(group)); This part isn't right
//		}
//		return "view.html";
//	}
	
	@RequestMapping("/posts")
	public String posts() {
		return "posts.html";
	}
	
	@RequestMapping("/reviews")
	public String reviews() {
		return "reviews.html";
	}

	@RequestMapping("/likes")
	public String likes() {
		return "likes.html";
	}
	
	@RequestMapping("/menus")
	public String menus() {
		return "menus.html";
	}
	@RequestMapping("/thumbsup")
	public String thumbsup() {
		return "thumbsup.html";
	}
	@RequestMapping("/roles")
	public String roles() {
		return "roles.html";
	}
	
	
}
