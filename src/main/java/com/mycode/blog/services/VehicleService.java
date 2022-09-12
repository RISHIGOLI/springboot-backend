package com.mycode.blog.services;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.mycode.blog.entities.ApiResponse;
import com.mycode.blog.entities.User;
import com.mycode.blog.entities.Vehicle;
import com.mycode.blog.payloads.VehicleDto;

@Service
public interface VehicleService {

		
	//ApiResponse<Vehicle> addNewVehicle(Vehicle vehicle);

	Vehicle getVehicleById(Integer vehicleId);

	

	void deleteVehicle(Integer vehicleId);



	VehicleDto addVehicle(@Valid VehicleDto vehicleDto, Integer userId, Integer categoryId);



	

//	VehicleDto addVehicle(VehicleDto vehicleDto, Integer userId, Integer categoryId);
	
	

	

	
}
