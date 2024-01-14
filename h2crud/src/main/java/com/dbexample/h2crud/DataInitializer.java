package com.dbexample.h2crud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dbexample.h2crud.model.Product;
import com.dbexample.h2crud.repository.ProductRepository;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initializeData(ProductRepository productRepository) {
        return args -> {
            // Insert initial data
            Product product1 = new Product();
            product1.setName("Product 1");
            product1.setDescription("Description 1");
            product1.setPrice(19.99);
            product1.setQuantity(100);

            Product product2 = new Product();
            product2.setName("Product 2");
            product2.setDescription("Description 2");
            product2.setPrice(29.99);
            product2.setQuantity(50);

            productRepository.save(product1);
            productRepository.save(product2);
        };
    }
}