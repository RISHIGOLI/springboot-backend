package com.mycode.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycode.blog.entities.Rating;

public interface RatingRepo extends JpaRepository<Rating, Integer>{

}
