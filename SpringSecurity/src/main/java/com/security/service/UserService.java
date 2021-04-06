package com.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.entities.User;
import com.security.repository.UserRepository;

@Service
public class UserService {
    
	@Autowired
	UserRepository userRepo;
	
	PasswordEncoder passwordEncoder;
	
	public UserService (UserRepository userRepo) {
		this.userRepo =userRepo;
		this.passwordEncoder = new BCryptPasswordEncoder(); 
	}
	
	public User saveUser(User user) {
		String encodedPassword = this.passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		return this.userRepo.save(user);
	}
}
