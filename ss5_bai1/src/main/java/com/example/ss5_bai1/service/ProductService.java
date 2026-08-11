package com.example.ss5_bai1.service;

import com.example.ss5_bai1.model.Product;
import com.example.ss5_bai1.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class ProductService implements IProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    @Transactional
    public void update(Product product) {
        productRepository.update(product);
    }

    @Override
    @Transactional
    public void remove(int id) {
        Product product = productRepository.findById(id);

        if (product != null) {
            productRepository.remove(product);
        }
    }

    @Override
    public List<Product> searchByName(String name) {
        return productRepository.searchByName(name);
    }
}