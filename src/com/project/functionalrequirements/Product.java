package com.project.functionalrequirements;

import java.util.ArrayList;
import java.util.List;

public class Product {

    private Long id;
    private String name;
    private Category category;
    private Specification specification;
    private Availability availability;
    private List<Image> images = new ArrayList<>();

    // ---------------------------
    // Constructor
    // ---------------------------
    public Product(Long id, String name, Category category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    // ---------------------------
    // Getters & Setters
    // ---------------------------
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Specification getSpecification() {
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public List<Image> getImages() {
        return images;
    }

    // ---------------------------
    // Utility methods
    // ---------------------------
    public void addImage(Image img) {
        if (img != null) {
            images.add(img);
        }
    }
}
