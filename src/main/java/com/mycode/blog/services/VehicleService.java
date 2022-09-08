package com.mycode.blog.services;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.mycode.blog.entities.ApiResponse;
import com.mycode.blog.entities.Vehicle;

public interface VehicleService {
	public ResponseEntity<ApiResponse<Vehicle>> addVehicle(@Valid @RequestBody Vehicle vehicleDto);
	public ResponseEntity<ApiResponse<Vehicle>> getVehicleById(String vehicleId);
	public ResponseEntity<ApiResponse<Vehicle>> getAllVehiclesByUserId(String userId);
}
