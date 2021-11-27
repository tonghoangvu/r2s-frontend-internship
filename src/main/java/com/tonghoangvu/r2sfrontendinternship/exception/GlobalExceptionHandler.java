package com.tonghoangvu.r2sfrontendinternship.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	@ExceptionHandler(ApiException.class)
	protected ResponseEntity<ErrorResponse> handleApiException(ApiException e) {
		var response = new ErrorResponse(e.getCode());
		return ResponseEntity
			.status(e.getCode().status)
			.body(response);
	}

	@ExceptionHandler({
		BindException.class,
		MethodArgumentTypeMismatchException.class
	})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	protected ErrorResponse handleBindException(Exception e) {
		String message = null;
		if (e instanceof BindException bindException)
			message = bindException.getAllErrors().get(0).getDefaultMessage();
		return message == null
			? new ErrorResponse(ErrorCode.BAD_REQUEST)
			: new ErrorResponse(ErrorCode.BAD_REQUEST, message);
	}

	@ExceptionHandler(Exception.class)
	protected ErrorResponse handleUnwantedException(Exception e) {
		log.error("Ops!", e);
		return new ErrorResponse(ErrorCode.SERVER_ERROR);
	}
}
