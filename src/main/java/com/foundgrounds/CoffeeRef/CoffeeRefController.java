package com.foundgrounds.CoffeeRef;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeRefController {

	@Autowired
	CoffeeRefRepository doa;
}
