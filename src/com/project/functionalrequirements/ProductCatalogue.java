package com.project.functionalrequirements;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalogue {

    private List<Product> productList = new ArrayList<>();
    
    

    public void addProduct(Product product) {
    	if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        productList.add(product);
    }
    
    public boolean removeProductById(Long id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId().equals(id)) {
                productList.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public List<Product> getAllProducts() {
        return new ArrayList<>(productList); // return copy
    }

    
    public Product getProductById(Long id) {
        for (Product p : productList) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }
    
    
    public List<Product> searchByName(String keyword) {
        List<Product> result = new ArrayList<>();
        if (keyword == null) return result;

        String key = keyword.toLowerCase();

        for (Product p : productList) {
            if (p.getName().toLowerCase().contains(key)) {
                result.add(p);
            }
        }
        return result;
    }

	
    public List<Product> searchByCategory(Category category) {
        List<Product> result = new ArrayList<>();

        for (Product p : productList) {
            if (p.getCategory() == category) {
                result.add(p);
            }
        }
        return result;
    }
    
    public List<Product> searchBySpecification(String key, String value) {
        List<Product> result = new ArrayList<>();
        if (key == null || value == null) return result;

        for (Product p : productList) {
            if (p.getSpecification() != null) {
                String specValue = p.getSpecification().get(key);
                if (specValue != null && specValue.equalsIgnoreCase(value)) {
                    result.add(p);
                }
            }
        }
        return result;
    }
	
    public List<Product> getInStockProducts() {
        List<Product> result = new ArrayList<>();

        for (Product p : productList) {
            if (p.getAvailability() != null &&
                p.getAvailability().isInStock()) {
                result.add(p);
            }
        }
        return result;
    }
    
    
	public void filterByPrice() {
		
	}
	
	public void displayAllProducts() {
		
	}
	
	

}
