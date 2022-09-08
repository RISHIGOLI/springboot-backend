package com.mycode.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycode.blog.entities.User;
import com.mycode.blog.entities.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer>{

}
