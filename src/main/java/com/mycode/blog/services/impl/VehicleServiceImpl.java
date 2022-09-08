package com.mycode.blog.services.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.mycode.blog.entities.ApiResponse;
import com.mycode.blog.entities.Vehicle;
import com.mycode.blog.repositories.VehicleRepo;
import com.mycode.blog.services.VehicleService;
import com.mycode.blog.utils.Utility;

public class VehicleServiceImpl implements VehicleService{

	@Autowired
	VehicleRepo vehicleRepo;
	@Override
	public ResponseEntity<ApiResponse<Vehicle>> addVehicle(@Valid Vehicle vehicleDto) {
		//todo add validations if any
		//todo check for already exists
		//todo save the object by adding required system details 
		vehicleDto.setCreatedDateTime(Utility.getCurrentDateTime());
		
		vehicleRepo.save(vehicleDto);
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ApiResponse<Vehicle>> getVehicleById(String vehicleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ApiResponse<Vehicle>> getAllVehiclesByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
