package it.valeriocristofori.thefridgemobile.controller;

import it.valeriocristofori.thefridgemobile.db.init.DatabaseHelper;
import it.valeriocristofori.thefridgemobile.implementation.instance.Instance;
import it.valeriocristofori.thefridgemobile.model.entity.Food;
import it.valeriocristofori.thefridgemobile.model.entity.Fridge;

public class AddFoodController {

    public void insertFood( String foodName ){
        Food food = new Food();
        food.setName(foodName);

        //take fridge instance of the current user
        //there is a singleton instance
        Instance instance = Instance.getSingletonInstance();
        Fridge fridge = instance.getCurrentUser().getFridge();

        //insert food in fridge instance on Instance
        fridge.addFood(food);
        instance.updateFridge(fridge);

        //update fridge in db with query
        DatabaseHelper.getDatabaseInstance().insertFood(fridge, food);

    }

}
