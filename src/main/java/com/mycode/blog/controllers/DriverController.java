package com.mycode.blog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycode.blog.entities.ApiResponse;
import com.mycode.blog.entities.Driver;
import com.mycode.blog.entities.Vehicle;
import com.mycode.blog.payloads.DriverDto;
import com.mycode.blog.services.DriverService;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

	@Autowired
	private DriverService driverService;
	
	//add new driver
	@PostMapping("/user/{userId}/category/{d_categoryId}/enrollAsDriver")
	public ApiResponse<DriverDto> enrollAsDriver(@Valid @RequestBody DriverDto driverDto, @PathVariable Integer userId, @PathVariable Integer d_categoryId)
	{
		DriverDto addedDriver = this.driverService.enrollAsDriver(driverDto, userId, d_categoryId);
		return new ApiResponse(addedDriver, "driver added successfully", true, 201);
		
	}
	
	//delete driver
	@DeleteMapping("/deleteDriver/{driverId}")
	public ApiResponse<Driver> deleteDriver(@PathVariable Integer driverId)
	{
		this.driverService.deleteDriver(driverId);		
		//Driver driver = this.driverService.getDriverById(driverId);
		return new ApiResponse("Driver with " + driverId + " deleted successfully.",true,200);
	}
	
	//update driver
	@PutMapping("/updateDriver/{driverId}")
	public ApiResponse<Driver> updateDriver(@RequestBody Driver driver, @PathVariable Integer driverId)
	{
		Driver updatedDriver = this.driverService.updateDriver(driver, driverId);
		return new ApiResponse<Driver>(updatedDriver, "driver updated successfully", true, 200);
		
	}
	
	//get all drivers
	@GetMapping("/getAllDrivers")
	public ApiResponse<Driver> getAllDrivers()
	{
		List<Driver> allDrivers = this.driverService.getAllDrivers();
		return new ApiResponse<>(allDrivers, "drivers found", true, 200);
		
	}

}
