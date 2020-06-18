package it.Trilogia.thefridgemobile.controller;

import android.util.Log;

import it.Trilogia.thefridgemobile.db.init.DatabaseHelper;
import it.Trilogia.thefridgemobile.implementation.instance.Instance;
import it.Trilogia.thefridgemobile.model.entity.Fridge;
import it.Trilogia.thefridgemobile.model.entity.User;

public class LoginController {

    public boolean isValidUser(String username, String password){
        try {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            DatabaseHelper databaseHelper = DatabaseHelper.getDatabaseInstance();
            if( databaseHelper.checkValidUser(user) ){
                this.initUserInstance(user);
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private void initUserInstance(User user){
        //take fridge instance from db
        Fridge fridge = DatabaseHelper.getDatabaseInstance().takeFridgeOfUser(user);
        DatabaseHelper databaseHelper = DatabaseHelper.getDatabaseInstance();
        databaseHelper.getEmailUser(user);
        //print the printable
        Log.i("login_fridge", fridge.toString());
        //assign fridge to user
        user.setFridge(fridge);
        //user.setEmail(email);
        //populate Instance class with current user
        Instance.getSingletonInstance().setCurrentUser(user);
    }

}
