package com.mycode.blog.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.mycode.blog.entities.Driver;
import com.mycode.blog.payloads.DriverDto;

@Service
public interface DriverService {

	DriverDto enrollAsDriver(@Valid DriverDto driverDto, Integer userId, Integer d_categoryId);

	void deleteDriver(Integer driverId);

	DriverDto updateDriver(DriverDto driverDto, Integer driverId);

	List<Driver> getAllDrivers();

	DriverDto getDriverById(Integer driverId);
	
}
