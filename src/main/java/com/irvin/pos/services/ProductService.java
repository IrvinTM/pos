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

    public Product createProduct(Product product) throws PropertyAlreadyExistException {
        if (productRepository.getByCode(product.getCode()) != null) {
            throw new PropertyAlreadyExistException("code", String.valueOf(product.getCode()));
        }
        if (productRepository.getByBarcode(product.getBarCode()) != null) {
            throw new PropertyAlreadyExistException("bar_code", product.getBarCode());
        }
        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(long id) throws IllegalArgumentException {
        productRepository.deleteById(id);
    }

    // TODO pagination
    public Page<Product> getAllProducts() {
        return productRepository.findAll(PageRequest.of(0, 10));
    }

}
