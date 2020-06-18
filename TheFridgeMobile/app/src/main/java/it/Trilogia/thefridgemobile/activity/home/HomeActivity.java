package it.Trilogia.thefridgemobile.activity.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
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
import it.Trilogia.thefridgemobile.model.customize.recycler.RecyclerFridgeCustom;
import it.Trilogia.thefridgemobile.model.entity.Food;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        new Holder(this);
    }

    class Holder implements View.OnClickListener{
        private EditText etSearchBar;
        private TextView tvEmptyAdvertisment;
        private RecyclerView rvFridge;
        private Context context;

        Holder(final Context context) {

            //take context
            this.context = context;
            //init image buttons
            ImageButton ibtnAddFood = findViewById(R.id.ibtnAddFood);
            ImageButton ibtnRecipes = findViewById(R.id.ibtnRecipes);
            ImageButton ibtnProfile = findViewById(R.id.ibtnProfile);
            this.etSearchBar = findViewById(R.id.etSearchBar);
            this.rvFridge = findViewById(R.id.rvFridge);
            this.tvEmptyAdvertisment = findViewById(R.id.tvEmptyAdvertisment);
            //take content of fridge
            //create and populate the recycler
            final ViewFridgeController viewFridgeController = new ViewFridgeController();
            ArrayList<Food> data = viewFridgeController.takeContent();

            if(!data.isEmpty()){
                tvEmptyAdvertisment.setVisibility(View.INVISIBLE);
            }
            RecyclerFridgeCustom recyclerFridgeCustom = new RecyclerFridgeCustom( this.context, data );

            //setting
            rvFridge.setAdapter(recyclerFridgeCustom);
            rvFridge.setLayoutManager(new GridLayoutManager(this.context, 3));

            //assign listener
            ibtnAddFood.setOnClickListener(this);
            ibtnRecipes.setOnClickListener(this);
            ibtnProfile.setOnClickListener(this);

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

                case R.id.ibtnRecipes:
                    intent = new Intent(v.getContext(), SearchRecipesActivity.class);
                    startActivityForResult(intent,0);
                    break;

            }


        }


    }

}
