package com.mycode.blog.payloads;

import com.mycode.blog.entities.Category;
import com.mycode.blog.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VehicleDto {

	private int id;
	
	private String v_name;
	
	private String model;
	
	private String color;
	
	private User user;
	
	private Category category;
}
