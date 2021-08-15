package com.renata.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renata.bookstore.domain.Book;
import com.renata.bookstore.domain.Category;
import com.renata.bookstore.repositories.BookRepository;
import com.renata.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryService categoryService;
	
	//procurar livro por id
	public Book findById(Integer id) {
		Optional<Book> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! || Id: " + id + " || Tipo do objeto: " + Book.class.getName()));
	
	}
 
	//mostrar todos por categoria
	public List<Book> findAll(Integer id_cat) {
		categoryService.findById(id_cat);
		return repository.findAllByCategory(id_cat);
	}

	//atualizar livro
	public Book update(Integer id, Book obj) {
		Book newObj = findById(id);
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	//método privado para trazer o liVro atualizado
	private void updateData(Book newObj, Book obj) {
		newObj.setTitle(obj.getTitle());
		newObj.setAutor_name(obj.getAutor_name());
		newObj.setText(obj.getText());
	}

	//metodo para criar categoria
	public Book create(Integer id_cat, Book obj) {
		//setar id como nulo
		obj.setId(null);
		//verificar se a categoria existe
		Category cat = categoryService.findById(id_cat);
		//fazer com que o livro reconheça a categoria
		obj.setCategory(cat);
		//salvar objeto e retornar ele
		return repository.save(obj);
	}

	//metodo para deletar livro
	public void delete(Integer id) {
		Book obj = findById(id);
		repository.delete(obj);
	}
}
