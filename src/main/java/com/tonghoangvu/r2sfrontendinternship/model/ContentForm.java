package com.tonghoangvu.r2sfrontendinternship.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ContentForm {
	@NotEmpty(message = "Title is required")
	@Size(min = 10, max = 200, message = "Title must be between 10 and 200 characters long")
	private String title;

	@NotEmpty(message = "Brief is required")
	@Size(min = 30, max = 150, message = "Brief must be between 30 and 150 characters long")
	private String brief;

	@NotEmpty(message = "Content is required")
	@Size(min = 50, max = 1000, message = "Content must be between 50 and 1000 characters long")
	private String content;

	private String createdDate;
}
