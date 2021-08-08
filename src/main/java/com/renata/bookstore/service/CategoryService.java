/*
	Adicionar @Service para informmar que é uma classe de serviço
	Criar o método findById()
	a camada que faz acesso aos dados é a Repository, então intanciar
  	@Autowired
  	como o próprio JPA já possui o método, não é necessário implementar o SQL
  	Adicionar Optional<>(do pacote java.util) porque pode ser que encontre uma categoria com esse id ou não
  	 
  
*/

package com.renata.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renata.bookstore.domain.Category;
import com.renata.bookstore.repositories.CategoryRepository;


@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public Category findById(Integer id) {
		Optional<Category> obj = repository.findById(id);
		return obj.orElse(null);
	}
	
}
