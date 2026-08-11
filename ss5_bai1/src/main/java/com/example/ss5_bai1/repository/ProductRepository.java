package com.example.ss5_bai1.repository;

import com.example.ss5_bai1.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        return entityManager
                .createQuery("SELECT p FROM Product p", Product.class)
                .getResultList();
    }

    @Override
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public void update(Product product) {
        entityManager.merge(product);
    }

    @Override
    public void remove(Product product) {
        Product managedProduct = entityManager.contains(product)
                ? product
                : entityManager.merge(product);

        entityManager.remove(managedProduct);
    }

    @Override
    public List<Product> searchByName(String name) {
        return entityManager
                .createQuery(
                        "SELECT p FROM Product p " +
                                "WHERE LOWER(p.name) LIKE LOWER(:name)",
                        Product.class
                )
                .setParameter("name", "%" + name + "%")
                .getResultList();
    }
}