/*
	Implementação do padrão DTO para a classe categoria
*/

package com.renata.bookstore.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.renata.bookstore.domain.Category;

public class CategoryDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "Preencha o campo NAME")
	@Length(min = 3, max = 100, message = "O Campo NAME precisa ter no mínimo 3 e no máximo 100 caracteres")
	private String name;
	
	@NotEmpty(message = "Preencha o campo DESCRIPTION")
	@Length(min = 3, max = 300, message = "O Campo DESCRIPTION precisa ter no mínimo 3 e no máximo 100 caracteres")
	private String description;

	public CategoryDTO() {
		super();
	}

	public CategoryDTO(Category obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.description = obj.getDescription();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
