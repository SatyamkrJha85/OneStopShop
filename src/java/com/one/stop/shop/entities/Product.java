/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.one.stop.shop.entities;

/**
 *
 * @author SATYAM JHA
 */
public class Product {

    private String id;
    private int catID; // Assuming category ID is an integer
    private String name;
    private String details;
    private int price;
    private String fOne;
    private String fTwo;
    private String fThree;
    private String fFour;
    private String image;

    public Product(String id, int catID, String name, String details, int price, String fOne, String fTwo, String fThree, String fFour, String image) {
        this.id = id;
        this.catID = catID;
        this.name = name;
        this.details = details;
        this.price = price;
        this.fOne = fOne;
        this.fTwo = fTwo;
        this.fThree = fThree;
        this.fFour = fFour;
        this.image = image;
    }

    public Product() {
    }

    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCatID() {
        return catID;
    }

    public void setCatID(int catID) {
        this.catID = catID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getfOne() {
        return fOne;
    }

    public void setfOne(String fOne) {
        this.fOne = fOne;
    }

    public String getfTwo() {
        return fTwo;
    }

    public void setfTwo(String fTwo) {
        this.fTwo = fTwo;
    }

    public String getfThree() {
        return fThree;
    }

    public void setfThree(String fThree) {
        this.fThree = fThree;
    }

    public String getfFour() {
        return fFour;
    }

    public void setfFour(String fFour) {
        this.fFour = fFour;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", catID=" + catID + ", name=" + name + ", details=" + details + ", price=" + price + ", fOne=" + fOne + ", fTwo=" + fTwo + ", fThree=" + fThree + ", fFour=" + fFour + ", image=" + image + '}';
    }

    

}