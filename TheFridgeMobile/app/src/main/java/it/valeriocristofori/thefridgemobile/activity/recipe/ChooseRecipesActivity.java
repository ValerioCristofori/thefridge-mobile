package it.valeriocristofori.thefridgemobile.activity.recipe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import it.valeriocristofori.thefridgemobile.R;
import it.valeriocristofori.thefridgemobile.activity.HomeActivity;
import it.valeriocristofori.thefridgemobile.activity.profile.ProfileActivity;
import it.valeriocristofori.thefridgemobile.controller.ChooseRecipesController;
import it.valeriocristofori.thefridgemobile.model.entity.Recipe;

public class ChooseRecipesActivity extends AppCompatActivity {

    private int numRecipes;
    private ArrayList<Recipe> arrayRecipes;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_recipes);

        Holder holder = new Holder(this);
    }


    class Holder implements View.OnClickListener{

        private Context context;
        private ImageButton ibtnFridge;
        private ImageButton ibtnRecipes;
        private ImageButton ibtnProfile;
        private Intent intent;
        private RecyclerView rvRecipe;



        public Holder(Context context) {
            //take context
            this.context = context;

            //init image buttons
            this.ibtnFridge = findViewById(R.id.ibtnFridge);
            this.ibtnRecipes = findViewById(R.id.ibtnRecipes);
            this.ibtnProfile = findViewById(R.id.ibtnProfile);

            this.getData();
            this.setData();

            this.rvRecipe = findViewById(R.id.rvRecipe);

            //init recycler



            //assign listener
            this.ibtnFridge.setOnClickListener(this);
            this.ibtnRecipes.setOnClickListener(this);
            this.ibtnProfile.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch(v.getId()) {

                case R.id.ibtnProfile:
                    intent = new Intent(v.getContext(), ProfileActivity.class);
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
            ChooseRecipesController chooseRecipesController = new ChooseRecipesController();
            arrayRecipes = chooseRecipesController.takeRecipesList( numRecipes );
        }
    }
}