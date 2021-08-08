/*
	Trocar na classe CategoryService para uma função anonima que chamará o ObjectoNotFoundException
*/

package com.renata.bookstore.service.exceptions;

public class ObjectNotFoundException extends RuntimeException {

	public ObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ObjectNotFoundException(String message) {
		super(message);
	}

	private static final long serialVersionUID = 1L;

}
