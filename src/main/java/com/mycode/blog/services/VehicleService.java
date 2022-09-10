package com.mycode.blog.services;

import org.springframework.stereotype.Service;

import com.mycode.blog.entities.ApiResponse;
import com.mycode.blog.entities.User;
import com.mycode.blog.entities.Vehicle;

@Service
public interface VehicleService {

		
	ApiResponse<Vehicle> addNewVehicle(Vehicle vehicle);

	Vehicle getVehicleById(Integer vehicleId);

	

	
}
