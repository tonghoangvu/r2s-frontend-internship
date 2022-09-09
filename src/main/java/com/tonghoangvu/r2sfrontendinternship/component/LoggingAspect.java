package com.tonghoangvu.r2sfrontendinternship.component;

import com.tonghoangvu.r2sfrontendinternship.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
@RequiredArgsConstructor
public class LoggingAspect {
	private final AuthService authService;

	@Before("execution(* com.tonghoangvu.r2sfrontendinternship.controller.*.*(..))")
	public void logApiCall(JoinPoint joinPoint) {
		if (!log.isInfoEnabled())
			return;
		String userIdentity = authService.getEmail();
		log.info("API - {}.{} - {}",
			joinPoint.getSignature().getDeclaringType().getSimpleName(),
			joinPoint.getSignature().getName(),
			userIdentity == null ? "Anonymous" : userIdentity);
	}
}
