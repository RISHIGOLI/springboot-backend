package com.mycode.blog.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycode.blog.entities.ApiResponse;
import com.mycode.blog.entities.Category;
import com.mycode.blog.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/createCategory")
	public ApiResponse<Category> createCategory(@Valid @RequestBody Category category ){
		this.categoryService.createCategory(category);
		return new ApiResponse(category,"Category added successfully.",true,201);
	}
	
	@DeleteMapping("/deleteCategory/{categoryId}")
	public ApiResponse<Category> deleteCategory(@PathVariable Integer categoryId){
		this.categoryService.deleteCategory(categoryId);
		//Category category = this.categoryService.getCategoryById(categoryId);
		return new ApiResponse("Category with" + categoryId + "deleted successfully.",true,200);
	}
	
	
	//get
		@GetMapping("/categories/{categoryId}")
		public ApiResponse<Category> getCategoryById(@PathVariable Integer categoryId)
		{
			Category category = this.categoryService.getCategoryById(categoryId);
			return new ApiResponse(category,"Category found",true,200);
		}
	
}
