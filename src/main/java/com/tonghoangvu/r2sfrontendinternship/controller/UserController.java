package com.tonghoangvu.r2sfrontendinternship.controller;

import com.tonghoangvu.r2sfrontendinternship.model.ProfileForm;
import com.tonghoangvu.r2sfrontendinternship.model.RegisterForm;
import com.tonghoangvu.r2sfrontendinternship.model.UserModel;
import com.tonghoangvu.r2sfrontendinternship.service.AuthService;
import com.tonghoangvu.r2sfrontendinternship.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Api(tags = "User APIs")
public class UserController {
	private final AuthService authService;
	private final UserService userService;

	@PostMapping("/register")
	@ApiOperation("Register a new user")
	@ApiResponses({})
	public UserModel register(@Valid RegisterForm registerForm) {
		return new UserModel(userService.createUser(registerForm));
	}

	@GetMapping("/profile")
	@ApiOperation("Get my profile")
	@ApiResponses(@ApiResponse(code = 404, message = "USER_NOT_FOUND"))
	public UserModel getMyProfile() {
		String myEmail = authService.getEmail();
		return new UserModel(userService.getUser(myEmail));
	}

	@PutMapping("/profile")
	@ApiOperation("Update my profile")
	@ApiResponses(@ApiResponse(code = 404, message = "USER_NOT_FOUND"))
	public UserModel updateMyProfile(@Valid ProfileForm profileForm) {
		String myEmail = authService.getEmail();
		return new UserModel(userService.updateUser(myEmail, profileForm));
	}
}
