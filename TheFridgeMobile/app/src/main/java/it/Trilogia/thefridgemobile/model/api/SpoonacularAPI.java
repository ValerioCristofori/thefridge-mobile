package it.Trilogia.thefridgemobile.model.api;

import android.annotation.SuppressLint;
import android.util.Log;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import it.Trilogia.thefridgemobile.model.entity.Food;
import it.Trilogia.thefridgemobile.model.entity.Recipe;

public class SpoonacularAPI {

    private HttpResponse<JsonNode> request;
    private HttpResponse<JsonNode> requestLink;

    public Recipe searchRecipe(ArrayList<String> threeIngredients) throws JSONException {

        //format string for query
        StringBuilder bld = new StringBuilder();
        for( String string : threeIngredients ) {
            bld.append(string).append(",");
        }

        this.queryApi(bld.toString());

        JSONObject jo = this.request.getBody().getArray().getJSONObject(0);

        Log.e("req", jo.toString());

        JSONArray jaUsed = (JSONArray) jo.get("usedIngredients");
        JSONArray jaMissed = (JSONArray) jo.get("missedIngredients");



        ArrayList<Food> usedIngredients = new ArrayList<>(jaUsed.length());
        ArrayList<Food> missedIngredients = new ArrayList<>(jaMissed.length());
        // setting content

        for( int i = 0; i< jaUsed.length(); i++) {

            JSONObject joUsed = jaUsed.getJSONObject(i);
            //setting food entity with taken parameters
            Food food = new Food();
            food.setName( (String) joUsed.get("original") );
            usedIngredients.add( food );

        }

        for( int i = 0; i< jaMissed.length(); i++) {

            JSONObject joMissed = jaMissed.getJSONObject(i);
            //setting food entity with taken parameters
            Food food = new Food();
            food.setName( (String) joMissed.get("original") );
            missedIngredients.add( food );

        }

        String title = (String) request.getBody().getArray().getJSONObject(0).get("title");


        String recipeImage = (String) request.getBody().getArray().getJSONObject(0).get("image");

        //init of the found recipe
        Recipe recipe = new Recipe();
        //set title
        recipe.setTitle(title);
        //set link of image
        recipe.setImage(recipeImage);
        //set description of recipe

        //set ingredients
        recipe.setUsedIngredients(usedIngredients);
        recipe.setMissedIngredients(missedIngredients);

        //take recipe id
        Integer recipeId = (Integer) request.getBody().getArray().getJSONObject(0).get("id");
        //setting source recipe link through id
        recipe.setSrcLink( this.queryLink( recipeId ) );


        return recipe;
    }

    @SuppressLint("DefaultLocale")
    private String queryLink(Integer recipeId ) throws JSONException {
        try {
            this.requestLink = Unirest.get( String.format( "https://api.spoonacular.com/recipes/%d/information?includeNutrition=false", recipeId ) )
                    .header("accept", "application/json")
                    .queryString("apiKey", "17ec274ea20147df98d287e352ec51c2")
                    .asJson();
        } catch (UnirestException e) {

            e.printStackTrace();
        }
        return (String) requestLink.getBody().getArray().getJSONObject(0).get("sourceUrl");

    }

    private void queryApi(String query) {
        try {
            this.request = Unirest.get( String.format( "https://api.spoonacular.com/recipes/findByIngredients?number=1&ranking=1&ignorePantry=false&ingredients=%s", query ) )
                    .header("accept", "application/json")
                    .queryString("apiKey", "17ec274ea20147df98d287e352ec51c2")
                    .asJson();
        } catch (UnirestException e) {

            e.printStackTrace();
        }
    }


}
