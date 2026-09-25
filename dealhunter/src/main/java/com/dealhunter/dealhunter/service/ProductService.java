package com.dealhunter.dealhunter.service;

import java.util.List;

import com.dealhunter.dealhunter.model.Product;
import com.dealhunter.dealhunter.source.ProductSource;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private ProductSource source;

    public ProductService(ProductSource source) {
        this.source = source;
    }

    public List<Product> getProducts() {
        return source.fetchProducts();
    }
}
