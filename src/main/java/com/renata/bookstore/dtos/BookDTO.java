package com.renata.bookstore.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.renata.bookstore.domain.Book;

public class BookDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "Preencha o campo TITLE")
	@Length(min =3, max =200, message = "O Campo TITLE precisa ter no mínimo 3 e no máximo 100 caracteres")
	private String title;

	public BookDTO() {
		super();
	}

	public BookDTO(Book obj) {
		super();
		this.id = obj.getId();
		this.title = obj.getTitle();
	}

	// Getter e Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
