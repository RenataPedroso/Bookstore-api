package com.renata.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.renata.bookstore.domain.Book;
import com.renata.bookstore.domain.Category;
import com.renata.bookstore.repositories.BookRepository;
import com.renata.bookstore.repositories.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{

	// chamando camadas de acesso aos dados
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private BookRepository bookRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null,"Informática", "Livros de TI");
	
		//para o livro reconhecer a categoria
		Book l1 = new Book(null,"Clean Code","Robert Martin","Lorem ipsum", cat1);
		
		//para a categoria reconhecer os livros
		cat1.getBooks().addAll(Arrays.asList(l1));
		
		//salvando categorias
		this.categoryRepository.saveAll(Arrays.asList(cat1));
		//salvando livros
		this.bookRepository.saveAll(Arrays.asList(l1));
	}

}
