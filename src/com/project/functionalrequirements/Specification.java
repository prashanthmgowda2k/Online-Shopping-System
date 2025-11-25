package com.project.functionalrequirements;


import java.util.List;
import java.util.Map;

public class Specification {

    // Fields
    private String brand;
    private String gender;
    private String category;
    private String subCategory;

    private String fabricType;
    private String fabricBlend;
    private int gsm;
    private String stretchability;

    private String primaryColor;
    private String secondaryColor;
    private String pattern;

    private List<String> availableSizes;
    private String fitType;
    private Map<String, Double> measurements;

    private String sleeveType;
    private String neckStyle;
    private String closureType;
    private String hemline;

    private String washingInstructions;
    private String ironingInstructions;

    private String countryOfOrigin;
    private String sustainabilityInfo;

    // No-arg constructor
    public Specification() {}

    // All-args constructor
    public Specification(String brand, String gender, String category, String subCategory,
                              String fabricType, String fabricBlend, int gsm, String stretchability,
                              String primaryColor, String secondaryColor, String pattern,
                              List<String> availableSizes, String fitType, Map<String, Double> measurements,
                              String sleeveType, String neckStyle, String closureType, String hemline,
                              String washingInstructions, String ironingInstructions,
                              String countryOfOrigin, String sustainabilityInfo) {

        this.brand = brand;
        this.gender = gender;
        this.category = category;
        this.subCategory = subCategory;

        this.fabricType = fabricType;
        this.fabricBlend = fabricBlend;
        this.gsm = gsm;
        this.stretchability = stretchability;

        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.pattern = pattern;

        this.availableSizes = availableSizes;
        this.fitType = fitType;
        this.measurements = measurements;

        this.sleeveType = sleeveType;
        this.neckStyle = neckStyle;
        this.closureType = closureType;
        this.hemline = hemline;

        this.washingInstructions = washingInstructions;
        this.ironingInstructions = ironingInstructions;

        this.countryOfOrigin = countryOfOrigin;
        this.sustainabilityInfo = sustainabilityInfo;
    }

    // Getters and Setters

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getSubCategory() { return subCategory; }
    public void setSubCategory(String subCategory) { this.subCategory = subCategory; }

    public String getFabricType() { return fabricType; }
    public void setFabricType(String fabricType) { this.fabricType = fabricType; }

    public String getFabricBlend() { return fabricBlend; }
    public void setFabricBlend(String fabricBlend) { this.fabricBlend = fabricBlend; }

    public int getGsm() { return gsm; }
    public void setGsm(int gsm) { this.gsm = gsm; }

    public String getStretchability() { return stretchability; }
    public void setStretchability(String stretchability) { this.stretchability = stretchability; }

    public String getPrimaryColor() { return primaryColor; }
    public void setPrimaryColor(String primaryColor) { this.primaryColor = primaryColor; }

    public String getSecondaryColor() { return secondaryColor; }
    public void setSecondaryColor(String secondaryColor) { this.secondaryColor = secondaryColor; }

    public String getPattern() { return pattern; }
    public void setPattern(String pattern) { this.pattern = pattern; }

    public List<String> getAvailableSizes() { return availableSizes; }
    public void setAvailableSizes(List<String> availableSizes) { this.availableSizes = availableSizes; }

    public String getFitType() { return fitType; }
    public void setFitType(String fitType) { this.fitType = fitType; }

    public Map<String, Double> getMeasurements() { return measurements; }
    public void setMeasurements(Map<String, Double> measurements) { this.measurements = measurements; }

    public String getSleeveType() { return sleeveType; }
    public void setSleeveType(String sleeveType) { this.sleeveType = sleeveType; }

    public String getNeckStyle() { return neckStyle; }
    public void setNeckStyle(String neckStyle) { this.neckStyle = neckStyle; }

    public String getClosureType() { return closureType; }
    public void setClosureType(String closureType) { this.closureType = closureType; }

    public String getHemline() { return hemline; }
    public void setHemline(String hemline) { this.hemline = hemline; }

    public String getWashingInstructions() { return washingInstructions; }
    public void setWashingInstructions(String washingInstructions) { this.washingInstructions = washingInstructions; }

    public String getIroningInstructions() { return ironingInstructions; }
    public void setIroningInstructions(String ironingInstructions) { this.ironingInstructions = ironingInstructions; }

    public String getCountryOfOrigin() { return countryOfOrigin; }
    public void setCountryOfOrigin(String countryOfOrigin) { this.countryOfOrigin = countryOfOrigin; }

    public String getSustainabilityInfo() { return sustainabilityInfo; }
    public void setSustainabilityInfo(String sustainabilityInfo) { this.sustainabilityInfo = sustainabilityInfo; }
}
