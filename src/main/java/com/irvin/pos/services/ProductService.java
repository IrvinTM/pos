package com.irvin.pos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irvin.pos.entities.Product;
import com.irvin.pos.exceptions.PropertyAlreadyExistException;
import com.irvin.pos.repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product CreateOrUpdateProduct(Product product) {
        if (productRepository.getByCode(product.getCode()) != null | productRepository.getByBarcode(product.getBarCode()) != null) {
            throw new PropertyAlreadyExistException("code", String.valueOf(product.getCode()));
            }
        return  
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

}
