package it.Trilogia.thefridgemobile.activity.home;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

import it.Trilogia.thefridgemobile.R;
import it.Trilogia.thefridgemobile.activity.addfood.AddFoodActivity;
import it.Trilogia.thefridgemobile.activity.profile.ProfileActivity;
import it.Trilogia.thefridgemobile.activity.recipe.SearchRecipesActivity;
import it.Trilogia.thefridgemobile.controller.ViewFridgeController;
import it.Trilogia.thefridgemobile.model.customize.TextChangedListener;
import it.Trilogia.thefridgemobile.model.customize.animation.AnimationCustom;
import it.Trilogia.thefridgemobile.model.customize.recycler.RecyclerFridgeCustom;
import it.Trilogia.thefridgemobile.model.entity.Food;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_fridge);

        new Holder(this);
    }

    @Override
    public void onBackPressed() {
    }

    class Holder implements View.OnClickListener{
        private EditText etSearchBar;
        private RecyclerView rvFridge;
        private Context context;
        private View vFridge, vAddFood, vRecipe, vProfile;

        Holder(final Context context) {

            //take context
            this.context = context;
            //init image buttons
            ImageButton ibtnAddFood = findViewById(R.id.ibtnAddFood);
            ImageButton ibtnRecipes = findViewById(R.id.ibtnRecipes);
            ImageButton ibtnProfile = findViewById(R.id.ibtnProfile);
            this.etSearchBar = findViewById(R.id.etSearchBar);

            vFridge = findViewById(R.id.vFridge);
            vAddFood = findViewById(R.id.vAddFood);
            vRecipe = findViewById(R.id.vRecipe);
            vProfile = findViewById(R.id.vProfile);


            this.rvFridge = findViewById(R.id.rvFridge);
            TextView tvEmptyAdvertisment = findViewById(R.id.tvEmptyAdvertisment);
            //take content of fridge
            //create and populate the recycler
            final ViewFridgeController viewFridgeController = new ViewFridgeController();
            ArrayList<Food> data = viewFridgeController.takeContent();

            RecyclerFridgeCustom recyclerFridgeCustom = new RecyclerFridgeCustom( this.context, data );

            //setting
            rvFridge.setAdapter(recyclerFridgeCustom);
            rvFridge.setLayoutManager(new GridLayoutManager(this.context, 3));

            //assign listener
            ibtnAddFood.setOnClickListener(this);
            ibtnRecipes.setOnClickListener(this);
            ibtnProfile.setOnClickListener(this);


            if(!data.isEmpty()){
                tvEmptyAdvertisment.setVisibility(View.INVISIBLE);
            }

            //assign text watcher
            //override for searching in this instance
            this.etSearchBar.addTextChangedListener(new TextChangedListener<EditText>(this.etSearchBar) {

                @Override
                public void onTextChanged(EditText target, Editable s) {
                    //take the input in string form
                    String input = target.getText().toString();
                    //query all food that contains input as substring
                    ArrayList<Food> substringData = viewFridgeController.takeContentWithSubstring(input);
                    Log.e("substrings", Arrays.toString(substringData.toArray()));
                    //init the recycler
                    RecyclerFridgeCustom recyclerFridgeCustom = new RecyclerFridgeCustom( context, substringData);

                    //setting
                    rvFridge.setAdapter(recyclerFridgeCustom);
                    rvFridge.setLayoutManager(new GridLayoutManager(context, 3));
                }
            });
        }



        @Override
        public void onClick(final View v) {
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

                case R.id.ibtnRecipes:
                    AnimationCustom.start_circular_reveal_anim( vRecipe );
                    intent = new Intent(v.getContext(), SearchRecipesActivity.class);
                    startActivityForResult(intent,0);
                    break;

            }


        }



    }

}
