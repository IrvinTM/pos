package com.irvin.pos.services;

import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.irvin.pos.entities.Product;
import com.irvin.pos.exceptions.PropertyAlreadyExistException;
import com.irvin.pos.repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product CreateOrUpdateProduct(Product product) throws PropertyAlreadyExistException {
        if (productRepository.getByCode(product.getCode()) != null
                | productRepository.getByBarcode(product.getBarCode()) != null) {
            throw new PropertyAlreadyExistException("code", String.valueOf(product.getCode()));
        }
        return productRepository.save(product);
    }

    public void deleteProduct(Product product) throws IllegalArgumentException {
        productRepository.delete(product);
    }

    // First page only
    public Page<Product> getAllProducts() {
        return productRepository.findAll(PageRequest.of(0, 10));
    }

}
