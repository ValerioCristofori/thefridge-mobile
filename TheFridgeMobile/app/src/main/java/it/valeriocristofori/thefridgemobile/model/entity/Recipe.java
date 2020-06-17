package it.valeriocristofori.thefridgemobile.model.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Recipe implements Serializable {
    private ArrayList<Food> usedIngredients;
    private ArrayList<Food> missedIngredients;
    private String image;
    private String title;
    private String srcLink;

    public ArrayList<Food> getUsedIngredients() {
        return usedIngredients;
    }

    public void setUsedIngredients(ArrayList<Food> usedIngredients) {
        this.usedIngredients = usedIngredients;
    }

    public ArrayList<Food> getMissedIngredients() {
        return missedIngredients;
    }

    public void setMissedIngredients(ArrayList<Food> missedIngredients) {
        this.missedIngredients = missedIngredients;
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

    public String getSrcLink() {
        return srcLink;
    }

    public void setSrcLink(String srcLink) {
        this.srcLink = srcLink;
    }
}
