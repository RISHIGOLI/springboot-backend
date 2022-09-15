package com.mycode.blog.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="drivers")
public class Driver {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int d_id;
	
	@Column
	private String d_bloodGroup;
	
	@Column
	private String d_altMobNo;
	
	@Column
	private String d_ridingExperience;
	
	@Column
	private String d_ratings;
	
	@Column
	private String d_education;
	
	@Column
	private String d_knownLanguages;
	
	@OneToOne
	private User user;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="driver_category_id")
	private DriverCategory driverCategory;

	public int getD_id() {
		return d_id;
	}

	public void setD_id(int d_id) {
		this.d_id = d_id;
	}

	public String getD_bloodGroup() {
		return d_bloodGroup;
	}

	public void setD_bloodGroup(String d_bloodGroup) {
		this.d_bloodGroup = d_bloodGroup;
	}

	public String getD_altMobNo() {
		return d_altMobNo;
	}

	public void setD_altMobNo(String d_altMobNo) {
		this.d_altMobNo = d_altMobNo;
	}

	public String getD_ridingExperience() {
		return d_ridingExperience;
	}

	public void setD_ridingExperience(String d_ridingExperience) {
		this.d_ridingExperience = d_ridingExperience;
	}

	public String getD_ratings() {
		return d_ratings;
	}

	public void setD_ratings(String d_ratings) {
		this.d_ratings = d_ratings;
	}

	public String getD_education() {
		return d_education;
	}

	public void setD_education(String d_education) {
		this.d_education = d_education;
	}

	public String getD_knownLanguages() {
		return d_knownLanguages;
	}

	public void setD_knownLanguages(String d_knownLanguages) {
		this.d_knownLanguages = d_knownLanguages;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public DriverCategory getDriverCategory() {
		return driverCategory;
	}

	public void setDriverCategory(DriverCategory driverCategory) {
		this.driverCategory = driverCategory;
	}

	@Override
	public String toString() {
		return "Driver [d_id=" + d_id + ", d_bloodGroup=" + d_bloodGroup + ", d_altMobNo=" + d_altMobNo
				+ ", d_ridingExperience=" + d_ridingExperience + ", d_ratings=" + d_ratings + ", d_education="
				+ d_education + ", d_knownLanguages=" + d_knownLanguages + ", user=" + user + ", driverCategory="
				+ driverCategory + "]";
	}

	public Driver(int d_id, String d_bloodGroup, String d_altMobNo, String d_ridingExperience, String d_ratings,
			String d_education, String d_knownLanguages, User user, DriverCategory driverCategory) {
		super();
		this.d_id = d_id;
		this.d_bloodGroup = d_bloodGroup;
		this.d_altMobNo = d_altMobNo;
		this.d_ridingExperience = d_ridingExperience;
		this.d_ratings = d_ratings;
		this.d_education = d_education;
		this.d_knownLanguages = d_knownLanguages;
		this.user = user;
		this.driverCategory = driverCategory;
	}

	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
