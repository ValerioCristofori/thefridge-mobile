package it.valeriocristofori.thefridgemobile.controller;

import android.text.Editable;

import java.util.ArrayList;
import java.util.regex.Pattern;

import it.valeriocristofori.thefridgemobile.implementation.instance.Instance;
import it.valeriocristofori.thefridgemobile.model.entity.Food;
import it.valeriocristofori.thefridgemobile.model.entity.Fridge;

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
}
