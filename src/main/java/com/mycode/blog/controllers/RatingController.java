package com.mycode.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycode.blog.entities.ApiResponse;
import com.mycode.blog.entities.Rating;
import com.mycode.blog.services.RatingService;

@RestController
@RequestMapping("/api/rating")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/vehicle/{vehicleId}/ratings")
	public ApiResponse<Rating> addRating(@RequestBody Rating rating, @PathVariable Integer vehicleId){
		Rating addRating = this.ratingService.addRating(rating, vehicleId);
		return new ApiResponse(addRating,"Rating added successfully",true,201);
	}
	
	@DeleteMapping("/deleteRating/{ratingId}")
	public ApiResponse<Rating> deleteRating(@PathVariable Integer ratingId){
		this.ratingService.deleteRating(ratingId);
		return new ApiResponse<>("comment deleted successfully", true, 200);
	}
	
//	@DeleteMapping("/comments/{commentId}")
//	public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer postId)
//	{
//		 this.commentService.deleteComment(postId);
//		 return new ResponseEntity<ApiResponse>(new ApiResponse("deleted comment successfully", true), HttpStatus.OK);
//	
//		
//	}
	
}