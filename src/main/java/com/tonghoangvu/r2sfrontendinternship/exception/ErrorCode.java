package com.tonghoangvu.r2sfrontendinternship.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
	SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR),
	BAD_REQUEST(HttpStatus.BAD_REQUEST);

	private final HttpStatus status;
}
