package com.renata.bookstore.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Preencha o campo TITLE")
	@Length(min =3, max =500, message = "O Campo TITLE precisa ter no mínimo 3 e no máximo 100 caracteres")
	private String title;
	
	@NotEmpty(message = "Preencha o campo AUTOR NAME")
	@Length(min =3, max =500, message = "O Campo AUTOR NAME precisa ter no mínimo 3 e no máximo 100 caracteres")
	private String autor_name;
	
	@NotEmpty(message = "Preencha o campo TEXT")
	@Length(min =3, max =2000000, message = "O Campo TEXT precisa ter no mínimo 3 e no máximo 2.000.000 caracteres")
	private String text;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	public Book() {
		super();
	}

	public Book(Integer id, String title, String autor_name, String text, Category category) {
		super();
		this.id = id;
		this.title = title;
		this.autor_name = autor_name;
		this.text = text;
		this.category = category;
	}

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

	public String getAutor_name() {
		return autor_name;
	}

	public void setAutor_name(String autor_name) {
		this.autor_name = autor_name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
