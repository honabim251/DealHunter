package com.dealhunter.dealhunter.source;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dealhunter.dealhunter.model.Product;

@Component
public class ShopeeProductSource implements ProductSource {
    @Override
    public List<Product> fetchProducts() {
        Product p1 = new Product("Akko keyboard", 1500000);
        Product p2 = new Product("SteelSeries Mouse", 1200000);
        Product p3 = new Product("PS5 Controller", 1800000);

        List<Product> listPrd = new ArrayList<>();
        listPrd.add(p1);
        listPrd.add(p2);
        listPrd.add(p3);
        return listPrd;
    }
}
