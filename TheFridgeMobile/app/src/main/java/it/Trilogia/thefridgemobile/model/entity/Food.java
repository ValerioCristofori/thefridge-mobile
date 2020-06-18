package it.Trilogia.thefridgemobile.model.entity;

import java.io.Serializable;
import it.Trilogia.thefridgemobile.model.utility.ListAllFood;

public class Food implements Serializable {
    private String name;
    private String expirationDate;
    private String category;

    public Food(){
        this.expirationDate = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.select_category();
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) { this.expirationDate = expirationDate; }

    public String getCategory() {
        return category;
    }

    private void select_category(){
        //category Fruit
        for( String string : ListAllFood.getCategoryFruit()){
            if( string.compareTo(this.name) == 0){
                this.category = "fruit";
                return;
            }
        }
        //category Vegetable
        for( String string : ListAllFood.getCategoryVegetable()){
            if( string.compareTo(this.name) == 0){
                this.category = "vegetable";
                return;
            }
        }
        //category Meat
        for( String string : ListAllFood.getCategoryMeatEgg()){
            if( string.compareTo(this.name) == 0){
                this.category = "meat";
                return;
            }
        }
        //category Cereals
        for( String string : ListAllFood.getCategoryFlourCereals()){
            if( string.compareTo(this.name) == 0){
                this.category = "cereal_flour";
                return;
            }
        }
        //category Dessert
        for( String string : ListAllFood.getCategoryDessert()){
            if( string.compareTo(this.name) == 0){
                this.category = "dessert";
                return;
            }
        }
        //category Fish
        for( String string : ListAllFood.getCategoryFish()){
            if( string.compareTo(this.name) == 0){
                this.category = "fish";
                return;
            }
        }
        //category Spices
        for( String string : ListAllFood.getCategorySpices()){
            if( string.compareTo(this.name) == 0){
                this.category = "spices";
                return;
            }
        }
        //category Oils
        for( String string : ListAllFood.getCategoryOils()){
            if( string.compareTo(this.name) == 0){
                this.category = "oils";
                return;
            }
        }
        //category Beverages
        for( String string : ListAllFood.getCategoryBeverages()){
            if( string.compareTo(this.name) == 0){
                this.category = "beverages";
                return;
            }
        }
        //category Pasta
        for( String string : ListAllFood.getCategoryPastaBreadRise()){
            if( string.compareTo(this.name) == 0){
                this.category = "pasta_bread";
                return;
            }
        }
        //category Dairy Product
        for( String string : ListAllFood.getCategoryDairyProduct()){
            if( string.compareTo(this.name) == 0){
                this.category = "dairy_product";
                return;
            }
        }
        //category Legumes
        for( String string : ListAllFood.getCategoryLegumes()){
            if( string.compareTo(this.name) == 0){
                this.category = "legumes";
                return;
            }
        }
        //category Mushrooms
        for( String string : ListAllFood.getCategoryMushrooms()){
            if( string.compareTo(this.name) == 0){
                this.category = "mushrooms";
                return;
            }
        }
        //category Sauces
        for( String string : ListAllFood.getCategorySauces()){
            if( string.compareTo(this.name) == 0){
                this.category = "sauces";
                return;
            }
        }
        //category Vegan
        for( String string : ListAllFood.getCategoryVegan()){
            if( string.compareTo(this.name) == 0){
                this.category = "vegan";
                return;
            }
        }

        this.category = "unknown";
    }
}
