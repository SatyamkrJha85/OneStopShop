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
public class Footwear {
        private String pID;
        private int catID;
        private String pName;
        private String pDetails;
        private int price;
        private String outerMaterial;
        private String pFor;
        private String type;
        private String occasion;
        private String image;

        public Footwear(String pID, int catID, String pName, String pDetails, int price, String outerMaterial, String pFor, String type, String occasion, String image) {
            this.pID = pID;
            this.catID = catID;
            this.pName = pName;
            this.pDetails = pDetails;
            this.price = price;
            this.outerMaterial = outerMaterial;
            this.pFor = pFor;
            this.type = type;
            this.occasion = occasion;
            this.image = image;
        }
        
        public Footwear(){
            
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

        public String getOuterMaterial() {
            return outerMaterial;
        }

        public void setOuterMaterial(String outerMaterial) {
            this.outerMaterial = outerMaterial;
        }

        public String getpFor() {
            return pFor;
        }

        public void setpFor(String pFor) {
            this.pFor = pFor;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getOccasion() {
            return occasion;
        }

        public void setOccasion(String occasion) {
            this.occasion = occasion;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

    @Override
    public String toString() {
        return "Footwear{" + "pID=" + pID + ", catID=" + catID + ", pName=" + pName + ", pDetails=" + pDetails + ", price=" + price + ", outerMaterial=" + outerMaterial + ", pFor=" + pFor + ", type=" + type + ", occasion=" + occasion + ", image=" + image + '}';
    }
        
        

}
