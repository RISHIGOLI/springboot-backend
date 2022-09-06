package com.mycode.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycode.blog.entities.Category;
import com.mycode.blog.entities.Post;
import com.mycode.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{
	
	List<Post> findByUser(User user);
	
	

	List<Post> findByCategory(Category cat);
	
	List<Post> findByTitleContaining(String title);
	//List<Post> findByContentContaining(String title);
	
	
	
	

}
