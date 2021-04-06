package com.bootapp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootapp.dao.UserRepository;
import com.bootapp.entities.User;

@RestController
public class HomeController {
	@Autowired
	public UserRepository userepo;
	
@GetMapping("/find")	
public List<User> findAll(){
	return userepo.findAll();
	
}
}
