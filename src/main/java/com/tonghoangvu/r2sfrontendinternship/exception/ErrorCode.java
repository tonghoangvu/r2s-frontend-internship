package com.tonghoangvu.r2sfrontendinternship.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public enum ErrorCode {
	SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Server error"),
	BAD_REQUEST(HttpStatus.BAD_REQUEST, "Bad request"),
	USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User does not exist");

	public final HttpStatus status;
	public final String message;
}
