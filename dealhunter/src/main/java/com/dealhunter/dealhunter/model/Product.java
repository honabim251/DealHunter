package com.dealhunter.dealhunter.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class Product {
    @NotBlank(message = "Product id must not be blank")
    private String id;

    @NotBlank(message = "Product name must not be blank")
    private String name;

    @NotBlank(message = "Category must not be blank")
    private String category;

    @Positive(message = "Price must be greater than 0")
    private double price;

    @Min(value = 0, message = "Discount must be at least 0")
    @Max(value = 100, message = "Discount must not exceed 100")
    private double discount;

    public Product(String id, String name, String category, double price, double discount) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.discount = discount;
    }

    public String getID() {
        return this.id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getDiscount() {
        return this.discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
