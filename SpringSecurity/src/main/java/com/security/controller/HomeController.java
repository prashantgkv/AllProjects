package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.entities.User;
import com.security.service.UserService;

@RestController
public class HomeController {

//	@GetMapping("/home")
//	public String sayHi() {
//		return "Hi Spring scurity";
//	}
	
	@Autowired
	UserService userService;
	
	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		return this.userService.saveUser(user);
	}
}
