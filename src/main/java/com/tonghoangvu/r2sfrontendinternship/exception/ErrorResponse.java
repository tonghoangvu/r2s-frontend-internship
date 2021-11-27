package com.tonghoangvu.r2sfrontendinternship.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ErrorResponse {
	private final ErrorCode code;
	private final String message;

	public ErrorResponse(ErrorCode code) {
		this(code, code.message);
	}
}
