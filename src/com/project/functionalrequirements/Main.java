package com.project.functionalrequirements;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

       
        ProductCatalogue catalogue = new ProductCatalogue();


        // ---------------------------------------
        // Create product 1: Blue T-shirt
        // ---------------------------------------
        Product p1 = new Product(1L, "Blue T-Shirt", Category.CLOTHING);

        Specification s1 = new Specification();
        s1.add("color", "Blue");
        s1.add("size", "M");
        s1.add("material", "Cotton");

        p1.setSpecification(s1);
        p1.setAvailability(new Availability(true, 20));
        p1.addImage(new Image("blue_tshirt_front.jpg"));
        p1.addImage(new Image("blue_tshirt_back.jpg"));


        // ---------------------------------------
        // Create product 2: Running Shoes
        // ---------------------------------------
        Product p2 = new Product(2L, "Running Shoes", Category.FOOTWEAR);

        Specification s2 = new Specification();
        s2.add("color", "Black");
        s2.add("size", "9");
        s2.add("material", "Mesh");

        p2.setSpecification(s2);
        p2.setAvailability(new Availability(true, 12));
        p2.addImage(new Image("shoes_front.jpg"));


        // ---------------------------------------
        // Create product 3: Women's Handbag
        // ---------------------------------------
        Product p3 = new Product(3L, "Women's Handbag", Category.ACCESSORIES);

        Specification s3 = new Specification();
        s3.add("color", "Red");
        s3.add("material", "Leather");

        p3.setSpecification(s3);
        p3.setAvailability(new Availability(false, 0)); // Out of stock


        // ---------------------------------------
        // Add products to catalogue
        // ---------------------------------------
        catalogue.addProduct(p1);
        catalogue.addProduct(p2);
        catalogue.addProduct(p3);


        // ---------------------------------------
        // TEST 1: Show all products
        // ---------------------------------------
        System.out.println("\n--- ALL PRODUCTS ---");
        printList(catalogue.getAllProducts());


        // ---------------------------------------
        // TEST 2: Search by name
        // ---------------------------------------
        System.out.println("\n--- SEARCH: name contains 'shoe' ---");
        printList(catalogue.searchByName("T-shirt"));


        // ---------------------------------------
        // TEST 3: Search by category
        // ---------------------------------------
        System.out.println("\n--- SEARCH: FOOTWEAR category ---");
        printList(catalogue.searchByCategory(Category.FOOTWEAR));


        // ---------------------------------------
        // TEST 4: Search by specification (color=Blue)
        // ---------------------------------------
        System.out.println("\n--- SEARCH: color = Blue ---");
        printList(catalogue.searchBySpecification("color", "Blue"));


        // ---------------------------------------
        // TEST 5: Search by spec key only
        // ---------------------------------------
//        System.out.println("\n--- SEARCH: spec contains key 'material' ---");
//        printList(catalogue.searchBySpecKey("material"));


        // ---------------------------------------
        // TEST 6: Get only in-stock products
        // ---------------------------------------
        System.out.println("\n--- IN STOCK PRODUCTS ---");
        printList(catalogue.getInStockProducts());


        // ---------------------------------------
        // TEST 7: Find by ID
        // ---------------------------------------
        System.out.println("\n--- FIND BY ID: 2 ---");
        Product result = catalogue.getProductById(2L);
        System.out.println(result != null ? result.getName() : "Not found");
    }

    // Helper method for printing product lists
    private static void printList(List<Product> list) {
        if (list == null || list.isEmpty()) {
            System.out.println("No products found.");
            return;
        }

        for (Product p : list) {
            System.out.println("ID: " + p.getId() +
                               ", Name: " + p.getName() +
                               ", Category: " + p.getCategory());
        }
    }
}
