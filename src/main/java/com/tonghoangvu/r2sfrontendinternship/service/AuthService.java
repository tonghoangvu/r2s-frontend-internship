package com.tonghoangvu.r2sfrontendinternship.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
	public Authentication getAuth() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	public String getEmail() {
		Authentication auth = getAuth();
		return auth == null ? null : auth.getName();
	}
}
