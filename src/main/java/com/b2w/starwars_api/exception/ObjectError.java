package com.b2w.starwars_api.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ObjectError {

	private final String message;
	private final String field;

	public ObjectError(String message, String field) {
		super();
		this.message = message;
		this.field = field;
	}

	public String getMessage() {
		return message;
	}

	public String getField() {
		return field;
	}

	@Override
	public String toString() {
		return "ObjectError [message=" + message + ", field=" + field + "]";
	}

}
