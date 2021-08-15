package com.renata.bookstore.resources.exceptions;

import java.io.Serializable;

public class FieldException implements Serializable {

	private static final long serialVersionUID = 1L;

	private String fieldName;
	private String message;

	// contrutor da super classe
	public FieldException() {
		super();
	}

	// construtor com parametros
	public FieldException(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}

	// getters e setters
	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
