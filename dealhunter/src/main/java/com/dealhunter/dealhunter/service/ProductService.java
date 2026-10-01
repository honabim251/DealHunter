package com.dealhunter.dealhunter.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.dealhunter.dealhunter.exception.ProductNotFoundException;
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

    public void createProduct(Product product) {
        repository.save(product);
    }

    public List<Product> searchProducts(String name) {
        return repository.searchByName(name);
    }

    public List<Product> filterByCategory(String category) {
        return repository.filterByCategory(category);
    }

    public List<Product> filterByPrice(double minPrice, double maxPrice) {
        if (minPrice < 0 || maxPrice < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }

        if (minPrice > maxPrice) {
            throw new IllegalArgumentException("Invalid price range");
        }
        return repository.filterByPrice(minPrice, maxPrice);
    }

    public List<Product> getProductsByCategory(String category) {
        return source.fetchProducts().stream().filter(p -> p.getCategory().equalsIgnoreCase(category)).toList();
    }

    public List<Product> getProductsSortedByPrice() {
        return source.fetchProducts().stream()
                .sorted(Comparator.comparing(Product::getPrice)).toList();
    }

    public Map<String, List<Product>> groupProductsByCategory() {
        return source.fetchProducts().stream().collect(Collectors.groupingBy(Product::getCategory));
    }

    public Product getProductById(String id) {
        return repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    public List<Product> getTopDeals() {
        return source.fetchProducts().stream()
                .sorted(Comparator.comparingDouble(Product::getDiscount).reversed()).toList();
    }

    public List<Product> getTopDealsByCategory(String category) {
        return source.fetchProducts().stream().filter(product -> product.getCategory().equals(category))
                .sorted(Comparator.comparingDouble(Product::getDiscount).reversed()).limit(3).toList();
    }

    public Product getBestDealByCategory(String category) {
        return source.fetchProducts().stream().filter(product -> product.getCategory().equals(category))
                .max(Comparator.comparingDouble(Product::getDiscount))
                .orElseThrow(() -> new ProductNotFoundException(category));
    }
}
