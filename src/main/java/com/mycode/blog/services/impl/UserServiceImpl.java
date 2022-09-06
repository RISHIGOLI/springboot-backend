package com.mycode.blog.services.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.mycode.blog.config.AppConstants;
import com.mycode.blog.entities.Role;
import com.mycode.blog.entities.User;
import com.mycode.blog.payloads.UserDto;
import com.mycode.blog.repositories.RoleRepo;
import com.mycode.blog.repositories.UserRepo;
import com.mycode.blog.services.UserService;
import com.mycode.blog.exceptions.*;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepo roleRepo;

	@Override
	public UserDto createUser(UserDto userDto) {

		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.UserToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		User updatedUser = this.userRepo.save(user);
		UserDto userDto1 = this.UserToDto(updatedUser);
		return userDto1;

	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		return this.UserToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = this.userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(user -> this.UserToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		this.userRepo.delete(user);

	}

	private User dtoToUser(UserDto userDto) {
//		User user = new User();
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setAbout(userDto.getAbout());
//		user.setPassword(userDto.getPassword());
		
		//after modelmapper vidoe
		User user = this.modelMapper.map(userDto, User.class);
		return user;

	}

	public UserDto UserToDto(User user) {
//		UserDto userDto = new UserDto();
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setPassword(user.getPassword());
//		userDto.setAbout(user.getAbout());
		
		//after modelmapper video
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		return userDto;
	}

	@Override
	public UserDto registerNewUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		//encoded the password
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		
		//roles
		 Role role = this.roleRepo.findById(AppConstants.NORMAL_USER).get();
		 user.getRoles().add(role);
		  User newUser = this.userRepo.save(user);
		  
		
		return this.modelMapper.map(newUser, UserDto.class);
	}

	

}
