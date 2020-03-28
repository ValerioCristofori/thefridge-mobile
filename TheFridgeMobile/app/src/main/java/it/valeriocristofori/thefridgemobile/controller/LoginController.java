package it.valeriocristofori.thefridgemobile.controller;

import android.util.Log;

import it.valeriocristofori.thefridgemobile.db.init.DatabaseHelper;
import it.valeriocristofori.thefridgemobile.implementation.instance.Instance;
import it.valeriocristofori.thefridgemobile.model.entity.Fridge;
import it.valeriocristofori.thefridgemobile.model.entity.User;

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
        //print the printable
        Log.i("login_fridge", fridge.toString());
        //assign fridge to user
        user.setFridge(fridge);

        //populate Instance class with current user
        Instance.getSingletonInstance().setCurrentUser(user);
    }

}
