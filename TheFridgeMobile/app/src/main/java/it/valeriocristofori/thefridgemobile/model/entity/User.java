package it.valeriocristofori.thefridgemobile.model.entity;

import android.annotation.SuppressLint;

public class User {
    private String username;
    private String email;
    private String password;
    private Fridge fridge;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Fridge getFridge() {
        return fridge;
    }

    public void setFridge(Fridge fridge) {
        this.fridge = fridge;
    }

    @SuppressLint("DefaultLocale")
    @Override
    public String toString(){
        return String.format("User = username: %s , Email: %s, Id: %d", this.username, this.email, this.fridge.getId());
    }

}
