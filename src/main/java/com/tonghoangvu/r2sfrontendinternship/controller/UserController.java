package com.tonghoangvu.r2sfrontendinternship.controller;

import com.tonghoangvu.r2sfrontendinternship.model.RegisterForm;
import com.tonghoangvu.r2sfrontendinternship.model.UserModel;
import com.tonghoangvu.r2sfrontendinternship.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;

	@PostMapping("/register")
	public UserModel register(@Valid RegisterForm registerForm) {
		return new UserModel(userService.createUser(registerForm));
	}
}
