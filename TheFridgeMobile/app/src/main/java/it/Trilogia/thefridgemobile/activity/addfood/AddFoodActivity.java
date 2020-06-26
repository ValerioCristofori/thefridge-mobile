package it.Trilogia.thefridgemobile.activity.addfood;

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

import it.Trilogia.thefridgemobile.R;
import it.Trilogia.thefridgemobile.activity.home.HomeActivity;
import it.Trilogia.thefridgemobile.activity.profile.ProfileActivity;
import it.Trilogia.thefridgemobile.activity.recipe.SearchRecipesActivity;
import it.Trilogia.thefridgemobile.implementation.instance.Instance;
import it.Trilogia.thefridgemobile.model.customize.animation.AnimationCustom;
import it.Trilogia.thefridgemobile.model.customize.recycler.RecyclerCategoryCustom;

public class AddFoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_add_food);

        new Holder(this);
    }
    @Override
    public void onBackPressed() {
    }

    class Holder implements View.OnClickListener{
        private Context context;
        private View vFridge, vAddFood, vRecipe, vProfile;

        String[] str;
        int[] images = Instance.getSingletonInstance().getImages();


        Holder(Context context){
            //take context
            this.context = context;

            //init image buttons
            ImageButton ibtnFridge = findViewById(R.id.ibtnFridge);
            ImageButton ibtnRecipes = findViewById(R.id.ibtnRecipes);
            ImageButton ibtnProfile = findViewById(R.id.ibtnProfile);
            ImageButton ibtnSearch = findViewById(R.id.ibtnSearch);
            vFridge = findViewById(R.id.vFridge);
            vAddFood = findViewById(R.id.vAddFood);
            vRecipe = findViewById(R.id.vRecipe);
            vProfile = findViewById(R.id.vProfile);

            //data for initialize recycler view
            RecyclerView rvCategories = findViewById(R.id.rvSearchFood);

            //init recycler
            str = getResources().getStringArray(R.array.food_categories);
            RecyclerCategoryCustom recyclerCategoryCustom = new RecyclerCategoryCustom(this.context,this.str,this.images);
            rvCategories.setAdapter(recyclerCategoryCustom);
            rvCategories.setLayoutManager(new LinearLayoutManager(this.context));


            //assign listener
            ibtnFridge.setOnClickListener(this);
            ibtnRecipes.setOnClickListener(this);
            ibtnProfile.setOnClickListener(this);
            ibtnSearch.setOnClickListener(this);
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

                case R.id.ibtnSearch:
                    intent = new Intent(v.getContext(), SearchFoodActivity.class);
                    startActivityForResult(intent,0);
                    break;

            }
        }
    }

}
