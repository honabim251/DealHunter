package com.dealhunter.dealhunter.cli;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.dealhunter.dealhunter.model.Product;
import com.dealhunter.dealhunter.service.ProductService;

@Component
public class DealHunterCli implements CommandLineRunner {

    private ProductService service;

    public DealHunterCli(ProductService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("=== DealHunter CLI ===");
            System.out.println("1. Load products");
            System.out.println("2. Create product");
            System.out.println("3. Search by name");
            System.out.println("4. Filter by category");
            System.out.println("5. Filter by price");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Load selected");
                    service.getProducts();
                    break;
                case 2:
                    System.out.println("Create selected");

                    while (true) {
                        System.out.print("Enter product id: ");
                        String id = scanner.nextLine();

                        System.out.print("Enter product name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter product category: ");
                        String category = scanner.nextLine();

                        System.out.print("Enter product price: ");
                        double price = scanner.nextDouble();
                        scanner.nextLine();

                        if (id.isBlank() || name.isBlank() || category.isBlank() || price < 0.0) {
                            System.out.print("Invalid Product information. Please corect. ");
                        } else {
                            Product prd = new Product(id, name, category, price);

                            service.createProduct(prd);
                            break;
                        }
                    }

                    break;
                case 3:
                    System.out.println("Search selected");
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();

                    List<Product> products = service.searchProducts(name);

                    if (products.isEmpty()) {
                        System.out.println("No products found");
                    } else {
                        for (Product product : products) {
                            System.out.println(product);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Filter by category selected");
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();

                    List<Product> productsCategory = service.filterByCategory(category);

                    if (productsCategory.isEmpty()) {
                        System.out.println("No products found");
                    } else {
                        for (Product product : productsCategory) {
                            System.out.println(product);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Filter by price selected");
                    System.out.print("Enter min value and max value: ");
                    double minPrice = scanner.nextDouble();
                    double maxPrice = scanner.nextDouble();
                    scanner.nextLine();
                    try {
                        List<Product> productsPrice = service.filterByPrice(minPrice, maxPrice);

                        if (productsPrice.isEmpty()) {
                            System.out.println("No products found");
                        } else {
                            for (Product product : productsPrice) {
                                System.out.println(product.toString());
                            }
                        }

                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }

                    break;
                case 0:
                    System.out.println("Exit selected");
                    service.getProducts();
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}