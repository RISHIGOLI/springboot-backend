package com.mycode.blog.payloads;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.mycode.blog.entities.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	
	private int id;
	
	//@NotNull
	@NotEmpty
	@Size(min = 4, message="username must be min of 4 characters")
	private String name;
	
	@Email(message="email address is not valid !")
	private String email;
	
	//@NotNull
	@NotEmpty
	@Size(min = 3, max = 10, message = "password must be min of 3 chars and max of 10 chars")
	private String password;
	
	//@NotNull
	@NotEmpty
	private String about;
	
	private Set<RoleDto> roles = new HashSet<>();
	
	
}
