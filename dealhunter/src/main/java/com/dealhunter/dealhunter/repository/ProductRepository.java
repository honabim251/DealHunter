package com.dealhunter.dealhunter.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dealhunter.dealhunter.exception.ProductNotFoundException;
import com.dealhunter.dealhunter.model.Product;

@Repository
public class ProductRepository implements GenericRepository<Product, String> {
    private Map<String, Product> products = new HashMap<>();

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        this.products.put(product.getID(), product);
    }

    @Override
    public Product findById(String id) {
        Product product = products.get(id);

        if (product == null) {
            throw new ProductNotFoundException(id);
        }

        return product;
    }
}