
package com.one.stop.shop.entities;

public class Cart {

    private String userId;
    private String productId;
    private String productName;
    private int Quantity;
    private int Price;

    public Cart() {
    }

    public Cart(String userId, String productId, String productName, int Quantity, int Price) {
        this.userId = userId;
        this.productId = productId;
        this.productName = productName;
        this.Quantity = Quantity;
        this.Price = Price;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    @Override
    public String toString() {
        return "Cart{" + "userId=" + userId + ", productId=" + productId + ", productName=" + productName + ", Quantity=" + Quantity + ", Price=" + Price + '}';
    }

    

    
}
