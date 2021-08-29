package com.tonghoangvu.r2sfrontendinternship.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class RegisterForm {
	@NotNull(message = "Username is required")
	@Size(min = 3, max = 30, message = "Username must be between 3 and 30 characters long")
	private String username;

	@NotNull(message = "Email is required")
	@Size(min = 5, message = "Email must be 5 characters or more")
	@Email(message = "Email is invalid")
	private String email;

	@NotNull(message = "Password is required")
	@Size(min = 8, max = 30, message = "Password must be between 8 and 30 characters long")
	private String password;
}
