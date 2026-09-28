package com.dealhunter.dealhunter.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dealhunter.dealhunter.model.Product;
import com.dealhunter.dealhunter.service.ProductService;

@RequestMapping("/products")
@RestController
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @GetMapping("/{id}")
    public Product getProductsById(@PathVariable String id) {
        return service.getProductById(id);
    }
}