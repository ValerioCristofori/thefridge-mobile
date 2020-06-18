package it.Trilogia.thefridgemobile.controller;

import android.util.Log;

import java.util.Random;

import it.Trilogia.thefridgemobile.db.init.DatabaseHelper;
import it.Trilogia.thefridgemobile.implementation.exception.IdUsedException;
import it.Trilogia.thefridgemobile.implementation.instance.Instance;
import it.Trilogia.thefridgemobile.model.entity.Fridge;
import it.Trilogia.thefridgemobile.model.entity.User;

public class RegistrationController {

    public boolean isValidUsername( String username ){
        try {
            User user = new User();
            user.setUsername(username);

            DatabaseHelper databaseHelper = DatabaseHelper.getDatabaseInstance();
            return databaseHelper.checkValidUsername(user);

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public void registration( String username, String password, String email) {
        //build user entity
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);

        //create user's fridge
        Fridge fridge = new Fridge();
        //init start fridge
        this.setDefaultFridge(fridge);
        //set user's default fridge
        user.setFridge(fridge);

        //call query to insert user in db
        DatabaseHelper databaseHelper = DatabaseHelper.getDatabaseInstance();
        databaseHelper.insertUser(user);

        //set current instance in the Singleton class
        Instance instance = Instance.getSingletonInstance();
        instance.setCurrentUser(user);
        Log.i("registration", user.toString());
    }

    private void setDefaultFridge( Fridge fridge ) {
        /*
          set default random id from 1 to 10'000 according to the db
         */

        try {
            fridge.setName("fridge");
            fridge.setListFood(null);

            Random r = new Random();
            int rand = r.nextInt(10000);

            this.setFridgeThroughId(fridge, rand);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private void setFridgeThroughId( Fridge fridge, int id ) {
        DatabaseHelper databaseHelper = DatabaseHelper.getDatabaseInstance();
        fridge.setId( id );

        if( !databaseHelper.checkFridgeId(fridge) ) {
            try {
                throw new IdUsedException(id);
            } catch (IdUsedException e) {
                setFridgeThroughId( fridge, e.getNewId());
            }
        }
    }

}
