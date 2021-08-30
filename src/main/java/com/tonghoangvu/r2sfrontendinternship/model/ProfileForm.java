package com.tonghoangvu.r2sfrontendinternship.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ProfileForm {
	@NotEmpty(message = "First name is required")
	@Size(min = 3, max = 30, message = "First name must be between 3 and 30 characters long")
	private String firstName;

	@NotEmpty(message = "Last name is required")
	@Size(min = 3, max = 30, message = "Last name must be between 3 and 30 characters long")
	private String lastName;

	@NotEmpty(message = "Phone is required")
	@Size(min = 9, max = 13, message = "Phone must be between 9 and 13 characters long")
	private String phone;

	@Size(max = 200, message = "Description must be 200 characters or less")
	private String description;
}
