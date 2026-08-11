package com.example.ss5_bai1.service;

import com.example.ss5_bai1.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(Product product);

    void remove(int id);

    List<Product> searchByName(String name);
}