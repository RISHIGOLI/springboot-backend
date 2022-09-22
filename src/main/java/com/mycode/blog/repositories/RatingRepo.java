package com.mycode.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mycode.blog.entities.Rating;

public interface RatingRepo extends JpaRepository<Rating, Integer>{

//	@Query("select (cast(avg(no_of_stars) as decimal(2,1))) as avgRating from ratings r where r.vehicle.id=:vehicleId")
//	Rating findAvgRatingByVehicle(@Param("vehicleId") Integer vehicleId);
	
//	@Query("select v from Vehicle v where v.city=:city and v.category.id=:categoryId")
//	List<Vehicle> findByCityandCategory(@Param ("city") String city, @Param("categoryId") Integer category_id);
}
