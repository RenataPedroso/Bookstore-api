package com.renata.bookstore.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	private List<FieldException> errors = new ArrayList<>();
	
	//contrutores da superclasse
	public ValidationError() {
		super();
	}
	public ValidationError(Long timestamp, Integer status, String error) {
		super(timestamp, status, error);
	}
	
	//getter e setter
	public List<FieldException> getErrors() {
		return errors;
	}
	public void addErrors(String fieldName, String message) {
		this.errors.add(new FieldException(fieldName, message));
	}
	
}
