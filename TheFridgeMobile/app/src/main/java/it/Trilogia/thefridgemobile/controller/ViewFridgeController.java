package it.Trilogia.thefridgemobile.controller;

import java.util.ArrayList;
import java.util.regex.Pattern;

import it.Trilogia.thefridgemobile.model.db.DatabaseHelper;
import it.Trilogia.thefridgemobile.model.implementation.instance.Instance;
import it.Trilogia.thefridgemobile.model.entity.Food;
import it.Trilogia.thefridgemobile.model.entity.Fridge;

public class ViewFridgeController {

    public ArrayList<Food> takeContent(){
        Fridge fridge = Instance.getSingletonInstance().getCurrentUser().getFridge();
        return fridge.getListFood();
    }

    public ArrayList<Food> takeContentWithSubstring( String input ) {
        Fridge fridge = Instance.getSingletonInstance().getCurrentUser().getFridge();
        ArrayList<Food> foodList = fridge.getListFood();
        ArrayList<Food> trueList = new ArrayList<>();
        //for all the name
        //i want all that contains 'input'
        for( Food food : foodList ){
            if( Pattern.compile(Pattern.quote(input), Pattern.CASE_INSENSITIVE).matcher(food.getName()).find() ){
                trueList.add(food);
            }
        }
        return trueList;
    }

    public void deleteFood(Food food) {
        //update fridge instance
        Instance instance = Instance.getSingletonInstance();
        Fridge fridge = instance.getCurrentUser().getFridge();
        fridge.deleteFood(food);
        instance.updateFridge(fridge);

        //call query to db
        DatabaseHelper.getDatabaseInstance().deleteFood(fridge, food);
    }
}
