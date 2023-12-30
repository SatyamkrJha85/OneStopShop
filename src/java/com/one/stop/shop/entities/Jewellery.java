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
public class Jewellery {
        private String pID;
        private int catID;
        private String pName;
        private String pDetails;
        private int price;
        private String claspType;
        private String materialType;
        private String metalType;
        private String gemType;
        private String image;

        public Jewellery(String pID, int catID, String pName, String pDetails, int price, String claspType, String materialType, String metalType, String gemType, String image) {
            this.pID = pID;
            this.catID = catID;
            this.pName = pName;
            this.pDetails = pDetails;
            this.price = price;
            this.claspType = claspType;
            this.materialType = materialType;
            this.metalType = metalType;
            this.gemType = gemType;
            this.image = image;
        }
        
        public Jewellery(){
            
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

        public String getClaspType() {
            return claspType;
        }

        public void setClaspType(String claspType) {
            this.claspType = claspType;
        }

        public String getMaterialType() {
            return materialType;
        }

        public void setMaterialType(String materialType) {
            this.materialType = materialType;
        }

        public String getMetalType() {
            return metalType;
        }

        public void setMetalType(String metalType) {
            this.metalType = metalType;
        }

        public String getGemType() {
            return gemType;
        }

        public void setGemType(String gemType) {
            this.gemType = gemType;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

    @Override
    public String toString() {
        return "Jewellery{" + "pID=" + pID + ", catID=" + catID + ", pName=" + pName + ", pDetails=" + pDetails + ", price=" + price + ", claspType=" + claspType + ", materialType=" + materialType + ", metalType=" + metalType + ", gemType=" + gemType + ", image=" + image + '}';
    }
        
        
        
        
}
