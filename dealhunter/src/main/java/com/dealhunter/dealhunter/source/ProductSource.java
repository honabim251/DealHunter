package com.dealhunter.dealhunter.source;

import java.util.List;

import com.dealhunter.dealhunter.model.Product;

public interface ProductSource {
    List<Product> fetchProducts();

}