package it.Trilogia.thefridgemobile.model.implementation.instance;

import it.Trilogia.thefridgemobile.R;
import it.Trilogia.thefridgemobile.model.entity.Fridge;
import it.Trilogia.thefridgemobile.model.entity.User;

public class Instance {

    private static Instance instance = null;
    private User currentUser;
    private int[] images = {R.drawable.category_fruit,R.drawable.category_vegetable,R.drawable.category_meat,
            R.drawable.category_fish,R.drawable.category_cereal,R.drawable.category_bread,R.drawable.category_legume,
            R.drawable.category_mushroom,R.drawable.category_dairy_product,R.drawable.category_dessert,R.drawable.category_spices,
            R.drawable.category_sauces,R.drawable.category_beverage,R.drawable.category_vegan,R.drawable.category_oil};

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

    public int[] getImages() {
        return images;
    }
}
