package com.foundgrounds.Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {

	@Autowired
	FoodRepository doa;
}
