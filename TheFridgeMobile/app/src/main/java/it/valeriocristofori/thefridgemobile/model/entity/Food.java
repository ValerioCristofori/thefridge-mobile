package it.valeriocristofori.thefridgemobile.model.entity;

public class Food {
    private String name;
    private int quantity;
    private String expirationDate;
    private String category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.select_category();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    private void select_category(){
        //category Fruit
        if( name.compareTo()){
            this.category = "Fruit";
        }

        //category Vegetable
        if( name.compareTo()){
            this.category = "Vegetable";
        }

        //category Meal
        if( name.compareTo()){
            this.category = "Meal";
        }

        //category PastaBread
        if( name .compareTo()){
            this.category = "PastaBread";
        }

        //category Dessert
        if( name.compareTo()){
            this.category = "Dessert";
        }

        //category Fish
        if( name .compareTo()){
            this.category = "Fish";
        }

        //category Spices
        if( name.compareTo()){
            this.category = "Spices";
        }

    }
}
