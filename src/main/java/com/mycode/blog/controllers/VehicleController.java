package com.mycode.blog.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycode.blog.entities.ApiResponse;
import com.mycode.blog.entities.Category;
import com.mycode.blog.entities.Vehicle;
import com.mycode.blog.payloads.VehicleDto;
import com.mycode.blog.services.VehicleService;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	
	//post add new vehicle
	@PostMapping("/user/{userId}/category/{categoryId}/addVehicle")
	public ApiResponse<VehicleDto> addVehicle(@Valid @RequestBody VehicleDto vehicleDto, @PathVariable Integer userId, @PathVariable Integer categoryId ){
		
		//this.vehicleService.addNewVehicle(vehicle);
		VehicleDto addVehicle = this.vehicleService.addVehicle(vehicleDto, userId, categoryId);
		return new ApiResponse(addVehicle,"Vehicle registered successfully.",true,201);
	}
	
	
	
	//get vehicle detail by id
		@GetMapping("/vehicles/{vehicleId}")
		public ApiResponse<Vehicle> getVehicleById(@PathVariable Integer vehicleId)
		{
				//PostDto post = this.postService.getPostById(postId);
				Vehicle vehicle = this.vehicleService.getVehicleById(vehicleId);
				return new ApiResponse(vehicle,"Vehicle found with vehicleId =" +vehicleId,true,201);
		}
		
		
		//delete vehicle by id
		@DeleteMapping("/deleteVehicle/{vehicleId}")
		public ApiResponse<Vehicle> deleteVehicle(@PathVariable Integer vehicleId)
		{
			
			this.vehicleService.deleteVehicle(vehicleId);
			//Vehicle vehicle = this.vehicleService.getVehicleById(vehicleId);
			
			
			return new ApiResponse("Vehicle with " + vehicleId + " deleted successfully.",true,200);
		}
		
		
	

}
