package com.mycode.blog.services;

import com.mycode.blog.entities.DriverRating;

public interface DriverRatingService {

	DriverRating addDriverRating(DriverRating driverRating, Integer driverId);

	void deleteDriverRating(Integer d_ratingId);

}
