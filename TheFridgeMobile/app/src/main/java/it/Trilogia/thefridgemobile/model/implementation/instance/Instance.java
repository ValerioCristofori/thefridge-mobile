package it.Trilogia.thefridgemobile.model.implementation.instance;

import it.Trilogia.thefridgemobile.R;
import it.Trilogia.thefridgemobile.model.entity.Fridge;
import it.Trilogia.thefridgemobile.model.entity.User;

public class Instance {

    private static Instance instance = null;
    private User currentUser;
    private int[] images = {R.drawable.ic_category_fruit,R.drawable.ic_category_vegetable,R.drawable.ic_category_meat,
            R.drawable.ic_category_fish,R.drawable.ic_category_cereal,R.drawable.ic_category_bread,R.drawable.ic_category_legume,
            R.drawable.ic_category_mushroom,R.drawable.ic_category_dairy_product,R.drawable.ic_category_dessert,R.drawable.ic_category_spices,
            R.drawable.ic_category_sauces,R.drawable.ic_category_beverage,R.drawable.ic_category_vegan,R.drawable.ic_category_oil};

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
