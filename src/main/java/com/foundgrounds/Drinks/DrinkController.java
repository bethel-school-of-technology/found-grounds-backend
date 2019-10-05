package com.foundgrounds.Drinks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DrinkController {

	@Autowired
	DrinkRepository doa;
}
