package com.mycode.blog.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycode.blog.entities.ApiResponse;
import com.mycode.blog.entities.User;
import com.mycode.blog.repositories.UserRepo;
import com.mycode.blog.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
//	@GetMapping("/getUserByEmail/{email}")
//	public ApiResponse<User> getUserByEmail(@PathVariable String email) {
//		User user = this.userService.findByEmail(email);
//		return  new ApiResponse(email, false, 404);
//	}
	
	//put - update user
	@PutMapping("/{userId}")
	public ApiResponse<User> updateUser(@Valid @RequestBody User user, @PathVariable Integer userId)
	{
	
		User updatedUser = this.userService.updateUser(user, userId);
		return new ApiResponse<User>(updatedUser, "user updated successfully", true, 200);
		
	}
	
	
//		@PutMapping("/{userId}")
//		public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId)
//		{
//			UserDto updatedUser = this.userService.updateUser(userDto, userId);
//			return ResponseEntity.ok(updatedUser);
//		}
}
