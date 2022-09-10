package com.mycode.blog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mycode.blog.entities.ApiResponse;
import com.mycode.blog.entities.User;


@Service
public interface UserService {
	
	 
	
	
	 
	Optional<User> findByEmail(String email);
	 
	 
	 
	 
	 
	
	 
	 ApiResponse<User> registerNewUser_2(User user);
	 
}
