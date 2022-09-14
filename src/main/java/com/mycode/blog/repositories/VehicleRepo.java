package com.mycode.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycode.blog.entities.Category;
import com.mycode.blog.entities.User;
import com.mycode.blog.entities.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer>{

	List<Vehicle> findByCategory(Category category);
	
	List<Vehicle> findByUser(User user);
	
	List<Vehicle> findByModelContaining(String name);
}
