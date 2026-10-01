package com.dealhunter.dealhunter.source;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dealhunter.dealhunter.model.Product;

@Component
public class ShopeeProductSource implements ProductSource {
    @Override
    public List<Product> fetchProducts() {
        Product p1 = new Product("P01", "Akko keyboard", "Keyboard", 1500000, 20);
        Product p2 = new Product("P02", "SteelSeries Mouse", "Mouse", 1200000, 15);
        Product p3 = new Product("P03", "PS5 Controller", "Controller", 1800000, 30);
        Product p4 = new Product("P04", "Shoppe keyboard", "Keyboard", 1700000, 40);
        Product p5 = new Product("P05", "Logitech Mouse", "Mouse", 1900000, 25);
        Product p6 = new Product("P06", "Sony Controller", "Controller", 1100000, 35);
        Product p7 = new Product("P07", "Goku keyboard", "Keyboard", 1700000, 60);
        Product p8 = new Product("P08", "Goku Mouse", "Mouse", 1260000, 65);
        Product p9 = new Product("P09", "Goku Controller", "Controller", 1850000, 80);

        List<Product> listPrd = new ArrayList<>();
        listPrd.add(p1);
        listPrd.add(p2);
        listPrd.add(p3);
        listPrd.add(p4);
        listPrd.add(p5);
        listPrd.add(p6);
        listPrd.add(p7);
        listPrd.add(p8);
        listPrd.add(p9);
        return listPrd;
    }
}
