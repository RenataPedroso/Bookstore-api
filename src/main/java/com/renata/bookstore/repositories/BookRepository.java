package com.renata.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.renata.bookstore.domain.Category;

@Repository
public interface BookRepository extends JpaRepository<Category, Integer>{

}
