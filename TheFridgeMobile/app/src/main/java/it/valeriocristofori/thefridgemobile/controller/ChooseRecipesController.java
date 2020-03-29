package it.valeriocristofori.thefridgemobile.controller;

import java.util.ArrayList;
import java.util.Random;

import it.valeriocristofori.thefridgemobile.api.SpoonacularAPI;
import it.valeriocristofori.thefridgemobile.implementation.instance.Instance;
import it.valeriocristofori.thefridgemobile.model.entity.Food;
import it.valeriocristofori.thefridgemobile.model.entity.Recipe;

public class ChooseRecipesController {

    private static final int NUM_INGREDIENTS = 3;

    public ArrayList<Recipe> takeRecipesList(int numRecipes) {
        //take possible ingredients
        ArrayList<Food> content = Instance.getSingletonInstance()
                .getCurrentUser()
                .getFridge()
                .getListFood();
        ArrayList<String> ingredients = this.export_ingredients(content);
        ArrayList<Recipe> arrayRecipes = new ArrayList<>(numRecipes);
        //for all recipes
        for(int i=0; i<numRecipes; i++){
            //create random recipes and add
            //to the array of recipes

            //take NUM_INGREDIENTS random ingredient in the list of ingredients
            ArrayList<String> threeIngredients = this.takeThreeIngredients(ingredients);

            //search for recipe
            arrayRecipes.add( this.search(threeIngredients) );
        }

        return arrayRecipes;
    }

    private Recipe search(ArrayList<String> threeIngredients) {
        SpoonacularAPI api = new SpoonacularAPI();
        return api.searchRecipe(threeIngredients);
    }

    private ArrayList<String> takeThreeIngredients(ArrayList<String> ingredients) {
        ArrayList<String> threeIngredients = new ArrayList<>(NUM_INGREDIENTS);
        Random random = new Random();
        for( int j=0; j< NUM_INGREDIENTS; j++ ) {
            int index = random.nextInt(ingredients.size());
            String foodName = ingredients.get(index);
            if( !threeIngredients.contains( foodName ) ){
                threeIngredients.add(foodName);
            }
        }
        return threeIngredients;
    }

    private ArrayList<String> export_ingredients(ArrayList<Food> content) {
        ArrayList<String> ingredients = new ArrayList<>(content.size());
        for( Food food : content ){
            ingredients.add(food.getName());
        }
        return ingredients;
    }
}
