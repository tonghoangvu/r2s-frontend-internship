package com.tonghoangvu.r2sfrontendinternship.controller;

import com.tonghoangvu.r2sfrontendinternship.model.RegisterForm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {
	@PostMapping("/register")
	public void register(@Valid RegisterForm registerForm) {
		System.out.println(registerForm);
	}
}
