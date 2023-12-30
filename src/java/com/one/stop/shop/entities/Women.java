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
public class Women {
        private String pID;
        private int catID;
        private String pName;
        private String pDetails;
        private int price;
        private String pattern;
        private String fit;
        private String type;
        private String fabric;
        private String image;

        public Women(String pID, int catID, String pName, String pDetails, int price, String pattern, String fit, String type, String fabric, String image) {
            this.pID = pID;
            this.catID = catID;
            this.pName = pName;
            this.pDetails = pDetails;
            this.price = price;
            this.pattern = pattern;
            this.fit = fit;
            this.type = type;
            this.fabric = fabric;
            this.image = image;
        }

        public Women(){
            
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

        public String getPattern() {
            return pattern;
        }

        public void setPattern(String pattern) {
            this.pattern = pattern;
        }

        public String getFit() {
            return fit;
        }

        public void setFit(String fit) {
            this.fit = fit;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getFabric() {
            return fabric;
        }

        public void setFabric(String fabric) {
            this.fabric = fabric;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

    @Override
    public String toString() {
        return "Women{" + "pID=" + pID + ", catID=" + catID + ", pName=" + pName + ", pDetails=" + pDetails + ", price=" + price + ", pattern=" + pattern + ", fit=" + fit + ", type=" + type + ", fabric=" + fabric + ", image=" + image + '}';
    }
        
        
}
