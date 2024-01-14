package com.dbexample.h2crud.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dbexample.h2crud.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByNameContainingIgnoreCase(String name);
	List<Product> findAll();
}