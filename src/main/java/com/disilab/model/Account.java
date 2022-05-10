package com.disilab.model;

import java.io.Serializable;

public class Account implements Serializable {
    private Role role;
    private String userName;
    private String displayName;
    private String email;
    private int phone;
    private String image;
    private String password;
    private String about;
    private String key;
    private boolean status;

    public Account() {
    }

    public Account(Role role, String userName, String displayName, String email, int phone, String image, String about, String key, boolean status) {
        this.role = role;
        this.userName = userName;
        this.displayName = displayName;
        this.email = email;
        this.phone = phone;
        this.image = image;
        this.about = about;
        this.key = key;
        this.status = status;
    }
    public Account(String userName, String displayName, String email, String password) {
        this.userName = userName;
        this.displayName = displayName;
        this.email = email;
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
