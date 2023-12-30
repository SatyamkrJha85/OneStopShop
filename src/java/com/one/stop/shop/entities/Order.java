/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.one.stop.shop.entities;

import java.sql.Timestamp;

/**
 *
 * @author SATYAM JHA
 */
public class Order {

    private int orderId;
    private String uId;
    private String pId;
    private String pName;
    private int price;
    private int quantity;
    private String fullName;
    private String address;
    private String status;
    private Timestamp orderDate;

    public Order() {
    }

    public Order(int orderId, String uId, String pId, String pName, int price, int quantity, String fullName, String address, String status, Timestamp orderDate) {
        this.orderId = orderId;
        this.uId = uId;
        this.pId = pId;
        this.pName = pName;
        this.price = price;
        this.quantity = quantity;
        this.fullName = fullName;
        this.address = address;
        this.status = status;
        this.orderDate = orderDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", uId=" + uId + ", pId=" + pId + ", pName=" + pName + ", price=" + price + ", quantity=" + quantity + ", fullName=" + fullName + ", address=" + address + ", status=" + status + ", orderDate=" + orderDate + '}';
    }

    
    
    
}