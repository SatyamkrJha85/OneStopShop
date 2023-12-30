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
public class Users {

    private String uName;
    private String uEmail;
    private String uPass;
    private String uAddress;
    private String uGender;
    private String uMobile;
    private Timestamp uRegTime;
    private String uProfile;
    private String nickname;

//    Constructors
    public Users(String uName, String uEmail, String uPass, String uAddress, String uGender, String uMobile, Timestamp uRegTime, String uProfile, String nickname) {
        this.uName = uName;
        this.uEmail = uEmail;
        this.uPass = uPass;
        this.uAddress = uAddress;
        this.uGender = uGender;
        this.uMobile = uMobile;
        this.uRegTime = uRegTime;
        this.nickname = nickname;
    }

    public Users() {

    }

    public Users(String uName, String uEmail, String uPass, String nickname) {
        this.uName = uName;
        this.uEmail = uEmail;
        this.uPass = uPass;
        this.nickname = nickname;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
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

    public String getuAddress() {
        return uAddress;
    }

    public void setuAddress(String uAddress) {
        this.uAddress = uAddress;
    }

    public String getuGender() {
        return uGender;
    }

    public void setuGender(String uGender) {
        this.uGender = uGender;
    }

    public String getuMobile() {
        return uMobile;
    }

    public void setuMobile(String uMobile) {
        this.uMobile = uMobile;
    }

    public Timestamp getuRegTime() {
        return uRegTime;
    }

    public void setuRegTime(Timestamp uRegTime) {
        this.uRegTime = uRegTime;
    }

    public String getuProfile() {
        return uProfile;
    }

    public void setuProfile(String uProfile) {
        this.uProfile = uProfile;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Users{" + "uName=" + uName + ", uEmail=" + uEmail + ", uPass=" + uPass + ", uAddress=" + uAddress + ", uGender=" + uGender + ", uMobile=" + uMobile + ", uRegTime=" + uRegTime + ", uProfile=" + uProfile + ", nickname=" + nickname + '}';
    }

    

}
