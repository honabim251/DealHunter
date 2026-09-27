package com.dealhunter.dealhunter.model;

public class Product {
    private double price;
    private String ID;

    public Product(String id, double price) {
        this.ID = id;
        this.price = price;
    }

    public String getID() {
        return this.ID;
    }

    public void setName(String id) {
        this.ID = id;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
