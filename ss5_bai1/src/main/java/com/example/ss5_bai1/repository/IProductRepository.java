package com.example.ss5_bai1.repository;

import com.example.ss5_bai1.model.Product;

import java.util.List;

public interface IProductRepository {

    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(Product product);

    void remove(Product product);

    List<Product> searchByName(String name);
}