package com.mycode.blog.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.mycode.blog.entities.ApiResponse;
import com.mycode.blog.entities.User;
import com.mycode.blog.entities.Vehicle;
import com.mycode.blog.payloads.VehicleDto;
import com.mycode.blog.payloads.VehicleResponse;

@Service
public interface VehicleService {

		
	//ApiResponse<Vehicle> addNewVehicle(Vehicle vehicle);

	Vehicle getVehicleById(Integer vehicleId);
	
	

	

	void deleteVehicle(Integer vehicleId);



	VehicleDto addVehicle(@Valid VehicleDto vehicleDto, Integer userId, Integer categoryId);
	
	VehicleResponse getAllVehiclesWithPagination(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);



	



	List<Vehicle> getVehiclesByCategory(Integer categoryId);



	List<Vehicle> getAllVehicles();



	List<Vehicle> getVehiclesByUser(Integer userId);



	Vehicle updateVehicle(Vehicle vehicle, Integer vehicleId);



	List<Vehicle> searchVehiclesByName(String keywords);





	



	

//	VehicleDto addVehicle(VehicleDto vehicleDto, Integer userId, Integer categoryId);
	
	

	

	
}
