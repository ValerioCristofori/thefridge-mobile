package it.valeriocristofori.thefridgemobile.model.entity;

import java.util.ArrayList;

public class Fridge {
    private ArrayList<Food> listFood;
    private String name;
    private int id;

    public Fridge(){
        this.name = "fridge";
        this.listFood = new ArrayList<>(30);
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addFood(Food food) {
        //control if there is already the food
        //..........

        this.listFood.add(food);
    }

    @Override
    public String toString(){
        StringBuilder printable_list = new StringBuilder();
        printable_list.append("\n");
        for( Food food : this.listFood){
            printable_list.append(food.getName());
            printable_list.append("\n");
        }
        return String.format("Fridge = id: %s \nlist of food: %s", this.id, printable_list);
    }
}
