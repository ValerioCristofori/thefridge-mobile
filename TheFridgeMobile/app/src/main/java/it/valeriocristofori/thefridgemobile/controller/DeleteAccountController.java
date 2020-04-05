package it.valeriocristofori.thefridgemobile.controller;

import it.valeriocristofori.thefridgemobile.db.init.DatabaseHelper;
import it.valeriocristofori.thefridgemobile.implementation.instance.Instance;

public class DeleteAccountController {

    public void deleteAccount(){

        DatabaseHelper databaseHelper = DatabaseHelper.getDatabaseInstance();
        Instance instance = Instance.getSingletonInstance();

        databaseHelper.deleteUser(instance.getCurrentUser());
    }
}
