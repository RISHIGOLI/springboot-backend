package com.mycode.blog.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="vehicles")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String model;
	
	@Column
	private String number;
	
	@Column
	private String city;
	
	@Column
	private String seatingCapacity;
	
	@Column
	private String luggageCapacity;
	
	@Column
	private String fuelType;
	
	@Column
	private String transmission;
	
	@Column
	private String airCondition;
	
	@Column
	private String mileage;
	
	private String vehicleImage;
	
	
	
	
	
	
	//relations mapping below
	@JsonBackReference
	@ManyToOne
	private User user;
	
//	//@ManyToOne
//	private int userId;
	
	
	//whole object mapping
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	

	
	
	
	
	
	
	
//getters and setters for object mappig
	public Category getCategory() {
		return category;
	}

	
	public void setCategory(Category category) {
		this.category = category;
	}

	
		
	

	public User getUser() {
		return user;
	}
	
	@JsonIgnore
	public void setUser(User user) {
		this.user = user;
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getSeatingCapacity() {
		return seatingCapacity;
	}


	public void setSeatingCapacity(String seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}


	public String getLuggageCapacity() {
		return luggageCapacity;
	}


	public void setLuggageCapacity(String luggageCapacity) {
		this.luggageCapacity = luggageCapacity;
	}


	public String getFuelType() {
		return fuelType;
	}


	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}


	public String getTransmission() {
		return transmission;
	}


	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}


	public String getAirCondition() {
		return airCondition;
	}


	public void setAirCondition(String airCondition) {
		this.airCondition = airCondition;
	}


	public String getMileage() {
		return mileage;
	}


	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	
	


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}
	
	


	public String getVehicleImage() {
		return vehicleImage;
	}


	public void setVehicleImage(String vehicleImage) {
		this.vehicleImage = vehicleImage;
	}


	public Vehicle(int id, String model, String number, String seatingCapacity, String luggageCapacity, String fuelType,
			String transmission, String airCondition, String mileage, User user, Category category) {
		super();
		this.id = id;
		this.model = model;
		this.number = number;
		this.seatingCapacity = seatingCapacity;
		this.luggageCapacity = luggageCapacity;
		this.fuelType = fuelType;
		this.transmission = transmission;
		this.airCondition = airCondition;
		this.mileage = mileage;
		this.user = user;
		this.category = category;
	}


	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", model=" + model + ", number=" + number + ", seatingCapacity=" + seatingCapacity
				+ ", luggageCapacity=" + luggageCapacity + ", fuelType=" + fuelType + ", transmission=" + transmission
				+ ", airCondition=" + airCondition + ", mileage=" + mileage + ", user=" + user + ", category="
				+ category + "]";
	}
	
	
	
	
}
