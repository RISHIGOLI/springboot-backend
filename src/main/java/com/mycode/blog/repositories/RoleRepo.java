package com.mycode.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycode.blog.entities.Role;

public interface RoleRepo extends JpaRepository<Role, Integer>{
	
}
