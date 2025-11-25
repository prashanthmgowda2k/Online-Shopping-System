package com.project.functionalrequirements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Product {
	
	Map<String, String> spec = new HashMap<>();
	List<Image> imgList = new ArrayList<Image>();
	
	    private Long id;
	    private String name;
	    private Image image;
	    private String description;
	    private double price;
	    private Category category;
	    private List<Image> images;
	    private Map<String, String> specs; 
	    private Availability availability;
	    
	    ProductCatalouge prodcat;
	    
	    public Product(ProductCatalouge prodcat,
                Map<String, String> specs,
                List<Image> images,
                Long id,
                String name,
                Image image,
                String description,
                double price,
                Category category,
                Availability availability) {

     this.prodcat = prodcat;
     this.specs = specs;
     this.images = images;
     this.id = id;
     this.name = name;
     this.image = image;
     this.description = description;
     this.price = price;
     this.category = category;
     this.availability = availability;

     // Add the created product into the catalog
     prodcat.productList.add(this);
 }
		
		public Map<String, String> getSpec() {
			return spec;
		}
		public void setSpec(Map<String, String> spec) {
			this.spec = spec;
		}
		public List<Image> getImgList() {
			return imgList;
		}
		public void setImgList(List<Image> imgList) {
			this.imgList = imgList;
		}
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
		public Image getImage() {
			return image;
		}
		public void setImage(Image image) {
			this.image = image;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public Category getCategory() {
			return category;
		}
		public void setCategory(Category category) {
			this.category = category;
		}
		public List<Image> getImages() {
			return images;
		}
		public void setImages(List<Image> images) {
			this.images = images;
		}
		public Map<String, String> getSpecs() {
			return specs;
		}
		public void setSpecs(Map<String, String> specs) {
			this.specs = specs;
		}
		public Availability getAvailability() {
			return availability;
		}
		public void setAvailability(Availability availability) {
			this.availability = availability;
		}
	    
	    
	    
	    
	}

	
	
	
	
	
	
	
	



