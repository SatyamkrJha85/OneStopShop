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
public class Feedback {

    private String email;
    private String subject;

    public Feedback(String email, String subject) {
        this.email = email;
        this.subject = subject;
    }

    public Feedback() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Feedback{" + "email=" + email + ", subject=" + subject + '}';
    }
    
    
}
