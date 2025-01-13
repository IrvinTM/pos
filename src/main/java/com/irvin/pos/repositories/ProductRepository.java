package com.irvin.pos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irvin.pos.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    public Product getByCode(String code);

    public Product getByBarCode(String barCode);
}
