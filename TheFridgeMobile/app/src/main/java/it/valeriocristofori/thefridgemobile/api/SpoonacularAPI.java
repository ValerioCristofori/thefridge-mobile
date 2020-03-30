package it.valeriocristofori.thefridgemobile.api;

import android.util.Log;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import it.valeriocristofori.thefridgemobile.model.entity.Recipe;

public class SpoonacularAPI {

    private HttpResponse<JsonNode> request;

    public Recipe searchRecipe(ArrayList<String> threeIngredients) throws JSONException {

        //format string for query
        StringBuilder bld = new StringBuilder();
        for( String string : threeIngredients ) {
            bld.append( string + "," );
        }

        this.queryApi(bld.toString());

        JSONObject jo = this.request.getBody().getArray().getJSONObject(0);

        Log.e("req", jo.toString());

        JSONArray jaUsed = (JSONArray) jo.get("usedIngredients");
        JSONArray jaMissed = (JSONArray) jo.get("missedIngredients");



        ArrayList<String> content = new ArrayList<>();
        // setting content

        for( int i = 0; i< jaUsed.length(); i++) {

            JSONObject joUsed = jaUsed.getJSONObject(i);
            content.add( (String) joUsed.get("original"));

        }

        for( int i = 0; i< jaMissed.length(); i++) {

            JSONObject joMissed = jaMissed.getJSONObject(i);
            content.add( (String) joMissed.get("original"));

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

        return recipe;
    }

    private void queryApi(String query) {
        try {
            this.request = Unirest.get( String.format( "https://api.spoonacular.com/recipes/findByIngredients?number=1&ranking=1&ignorePantry=false&ingredients=%s", query ) )
                    .header("accept", "application/json")
                    .queryString("apiKey", "6aec8f6e45084389b9517809a647ba83")
                    .asJson();
        } catch (UnirestException e) {

            e.printStackTrace();
        }
    }


}
