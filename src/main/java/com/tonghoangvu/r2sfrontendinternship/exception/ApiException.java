package com.tonghoangvu.r2sfrontendinternship.exception;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {
	private final ErrorCode code;

	public ApiException(ErrorCode code, String message) {
		super(message);
		this.code = code;
	}

	public ApiException(ErrorCode code) {
		this(code, code.message);
	}
}
