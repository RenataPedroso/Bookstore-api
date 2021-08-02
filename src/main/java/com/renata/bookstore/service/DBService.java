// CLASSE PARA INSTANCIAR A BASE DE DADOS

package com.renata.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renata.bookstore.domain.Book;
import com.renata.bookstore.domain.Category;
import com.renata.bookstore.repositories.BookRepository;
import com.renata.bookstore.repositories.CategoryRepository;

@Service
public class DBService {
	// chamando camadas de acesso aos dados
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private BookRepository bookRepository;

	public void InstanceDataBase() {

		// criação das categorias
		Category cat1 = new Category(null, "Informática", "Livros de TI");
		Category cat2 = new Category(null, "Desenvolvimento Pessoal", "Livros de auto-ajuda e desenvolvimento pessoal");
		Category cat3 = new Category(null, "Ficção Científica", "Livros de ficcção cientifica");
		Category cat4 = new Category(null, "Romance", "Livros de romance");

		// para o livro reconhecer a categoria
		Book l1 = new Book(null, "Clean Code", "Robert Martin", "Lorem ipsum", cat1);
		Book l2 = new Book(null,
				"Programação Funcional para Desenvolvedores Java: Ferramentas para Melhor Concorrência, Abstração e Agilidade",
				"Dean Wampler", "Lorem Ipsum", cat1);
		Book l3 = new Book(null, "Produtividade para quem quer tempo", "Geronimo Theml", "Lorem Ipsum", cat2);
		Book l4 = new Book(null, "7 Hábitos das Pessoas Altamente Eficazes", "Stephen Covey", "Lorem Ipsun", cat2);
		Book l5 = new Book(null, "1984", "George Orwell", "Lorem Ipsum", cat3);
		Book l6 = new Book(null, "Admirável Mundo Novo", "Aldous Huxley", "Lorem Ipsum", cat3);

		// para a categoria reconhecer os livros
		cat1.getBooks().addAll(Arrays.asList(l1, l2));
		cat2.getBooks().addAll(Arrays.asList(l3, l4));
		cat3.getBooks().addAll(Arrays.asList(l5, l6));

		// salvando categorias
		this.categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));

		// salvando livros
		this.bookRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5, l6));

	}

}
