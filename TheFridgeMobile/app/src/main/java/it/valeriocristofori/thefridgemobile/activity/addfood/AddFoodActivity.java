package it.valeriocristofori.thefridgemobile.activity.addfood;

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

import it.valeriocristofori.thefridgemobile.R;
import it.valeriocristofori.thefridgemobile.activity.home.HomeActivity;
import it.valeriocristofori.thefridgemobile.activity.profile.ProfileActivity;
import it.valeriocristofori.thefridgemobile.activity.recipe.SearchRecipesActivity;
import it.valeriocristofori.thefridgemobile.implementation.instance.Instance;
import it.valeriocristofori.thefridgemobile.model.customize.recycler.RecyclerCategoryCustom;

public class AddFoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_food);

        Holder holder = new Holder(this);
    }

    class Holder implements View.OnClickListener{
        private Context context;
        private ImageButton ibtnFridge;
        private ImageButton ibtnRecipes;
        private ImageButton ibtnProfile;
        private ImageButton ibtnSearch;
        private Intent intent;

        //data for initialize recycler view
        private RecyclerView rvCategories;
        String str[];
        int images[] = Instance.getSingletonInstance().getImages();


        public Holder(Context context){
            //take context
            this.context = context;

            //init image buttons
            this.ibtnFridge = findViewById(R.id.ibtnFridge);
            this.ibtnRecipes = findViewById(R.id.ibtnRecipes);
            this.ibtnProfile = findViewById(R.id.ibtnProfile);
            this.ibtnSearch = findViewById(R.id.ibtnSearch);

            this.rvCategories = findViewById(R.id.rvSearchFood);

            //init recycler
            str = getResources().getStringArray(R.array.food_categories);
            RecyclerCategoryCustom recyclerCategoryCustom = new RecyclerCategoryCustom(this.context,this.str,this.images);
            rvCategories.setAdapter(recyclerCategoryCustom);
            rvCategories.setLayoutManager(new LinearLayoutManager(this.context));


            //assign listener
            this.ibtnFridge.setOnClickListener(this);
            this.ibtnRecipes.setOnClickListener(this);
            this.ibtnProfile.setOnClickListener(this);
            this.ibtnSearch.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            v.startAnimation(AnimationUtils.loadAnimation(this.context, R.anim.on_click));

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

                case R.id.ibtnSearch:
                    intent = new Intent(v.getContext(), SearchFoodActivity.class);
                    startActivityForResult(intent,0);
                    break;

            }
        }
    }

}
