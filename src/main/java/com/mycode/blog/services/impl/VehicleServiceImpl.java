package com.mycode.blog.services.impl;

import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycode.blog.entities.ApiResponse;
import com.mycode.blog.entities.Category;
import com.mycode.blog.entities.User;
import com.mycode.blog.entities.Vehicle;
import com.mycode.blog.exceptions.ResourceNotFoundException;
import com.mycode.blog.payloads.VehicleDto;
import com.mycode.blog.repositories.CategoryRepo;
import com.mycode.blog.repositories.UserRepo;
import com.mycode.blog.repositories.VehicleRepo;

import com.mycode.blog.services.VehicleService;
import com.mycode.blog.utils.Utility;

@Component
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepo vehicleRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CategoryRepo categoryRepo;

//	@Override
//	public ApiResponse<Vehicle> addNewVehicle(Vehicle vehicle) {
//		// TODO Auto-generated method stub
//		vehicleRepo.save(vehicle);
//		return null;
//	}

	@Override
	public Vehicle getVehicleById(Integer vehicleId) {
		// TODO Auto-generated method stub
		Vehicle vehicle = this.vehicleRepo.findById(vehicleId).orElseThrow(()-> new ResourceNotFoundException("vehicle", "vehicle id", vehicleId));
		return vehicle;
	}

	@Override
	public void deleteVehicle(Integer vehicleId) {
		// TODO Auto-generated method stub
		Vehicle vehicle = this.vehicleRepo.findById(vehicleId).orElseThrow(()-> new ResourceNotFoundException("vehicle", "vehicle id", vehicleId));
		this.vehicleRepo.delete(vehicle);
		
	}

	@Override
	public VehicleDto addVehicle(VehicleDto vehicleDto, Integer userId, Integer categoryId) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user", "user id", userId));
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("category", "category id", categoryId));
		
		Vehicle vehicle = this.modelMapper.map(vehicleDto, Vehicle.class);
		vehicle.setCategory(category);
		vehicle.setUser(user);
		
		Vehicle newVehicle = this.vehicleRepo.save(vehicle);
		
		return this.modelMapper.map(newVehicle, VehicleDto.class);
	}
	

	
	

	

	


	

	

	

	
	
	

	/*
	 * @Override public ApiResponse<User> registerNewUser_2(User userDto) {
	 * if(userDto==null) return new
	 * ApiResponse("Input fields are missing !",false,402); else
	 * if(Utility.isFieldEmpty(userDto.getFirstName()) ||
	 * userDto.getFirstName().length()<4) { return new
	 * ApiResponse("FirstName should be greater than 4 characters!",false,402); }
	 * 
	 * else if(Utility.isFieldEmpty(userDto.getLastName()) ||
	 * userDto.getLastName().length()<4) { return new
	 * ApiResponse("LastName should be greater than 4 characters!",false,402); }
	 * 
	 * 
	 * //else if(Utility.isFieldEmpty(userDto.getEmail()) ||
	 * !Utility.isEmailValid(userDto.getEmail())) else
	 * if(Utility.isEmailValid(userDto.getEmail())) return new
	 * ApiResponse("Email should be in proper format !",false,402);
	 * 
	 * else if(Utility.isFieldEmpty(userDto.getPassword()) ||
	 * (userDto.getPassword().length()<3 || userDto.getPassword().length()>10))
	 * return new
	 * ApiResponse("Password should be more than 3 or less than 10 chars !",false,
	 * 402);
	 * 
	 * else if(Utility.isFieldEmpty(userDto.getMobile()) ||
	 * userDto.getMobile().length()!=10) return new
	 * ApiResponse<>("Proper Mobile Number not provided", false, 402);
	 * 
	 * else if(Utility.isFieldEmpty(userDto.getDob())) return new
	 * ApiResponse<>("Date of Birth Not Provided", false, 402);
	 * 
	 * else if(Utility.isFieldEmpty(userDto.getGender())) return new
	 * ApiResponse<>("Gender not selected", false, 402);
	 * 
	 * else if(Utility.isFieldEmpty(userDto.getAddress())) return new
	 * ApiResponse<>("Address Not Provided", false, 402);
	 * 
	 * 
	 * Optional<User> returnedUser = userRepo.findByEmail(userDto.getEmail());
	 * if(returnedUser.isPresent()) { return new
	 * ApiResponse(userDto,"User already exists !",false,402); }
	 * 
	 * 
	 * //encoded the password
	 * userDto.setPassword(this.passwordEncoder.encode(userDto.getPassword()));
	 * 
	 * //roles
	 * 
	 * Role role = this.roleRepo.findById(AppConstants.NORMAL_USER).get();
	 * userDto.getRoles().add(role); User newUser = this.userRepo.save(userDto);
	 * 
	 * TODO Auto-generated method stub this.userRepo.save(userDto); return new
	 * ApiResponse(userDto,"User registered successfully.",true,201);
	 * 
	 * }
	 */

}
