package com.mycode.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycode.blog.entities.Driver;

public interface DriverRepo extends JpaRepository<Driver, Integer>{

}
