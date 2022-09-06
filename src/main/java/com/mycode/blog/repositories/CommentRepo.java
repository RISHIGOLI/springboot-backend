package com.mycode.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycode.blog.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{
	
}
