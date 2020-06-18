package it.Trilogia.thefridgemobile.controller;

import java.util.ArrayList;
import java.util.regex.Pattern;

import it.Trilogia.thefridgemobile.db.init.DatabaseHelper;
import it.Trilogia.thefridgemobile.implementation.instance.Instance;
import it.Trilogia.thefridgemobile.model.entity.Food;
import it.Trilogia.thefridgemobile.model.entity.Fridge;
import it.Trilogia.thefridgemobile.model.utility.ListAllFood;

public class AddFoodController {


    public void insertFood(String foodName, String expirationDate){
        Food food = new Food();
        food.setName(foodName);
        food.setExpirationDate(expirationDate);

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

    public ArrayList<Food> takeContentWithSubstring(String input) {
        ArrayList<Food> trueList = new ArrayList<>();
        String[] foodList = ListAllFood.getAllFood();
        //for all the name
        //i want all that contains 'input'
        for( String foodName : foodList ){
            if( Pattern.compile(Pattern.quote(input), Pattern.CASE_INSENSITIVE).matcher(foodName).find() ){
                Food food = new Food();
                food.setName(foodName);
                trueList.add(food);
            }
        }
        return trueList;
    }

}
