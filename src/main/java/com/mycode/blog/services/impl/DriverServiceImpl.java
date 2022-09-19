package com.mycode.blog.services.impl;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycode.blog.entities.Driver;
import com.mycode.blog.entities.DriverCategory;
import com.mycode.blog.entities.User;
import com.mycode.blog.exceptions.ResourceNotFoundException;
import com.mycode.blog.payloads.DriverDto;
import com.mycode.blog.repositories.DriverCategoryRepo;
import com.mycode.blog.repositories.DriverRepo;
import com.mycode.blog.repositories.UserRepo;
import com.mycode.blog.services.DriverService;

@Component
public class DriverServiceImpl implements DriverService{

	@Autowired
	private DriverRepo driverRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private DriverCategoryRepo driverCategoryRepo;
	
	
	//add or enrolling new driver
	@Override
	public DriverDto enrollAsDriver(@Valid DriverDto driverDto, Integer userId, Integer d_categoryId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user", "user id", userId));
		DriverCategory driverCategory = this.driverCategoryRepo.findById(d_categoryId).orElseThrow(()-> new ResourceNotFoundException("driver category", "driver category id", d_categoryId));
		
		Driver driver = this.modelMapper.map(driverDto, Driver.class);
		driver.setDriverCategory(driverCategory);
		driver.setUser(user);
		
		
		Driver newDriver = this.driverRepo.save(driver);
		
		return this.modelMapper.map(newDriver, DriverDto.class);
		
	}

	//deleting driver from db
	@Override
	public void deleteDriver(Integer driverId) {
		Driver driver = this.driverRepo.findById(driverId).orElseThrow(()-> new ResourceNotFoundException("driver", "driver id", driverId));
		this.driverRepo.delete(driver);
	}

	//update driver
	@Override
	public Driver updateDriver(Driver driver, Integer driverId) {
		Driver getCurrentDriver = this.driverRepo.findById(driverId).orElseThrow(()-> new ResourceNotFoundException("driver", "driver id", driverId));
		getCurrentDriver.setD_altMobNo(driver.getD_altMobNo());
		getCurrentDriver.setD_bloodGroup(driver.getD_bloodGroup());
		getCurrentDriver.setD_education(driver.getD_education());
		getCurrentDriver.setD_knownLanguages(driver.getD_knownLanguages());
		getCurrentDriver.setD_ridingExperience(driver.getD_ridingExperience());
		getCurrentDriver.setDriverCategory(driver.getDriverCategory());
		getCurrentDriver.setD_firstName(driver.getD_firstName());
		getCurrentDriver.setD_lastName(driver.getD_lastName());
		getCurrentDriver.setD_address(driver.getD_address());
		getCurrentDriver.setD_city(driver.getD_city());
		getCurrentDriver.setD_dob(driver.getD_dob());
		getCurrentDriver.setD_gender(driver.getD_gender());
		getCurrentDriver.setDriverImage(driver.getDriverImage());
		
		Driver updatedDriver = this.driverRepo.save(getCurrentDriver);
		return updatedDriver;
	}

	//get all drivers
	@Override
	public List<Driver> getAllDrivers() {
		List<Driver> allDrivers = this.driverRepo.findAll();
		return allDrivers;
	}

}
