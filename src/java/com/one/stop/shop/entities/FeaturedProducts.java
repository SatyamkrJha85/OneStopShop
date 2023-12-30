/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.one.stop.shop.entities;

/**
 *
 * @author Deepa
 */
public class FeaturedProducts {
    private String pID;
    private int catID;
    private String pName;
    private String pDetails;
    private int price;
    private String color;
    private String brand;
    private String manufacturer;
    private String countryOrigin;
    private String image;



    public FeaturedProducts(String pID, int catID, String pName, String pDetails, int price, String color, String brand, String manufacturer, String countryOrigin, String image) {
        this.pID = pID;
        this.catID = catID;
        this.pName = pName;
        this.pDetails = pDetails;
        this.price = price;
        this.color = color;
        this.brand = brand;
        this.manufacturer = manufacturer;
        this.countryOrigin = countryOrigin;
        this.image = image;
    }
    public FeaturedProducts() {
        
    }
    public String getpID() {
        return pID;
    }

    public void setpID(String pID) {
        this.pID = pID;
    }

    public int getCatID() {
        return catID;
    }

    public void setCatID(int catID) {
        this.catID = catID;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpDetails() {
        return pDetails;
    }

    public void setpDetails(String pDetails) {
        this.pDetails = pDetails;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCountryOrigin() {
        return countryOrigin;
    }

    public void setCountryOrigin(String countryOrigin) {
        this.countryOrigin = countryOrigin;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "LatestProducts{" + "pID=" + pID + ", catID=" + catID + ", pName=" + pName + ", pDetails=" + pDetails + ", price=" + price + ", color=" + color + ", brand=" + brand + ", manufacturer=" + manufacturer + ", countryOrigin=" + countryOrigin + ", image=" + image + '}';
    }
}
