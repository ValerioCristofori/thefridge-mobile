package it.valeriocristofori.thefridgemobile.implementation.instance;

import it.valeriocristofori.thefridgemobile.model.entity.Fridge;
import it.valeriocristofori.thefridgemobile.model.entity.User;

public class Instance {

    private static Instance instance = null;
    private User currentUser;

    private Instance(){

    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public static Instance getSingletonInstance(){
        if( instance == null ){
            instance = new Instance();
        }
        return instance;
    }


    public void updateFridge(Fridge fridge) {
        this.currentUser.setFridge(fridge);
    }
}
