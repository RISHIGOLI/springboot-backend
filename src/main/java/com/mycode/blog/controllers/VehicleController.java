package com.mycode.blog.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycode.blog.entities.ApiResponse;
import com.mycode.blog.entities.Vehicle;
import com.mycode.blog.payloads.UserDto;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

	
	//post - create user
		@PostMapping("/addVehicle")
		public ResponseEntity<ApiResponse<Vehicle>> addVehicle(@Valid @RequestBody Vehicle vehicleDto){
			//todo
			return null;
		}
		
		@GetMapping("/getVehicleById")
		public ResponseEntity<ApiResponse<Vehicle>> getVehicleById(String vehicleId){
			//todo
			return null;
		}
		
		@GetMapping("/getAllVehiclesByUserId")
		public ResponseEntity<ApiResponse<Vehicle>> getAllVehiclesByUserId(String userId){
			//todo
			return null;
		}
}
