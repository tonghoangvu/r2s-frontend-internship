package com.tonghoangvu.r2sfrontendinternship.service;

import com.tonghoangvu.r2sfrontendinternship.entity.User;
import com.tonghoangvu.r2sfrontendinternship.exception.ApiException;
import com.tonghoangvu.r2sfrontendinternship.exception.ErrorCode;
import com.tonghoangvu.r2sfrontendinternship.model.RegisterForm;
import com.tonghoangvu.r2sfrontendinternship.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
	private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepository;

	public User createUser(RegisterForm registerForm) {
		var user = new User();
		user.setEmail(registerForm.getEmail());
		user.setUsername(registerForm.getUsername());
		user.setPassword(passwordEncoder.encode(registerForm.getPassword()));
		return userRepository.save(user);
	}

	public User getUser(String email) {
		User user = userRepository.findByEmail(email);
		if (user == null)
			throw new ApiException(ErrorCode.USER_NOT_FOUND, "User does not exist");
		return user;
	}
}
