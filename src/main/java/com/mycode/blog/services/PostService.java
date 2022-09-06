package com.mycode.blog.services;

import java.util.List;

import com.mycode.blog.entities.Post;
import com.mycode.blog.payloads.PostDto;
import com.mycode.blog.payloads.PostResponse;

public interface PostService {
	
	//create
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	//update
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//delete
	void deletePost(Integer postId);
	
	//get all post
	List<PostDto> getAllPost();
	
	//get all post with pagination
	PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
	
	//get post by id
	PostDto getPostById(Integer postId);
	
	//get all post by category
	List<PostDto> getPostByCategory(Integer categoryId);
	
	//get all post by user
	List<PostDto> getPostByUser(Integer userId);
	
	//search
	List<PostDto> searchPosts(String keyword);
	
	
	
}
