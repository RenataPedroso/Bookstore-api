/*
	Adicionar @Service para informmar que é uma classe de serviço
	Criar o método findById()
	a camada que faz acesso aos dados é a Repository, então intanciar
  	@Autowired
  	como o próprio JPA já possui o método, não é necessário implementar o SQL
  	Adicionar Optional<>(do pacote java.util) porque pode ser que encontre uma categoria com esse id ou não
  	 
  	Criar um manipulador de exceção de recursos em resources.exceptions
  	Criar StandardError em resources.exceptions
*/

package com.renata.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renata.bookstore.domain.Category;
import com.renata.bookstore.repositories.CategoryRepository;
import com.renata.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	public Category findById(Integer id) {
		Optional<Category> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! || Id: " + id + " || Tipo do objeto: " + Category.class.getName()));
	}
	
	public List<Category> findAll(){
		return repository.findAll();
	}

}
