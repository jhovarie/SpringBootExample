package com.dbexample.h2crud.repository;

//import com.dbexample.h2crud.Product;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbexample.h2crud.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
}