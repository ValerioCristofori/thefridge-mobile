package it.Trilogia.thefridgemobile.controller;

import it.Trilogia.thefridgemobile.db.init.DatabaseHelper;
import it.Trilogia.thefridgemobile.implementation.instance.Instance;

public class DeleteAccountController {

    public void deleteAccount(){

        DatabaseHelper databaseHelper = DatabaseHelper.getDatabaseInstance();
        Instance instance = Instance.getSingletonInstance();

        databaseHelper.deleteUser(instance.getCurrentUser());
    }
}
