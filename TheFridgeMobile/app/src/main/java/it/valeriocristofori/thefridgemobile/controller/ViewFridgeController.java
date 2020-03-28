package it.valeriocristofori.thefridgemobile.controller;

import java.util.ArrayList;

import it.valeriocristofori.thefridgemobile.implementation.instance.Instance;
import it.valeriocristofori.thefridgemobile.model.entity.Food;
import it.valeriocristofori.thefridgemobile.model.entity.Fridge;

public class ViewFridgeController {

    public ArrayList<Food> takeContent(){
        Fridge fridge = Instance.getSingletonInstance().getCurrentUser().getFridge();
        return fridge.getListFood();
    }

}
