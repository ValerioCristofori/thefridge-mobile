package it.valeriocristofori.thefridgemobile.model.entity;

import java.util.ArrayList;

public class Fridge {
    private ArrayList<Food> listFood;
    private String name;

    public ArrayList<Food> getListFood() {
        return listFood;
    }

    public void setListFood(ArrayList<Food> listFood) {
        this.listFood = listFood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}