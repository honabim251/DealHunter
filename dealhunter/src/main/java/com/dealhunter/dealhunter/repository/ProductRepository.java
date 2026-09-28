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

    public List<Product> searchByName(String name) {
        List<Product> lsPrd = new ArrayList<>();

        for (Product product : this.findAll()) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                lsPrd.add(product);
            }
        }
        return lsPrd;
    }

    public List<Product> filterByCategory(String category) {

        List<Product> lsPrd = new ArrayList<>();

        for (Product product : this.findAll()) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                lsPrd.add(product);
            }
        }
        return lsPrd;
    }

    public List<Product> filterByPrice(double minPrice, double maxPrice) {
        List<Product> lsPrd = new ArrayList<>();

        for (Product product : this.findAll()) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                lsPrd.add(product);
            }
        }
        return lsPrd;
    }
}