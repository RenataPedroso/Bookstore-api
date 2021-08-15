/*
	classe de controlador REST que receberá requisições
	@RequestMapping irá mapear o caminho para acesso de determinada categoria pelo Id dela
	localhost:8080/categories/1
	criação do método que irá realizar essa busca pelo id
	@GetMapping receberá requisição get e iniciará o método
	a lógica de negócio precisa estar em service, então organizar o service
	instanciar a CategoryService
	ResponseEntity.ok().body(obj) irá retornar o objeto encontrado	
*/

package com.renata.bookstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.renata.bookstore.domain.Category;
import com.renata.bookstore.dtos.CategoryDTO;
import com.renata.bookstore.service.CategoryService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@Autowired
	private CategoryService service;

	//procurar categoria pelo id
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Integer id) {
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	//mostrar todas as categorias
	@GetMapping
	public ResponseEntity<List<CategoryDTO>> findAll() {
		List<Category> list = service.findAll();
		List<CategoryDTO> listDTO = list.stream().map(obj -> new CategoryDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	//criar categoria
	@PostMapping
	public ResponseEntity<Category> create(@Valid @RequestBody Category obj) {
		obj = service.create(obj);
		java.net.URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	//alterar categoria
	@PutMapping(value ="/{id}")
	public ResponseEntity<CategoryDTO> update(@PathVariable Integer id, @Valid @RequestBody CategoryDTO objDto){
		Category newObj = service.update(id, objDto);
		return ResponseEntity.ok().body(new CategoryDTO(newObj));
	}
	
	//deletar categoria por id
	@DeleteMapping(value ="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
