package com.dbexample.h2crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dbexample.h2crud.model.Product;
import com.dbexample.h2crud.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        Optional<Product> existingProduct = productService.getProductById(id);

        if (existingProduct.isPresent()) {
            // Update only the fields that are provided in the request
            Product productToUpdate = existingProduct.get();
            productToUpdate.setName(updatedProduct.getName());
            productToUpdate.setDescription(updatedProduct.getDescription());
            productToUpdate.setPrice(updatedProduct.getPrice());
            productToUpdate.setQuantity(updatedProduct.getQuantity());

            // Save the updated product
            productService.saveProduct(productToUpdate);

            return ResponseEntity.ok(productToUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProductsByName(@RequestParam String name) {
        List<Product> searchResults = productService.searchProductsByName(name);
        return new ResponseEntity<>(searchResults, HttpStatus.OK);
    }
    
}
