package com.renata.bookstore.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renata.bookstore.domain.Book;
import com.renata.bookstore.service.BookService;

@RestController
@RequestMapping(value ="/books")
public class BookResources {

	@Autowired
	private BookService service;
	
	@GetMapping(value ="/{id}")
	public ResponseEntity<Book> findById(@PathVariable Integer id){
		Book obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
