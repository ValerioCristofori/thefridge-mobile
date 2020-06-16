package it.valeriocristofori.thefridgemobile.activity.recipe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import it.valeriocristofori.thefridgemobile.R;
import it.valeriocristofori.thefridgemobile.activity.addfood.AddFoodActivity;
import it.valeriocristofori.thefridgemobile.activity.home.HomeActivity;
import it.valeriocristofori.thefridgemobile.activity.profile.ProfileActivity;
import it.valeriocristofori.thefridgemobile.controller.ChooseRecipesController;
import it.valeriocristofori.thefridgemobile.model.customize.recycler.RecyclerRecipeCustom;
import it.valeriocristofori.thefridgemobile.model.entity.Recipe;

public class ChooseRecipesActivity extends AppCompatActivity {

    private int numRecipes;
    private ArrayList<Recipe> arrayRecipes;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_recipes);

        new Holder(this);
    }


    class Holder implements View.OnClickListener{

        private Context context;

        Holder(Context context) {
            //take context
            this.context = context;

            //init image buttons
            ImageButton ibtnFridge = findViewById(R.id.ibtnFridge);
            ImageButton ibtnRecipes = findViewById(R.id.ibtnRecipes);
            ImageButton ibtnProfile = findViewById(R.id.ibtnProfile);
            ImageButton ibtnAddFood = findViewById(R.id.ibtnAddFood);

            this.getData();
            this.setData();

            RecyclerView rvRecipe = findViewById(R.id.rvRecipe);

            //init recycler
            RecyclerRecipeCustom recyclerCategoryCustom = new RecyclerRecipeCustom(this.context, arrayRecipes);
            rvRecipe.setAdapter(recyclerCategoryCustom);
            rvRecipe.setLayoutManager(new LinearLayoutManager(this.context));


            //assign listener
            ibtnFridge.setOnClickListener(this);
            ibtnRecipes.setOnClickListener(this);
            ibtnProfile.setOnClickListener(this);
            ibtnAddFood.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            v.startAnimation(AnimationUtils.loadAnimation(this.context, R.anim.on_click));

            switch(v.getId()) {

                case R.id.ibtnProfile:
                    Intent intent = new Intent(v.getContext(), ProfileActivity.class);
                    startActivityForResult(intent,0);
                    break;

                case R.id.ibtnAddFood:
                    intent = new Intent(v.getContext(), AddFoodActivity.class);
                    startActivityForResult(intent,0);
                    break;

                case R.id.ibtnFridge:
                    intent = new Intent(v.getContext(), HomeActivity.class);
                    startActivityForResult(intent,0);
                    break;

                case R.id.ibtnRecipes:
                    intent = new Intent(v.getContext(), SearchRecipesActivity.class);
                    startActivityForResult(intent,0);
                    break;

            }
        }


        private void getData() {
            //default provide 1 recipe
            numRecipes = getIntent().getIntExtra("num_recipes", 1);
        }

        private void setData(){
            try {
                arrayRecipes = new ChooseRecipesController().execute(numRecipes).get();
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
