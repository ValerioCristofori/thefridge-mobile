package it.Trilogia.thefridgemobile.activity.recipe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import it.Trilogia.thefridgemobile.R;
import it.Trilogia.thefridgemobile.activity.addfood.AddFoodActivity;
import it.Trilogia.thefridgemobile.activity.home.HomeActivity;
import it.Trilogia.thefridgemobile.activity.profile.ProfileActivity;
import it.Trilogia.thefridgemobile.controller.ChooseRecipesController;
import it.Trilogia.thefridgemobile.model.customize.animation.AnimationCustom;
import it.Trilogia.thefridgemobile.model.customize.recycler.RecyclerRecipeCustom;
import it.Trilogia.thefridgemobile.model.entity.Recipe;

public class ChooseRecipesActivity extends AppCompatActivity {

    private int numRecipes;
    private ProgressBar progressBar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_choose_recipes);

        new Holder(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0) {
            //reset
            this.progressBar.setVisibility(View.INVISIBLE);
        }
    }

    public class Holder implements View.OnClickListener{

        private Context context;
        private View vFridge, vAddFood, vRecipe, vProfile;

        Holder(Context context) {
            //take context
            this.context = context;

            //init image buttons
            ImageButton ibtnFridge = findViewById(R.id.ibtnFridge);
            ImageButton ibtnRecipes = findViewById(R.id.ibtnRecipes);
            ImageButton ibtnProfile = findViewById(R.id.ibtnProfile);
            ImageButton ibtnAddFood = findViewById(R.id.ibtnAddFood);

            vFridge = findViewById(R.id.vFridge);
            vAddFood = findViewById(R.id.vAddFood);
            vRecipe = findViewById(R.id.vRecipe);
            vProfile = findViewById(R.id.vProfile);
            progressBar = findViewById(R.id.progressBar);

            progressBar.setVisibility(View.VISIBLE);

            this.getData();
            this.setData();


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
                    AnimationCustom.start_circular_reveal_anim( vProfile );
                    Intent intent = new Intent(v.getContext(), ProfileActivity.class);
                    startActivityForResult(intent,0);
                    break;

                case R.id.ibtnAddFood:
                    AnimationCustom.start_circular_reveal_anim( vAddFood );
                    intent = new Intent(v.getContext(), AddFoodActivity.class);
                    startActivityForResult(intent,0);
                    break;

                case R.id.ibtnFridge:
                    AnimationCustom.start_circular_reveal_anim( vFridge );
                    intent = new Intent(v.getContext(), HomeActivity.class);
                    startActivityForResult(intent,0);
                    break;

                case R.id.ibtnRecipes:
                    AnimationCustom.start_circular_reveal_anim( vRecipe );
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
            ChooseRecipesController chooseRecipesController = new ChooseRecipesController(this);
            chooseRecipesController.execute(numRecipes);

        }

        public void populate_recycler(ArrayList<Recipe> arrayRecipes){
            progressBar.setVisibility(View.INVISIBLE);
            RecyclerView rvRecipe = findViewById(R.id.rvRecipe);
            RecyclerRecipeCustom recyclerCategoryCustom = new RecyclerRecipeCustom(this.context, arrayRecipes);
            rvRecipe.setAdapter(recyclerCategoryCustom);
            rvRecipe.setLayoutManager(new LinearLayoutManager(this.context));
        }
    }



}
