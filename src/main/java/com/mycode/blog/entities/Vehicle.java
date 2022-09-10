package com.mycode.blog.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="vehicles")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String v_name;
	
	@Column
	private String model;
	
	@Column
	private String color;
	
	
	//relations mapping below
//	@ManyToOne
//	private User user;
	
	//@ManyToOne
	private int userId;
	
	private int categoryId;
	
	
	
	
	
	
	
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/*
	 * public User getUser() { return user; } public void setUser(User user) {
	 * this.user = user; }
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getV_name() {
		return v_name;
	}
	public void setV_name(String v_name) {
		this.v_name = v_name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Vehicle(int id, String v_name, String model, String color) {
		super();
		this.id = id;
		this.v_name = v_name;
		this.model = model;
		this.color = color;
	}
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", v_name=" + v_name + ", model=" + model + ", color=" + color + "]";
	}
	
	
	
}
