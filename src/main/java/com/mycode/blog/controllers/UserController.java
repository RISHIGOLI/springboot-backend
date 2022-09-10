package com.mycode.blog.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mycode.blog.entities.User;
import com.mycode.blog.repositories.UserRepo;

public class UserController {

	@Autowired
	private User user;
	
	@Autowired
	private UserRepo userRepo;
	
	public Optional<User> getUserByEmail(String email) {
		Optional<User> user = this.userRepo.findByEmail(email);
		return user;
	}
}
