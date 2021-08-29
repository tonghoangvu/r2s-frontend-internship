package com.tonghoangvu.r2sfrontendinternship.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
	SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR),
	BAD_REQUEST(HttpStatus.BAD_REQUEST),
	USER_NOT_FOUND(HttpStatus.NOT_FOUND);

	private final HttpStatus status;
}
