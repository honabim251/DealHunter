package com.dealhunter.dealhunter.service;

import java.util.List;

import com.dealhunter.dealhunter.model.Product;
import com.dealhunter.dealhunter.repository.ProductRepository;
import com.dealhunter.dealhunter.source.ProductSource;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private ProductSource source;
    private ProductRepository repository;

    public ProductService(ProductSource source,
            ProductRepository repository) {
        this.source = source;
        this.repository = repository;
    }

    public List<Product> getProducts() {
        List<Product> products = source.fetchProducts();

        for (Product product : products) {
            repository.save(product);
        }

        return products;
    }

    public Product getProductById(String id) {
        return repository.findById(id);
    }
}
