package com.tonghoangvu.r2sfrontendinternship.component;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
	@Before("execution(* com.tonghoangvu.r2sfrontendinternship.controller.*.*(..))")
	public void logApiCall(JoinPoint joinPoint) {
		log.info("API: {}.{}",
			joinPoint.getSignature().getDeclaringType().getSimpleName(),
			joinPoint.getSignature().getName());
	}
}
