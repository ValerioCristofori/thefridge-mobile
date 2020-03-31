package it.valeriocristofori.thefridgemobile.model.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Recipe implements Serializable {
    private ArrayList<Food> ingredients;
    private String image;
    private String title;
    private String description;
    private String srcLink;

    public ArrayList<Food> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Food> ingredients) {
        this.ingredients = ingredients;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSrcLink() {
        return srcLink;
    }

    public void setSrcLink(String srcLink) {
        this.srcLink = srcLink;
    }
}
