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
public class Complaint {
    
        private String fName;
        private String lName;
        private String email;
        private String phone;
        private String reason;
        private String subject;

    public Complaint(String fName, String lName, String email, String phone, String reason, String subject) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phone = phone;
        this.reason = reason;
        this.subject = subject;
    }

    public Complaint() {
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Complaint{" + "fName=" + fName + ", lName=" + lName + ", email=" + email + ", phone=" + phone + ", reason=" + reason + ", subject=" + subject + '}';
    }
        
        
    
}