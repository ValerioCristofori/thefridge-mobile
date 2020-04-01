package it.valeriocristofori.thefridgemobile.activity.recipe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import it.valeriocristofori.thefridgemobile.R;
import it.valeriocristofori.thefridgemobile.activity.addfood.AddFoodActivity;
import it.valeriocristofori.thefridgemobile.activity.home.HomeActivity;
import it.valeriocristofori.thefridgemobile.activity.profile.ProfileActivity;

public class SearchRecipesActivity extends AppCompatActivity {

    private int numRecipes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_recipes);

        Holder holder = new Holder(this);
    }

    class Holder implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
        //radio group
        private RadioGroup rgNumRecipe;

        private Button btnSearch;
        private ImageButton ibtnAddFood;
        private ImageButton ibtnProfile;
        private ImageButton ibtnFrifge;
        private Intent intent;
        private Context context;
        private ProgressBar progressBar;

        public Holder(Context context){
            //init context
            this.context = context;

            //init image buttons
            this.ibtnAddFood = findViewById(R.id.ibtnAddFood);
            this.ibtnProfile = findViewById(R.id.ibtnProfile);
            this.ibtnFrifge = findViewById(R.id.ibtnFridge);

            //init radios
            this.rgNumRecipe = findViewById(R.id.rgNumRecipe);

            this.btnSearch = findViewById(R.id.btnSearch);
            this.progressBar = findViewById(R.id.progressBar);

            //assign listener
            this.ibtnAddFood.setOnClickListener(this);
            this.ibtnProfile.setOnClickListener(this);
            this.ibtnFrifge.setOnClickListener(this);
            this.btnSearch.setOnClickListener(this);

            rgNumRecipe.setOnCheckedChangeListener(this);

        }

        @Override
        public void onClick(View v) {
            v.startAnimation(AnimationUtils.loadAnimation(this.context, R.anim.on_click));


            switch(v.getId()) {

                case R.id.ibtnProfile:
                    intent = new Intent(v.getContext(), ProfileActivity.class);
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

                case R.id.btnSearch:
                    this.progressBar.setVisibility(View.VISIBLE);
                    intent = new Intent(v.getContext(), ChooseRecipesActivity.class);
                    intent.putExtra("num_recipes", numRecipes);
                    startActivityForResult(intent,0);
                    break;

            }


        }

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.rbtn1:
                    numRecipes=1;
                    break;
                case R.id.rbtn2:
                    numRecipes=2;
                    break;
                case R.id.rbtn3:
                    numRecipes=3;
                    break;
                case R.id.rbtn4:
                    numRecipes=4;
                    break;
                case R.id.rbtn5:
                    numRecipes=5;
                    break;
            }
        }
    }

}
