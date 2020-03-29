package it.valeriocristofori.thefridgemobile.api;

import java.util.ArrayList;

import it.valeriocristofori.thefridgemobile.model.entity.Recipe;

public class SpoonacularAPI {
/**
    private HttpResponse<JsonNode> request;

    public Recipe searchRecipe(ArrayList<String> threeIngredients) {

        //format string for query
        StringBuilder bld = new StringBuilder();
        for( String string : threeIngredients ) {
            bld.append( string + "," );
        }

        this.queryApi(bld.toString());

    }

    private void queryApi(String toString) {
        try {
            this.request = Unirest.get( String.format( "https://api.spoonacular.com/recipes/findByIngredients?number=1&ranking=1&ignorePantry=false&ingredients=%s", query ) )
                    .header("accept", "application/json")
                    .queryString("apiKey", "182a4ed3fcac422bb77989c8be661be3")
                    .asJson();
        } catch (UnirestException e) {

            e.printStackTrace();
        }
    }

 */
}
