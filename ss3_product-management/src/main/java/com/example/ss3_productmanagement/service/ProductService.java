package com.example.ss3_productmanagement.service;

import com.example.ss3_productmanagement.model.Product;

import java.util.ArrayList;
import java.util.List;
public class ProductService implements IProductService {
    private static final List<Product> products = new ArrayList<>();
    static {
        products.add(new Product(1, "iPhone 15", 2000, "Điện thoại Apple", "Apple"));
        products.add(new Product(2, "Samsung Galaxy S24", 1800, "Điện thoại Samsung", "Samsung"));
        products.add(new Product(3, "Xiaomi 14", 1200, "Điện thoại Xiaomi", "Xiaomi"));
        products.add(new Product(4, "Oppo Find X7", 1000, "Điện thoại Oppo", "Oppo"));
        products.add(new Product(5, "MacBook Air M3", 2500, "Laptop Apple", "Apple"));
    }
    @Override
    public List<Product> findAll() {
        return products;
    }
    @Override
    public void save(Product product) {
        products.add(product);
    }
    @Override
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
    @Override
    public void update(int id, Product product) {
        Product existingProduct = findById(id);

        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setManufacturer(product.getManufacturer());
        }
    }
    @Override
    public void remove(int id) {
        Product product = findById(id);
        if (product != null) {
            products.remove(product);
        }
    }
    @Override
    public List<Product> searchByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }
}