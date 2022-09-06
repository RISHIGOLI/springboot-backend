package com.mycode.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mycode.blog.entities.User;
import com.mycode.blog.payloads.UserDto;

@Service
public interface UserService {
	
	 UserDto registerNewUser(UserDto userDto);
	
	 UserDto createUser(UserDto user);
	 
	 UserDto updateUser(UserDto user, Integer userId);
	 
	 UserDto getUserById(Integer userId);
	 
	 List<UserDto> getAllUsers();
	 
	 void deleteUser(Integer userId);
	 
}
