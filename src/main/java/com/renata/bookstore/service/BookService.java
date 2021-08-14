package com.renata.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renata.bookstore.domain.Book;
import com.renata.bookstore.repositories.BookRepository;
import com.renata.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryService categoryService;
	
	public Book findById(Integer id) {
		Optional<Book> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! || Id: " + id + " || Tipo do objeto: " + Book.class.getName()));
	
	}

	public List<Book> findAll(Integer id_cat) {
		categoryService.findById(id_cat);
		return repository.findAllByCategory(id_cat);
	}
}
