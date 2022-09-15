package com.mycode.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycode.blog.entities.ApiResponse;
import com.mycode.blog.entities.DriverRating;
import com.mycode.blog.services.DriverRatingService;

@RestController
@RequestMapping("/api/d_rating")
public class DriverRatingController {

	@Autowired
	private DriverRatingService driverRatingService;
	
	//add driver rating
	@PostMapping("/addDriverRating/{driverId}/ratings")
	public ApiResponse<DriverRating> addDriverRating(@RequestBody DriverRating driverRating, @PathVariable Integer driverId)
	{
		DriverRating addaddDriverRating = this.driverRatingService.addDriverRating(driverRating, driverId);
		return new ApiResponse(addaddDriverRating, "driver rating added successfully", true, 201);
	}

	//delete rating
	@DeleteMapping("/deleteDriverRating/{d_ratingId}")
	public ApiResponse<DriverRating> deleteDriverRating(@PathVariable Integer d_ratingId)
	{
		this.driverRatingService.deleteDriverRating(d_ratingId);
		return new ApiResponse<>("driver rating deleted successfully", true, 200);
		
	}
}
