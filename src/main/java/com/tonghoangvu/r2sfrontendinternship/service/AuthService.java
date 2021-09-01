package com.tonghoangvu.r2sfrontendinternship.service;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
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
		if (auth instanceof AnonymousAuthenticationToken)
			return null;
		else
			return auth.getName();
	}
}
