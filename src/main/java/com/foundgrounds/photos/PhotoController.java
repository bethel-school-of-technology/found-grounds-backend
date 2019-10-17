package com.foundgrounds.photos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhotoController {
	
	@Autowired
	PhotoRepository doa;

}
