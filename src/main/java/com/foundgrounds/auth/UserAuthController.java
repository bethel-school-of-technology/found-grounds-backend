package com.foundgrounds.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserAuthController {

  @Autowired
  private MySQLUserDetailsService userService;

  @PostMapping("/register")
  public void register(@RequestBody UserAuth newUser) {
    userService.Save(newUser);
  }
}