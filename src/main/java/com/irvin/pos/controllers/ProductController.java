package com.irvin.pos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.irvin.pos.entities.Product;
import com.irvin.pos.exceptions.PropertyAlreadyExistException;
import com.irvin.pos.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Page<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(Product product) throws PropertyAlreadyExistException {
        Product p = productService.createProduct(product);
        return ResponseEntity.ok(p);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Product> deleteProduct(long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(Product product) {
        Product p = productService.updateProduct(product);
        return ResponseEntity.ok(p);
    }
}
