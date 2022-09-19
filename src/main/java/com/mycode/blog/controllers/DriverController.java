package com.mycode.blog.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mycode.blog.entities.ApiResponse;
import com.mycode.blog.entities.Driver;
import com.mycode.blog.entities.Vehicle;
import com.mycode.blog.payloads.DriverDto;
import com.mycode.blog.services.DriverService;
import com.mycode.blog.services.FileService;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

	@Autowired
	private DriverService driverService;
	
	@Autowired
	private FileService fileService;
	
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
	public ApiResponse<DriverDto> updateDriver(@RequestBody DriverDto driverDto, @PathVariable Integer driverId)
	{
		DriverDto updatedDriver = this.driverService.updateDriver(driverDto, driverId);
		return new ApiResponse<DriverDto>(updatedDriver, "driver updated successfully", true, 200);
		
	}
	
	//get all drivers
	@GetMapping("/getAllDrivers")
	public ApiResponse<Driver> getAllDrivers()
	{
		List<Driver> allDrivers = this.driverService.getAllDrivers();
		return new ApiResponse<>(allDrivers, "drivers found", true, 200);
		
	}
	
	// get driver details by id
	@GetMapping("/drivers/{driverId}")
	public ApiResponse<DriverDto> getDriverById(@PathVariable Integer driverId)
	{
		DriverDto driver = this.driverService.getDriverById(driverId);
		return new ApiResponse<DriverDto>(driver, "driver found with driver id = "+driverId, true, 201);
		
	}

	
	// upload driver image
	
	@Value("${project.image}")
	private String path;
	
	@PostMapping("/uploadDriverImage/{driverId}")
	public ApiResponse<DriverDto> uploadDriverImage(@RequestParam("image") MultipartFile image,@PathVariable Integer driverId)throws IOException
	{
		DriverDto driverDto = this.driverService.getDriverById(driverId);
		String fileName = this.fileService.uploadImage(path, image);
		
		driverDto.setDriverImage(fileName);
		DriverDto updatedDriver = this.driverService.updateDriver(driverDto, driverId);
		return new ApiResponse<DriverDto>(updatedDriver, "image added successfully", true, 200);
	}
	
	// download image or method to serve file
	@GetMapping(value="driver/image/{imageName}", produces=MediaType.IMAGE_JPEG_VALUE)
	public void downloadDriverImage(@PathVariable("imageName") String imageName, HttpServletResponse response)throws IOException
	{
		
		InputStream resource = this.fileService.getResource(path, imageName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(resource, response.getOutputStream());
	}
	
	

}
