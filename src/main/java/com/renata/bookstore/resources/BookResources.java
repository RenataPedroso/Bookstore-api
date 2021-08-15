package com.renata.bookstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.renata.bookstore.domain.Book;
import com.renata.bookstore.dtos.BookDTO;
import com.renata.bookstore.service.BookService;

@RestController
@RequestMapping(value = "/books")
public class BookResources {

	@Autowired
	private BookService service;

	//mostrar livro por id
	@GetMapping(value = "/{id}")
	public ResponseEntity<Book> findById(@PathVariable Integer id) {
		Book obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	//mostrar todos os livros por categoria
	@GetMapping
	public ResponseEntity<List<BookDTO>> findAll(@RequestParam(value = "category", defaultValue = "0") Integer id_cat) {
		List<Book> list = service.findAll(id_cat);
		//transformar a lista de livros para uma lista de livros no padrão dto
		List<BookDTO> listDTO = list.stream().map(obj -> new BookDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	//put para atualizar todas as informações do livro
	@PutMapping(value ="/{id}")
	public ResponseEntity<Book> update(@PathVariable Integer id, @RequestBody Book obj) {
		Book newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	//patch para atualizar apenas uma informação do livro
	@PatchMapping(value ="/{id}")
	public ResponseEntity<Book> updatePatch(@PathVariable Integer id, @RequestBody Book obj) {
		Book newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	//post para criar o livro
	@PostMapping
	public ResponseEntity<Book> create(@RequestParam(value ="category", defaultValue = "0") Integer id_cat, @RequestBody Book obj){
		Book newObj = service.create(id_cat, obj);
		java.net.URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/books/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//delete para livros
	@DeleteMapping(value ="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
			service.delete(id);
			return ResponseEntity.noContent().build();
	}

}
