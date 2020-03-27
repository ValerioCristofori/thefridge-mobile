package it.valeriocristofori.thefridgemobile.controller;

import it.valeriocristofori.thefridgemobile.db.init.DatabaseHelper;
import it.valeriocristofori.thefridgemobile.model.entity.User;

public class LoginController {

    public boolean isValidUser(String username, String password){
        try {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            DatabaseHelper databaseHelper = DatabaseHelper.getDatabaseInstance();
            return databaseHelper.checkValidUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
