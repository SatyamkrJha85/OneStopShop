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
public class Electronics {
        private String pID;
        private int catID;
        private String pName;
        private String pDetails;
        private int price;
        private String color;
        private String weight;
        private String warranty;
        private String countryOrigin;
        private String image;

        public Electronics(String pID, int catID, String pName, String pDetails, int price, String color, String weight, String warranty, String countryOrigin, String image) {
            this.pID = pID;
            this.catID = catID;
            this.pName = pName;
            this.pDetails = pDetails;
            this.price = price;
            this.color = color;
            this.weight = weight;
            this.warranty = warranty;
            this.countryOrigin = countryOrigin;
            this.image = image;
        }
        
        public Electronics(){
            
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

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getWarranty() {
            return warranty;
        }

        public void setWarranty(String warranty) {
            this.warranty = warranty;
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
        return "Electronics{" + "pID=" + pID + ", catID=" + catID + ", pName=" + pName + ", pDetails=" + pDetails + ", price=" + price + ", color=" + color + ", weight=" + weight + ", warranty=" + warranty + ", countryOrigin=" + countryOrigin + ", image=" + image + '}';
    }

        

}
