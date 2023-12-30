/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.one.stop.shop.entities;

import java.sql.*;

/**
 *
 * @author Deepa
 */
public class Login {
    private String uEmail;
    private String uPass;
    private Timestamp uLogTime;

    public Login(String uEmail, String uPass, Timestamp uLogTime) {
        this.uEmail = uEmail;
        this.uPass = uPass;
        this.uLogTime = uLogTime;
    }
    
    public Login(){
        
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuPass() {
        return uPass;
    }

    public void setuPass(String uPass) {
        this.uPass = uPass;
    }

    public Timestamp getuLogTime() {
        return uLogTime;
    }

    public void setuLogTime(Timestamp uLogTime) {
        this.uLogTime = uLogTime;
    }

    @Override
    public String toString() {
        return "Login{" + "uEmail=" + uEmail + ", uPass=" + uPass + ", uLogTime=" + uLogTime + '}';
    }
    
    
}
