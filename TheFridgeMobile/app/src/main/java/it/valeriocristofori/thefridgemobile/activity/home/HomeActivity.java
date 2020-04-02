package it.valeriocristofori.thefridgemobile.activity.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import it.valeriocristofori.thefridgemobile.R;
import it.valeriocristofori.thefridgemobile.activity.addfood.AddFoodActivity;
import it.valeriocristofori.thefridgemobile.activity.profile.ProfileActivity;
import it.valeriocristofori.thefridgemobile.activity.recipe.SearchRecipesActivity;
import it.valeriocristofori.thefridgemobile.controller.ViewFridgeController;
import it.valeriocristofori.thefridgemobile.implementation.instance.Instance;
import it.valeriocristofori.thefridgemobile.model.customize.TextChangedListener;
import it.valeriocristofori.thefridgemobile.model.customize.recycler.RecyclerFridgeCustom;
import it.valeriocristofori.thefridgemobile.model.entity.Food;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Holder holder = new Holder(this);
    }

    class Holder implements View.OnClickListener{
        private ImageButton ibtnAddFood;
        private ImageButton ibtnRecipes;
        private ImageButton ibtnProfile;
        private EditText etSearchBar;
        private RecyclerView rvFridge;
        private Intent intent;
        private Context context;

        public Holder(final Context context) {

            //take context
            this.context = context;
            //init image buttons
            this.ibtnAddFood = findViewById(R.id.ibtnAddFood);
            this.ibtnRecipes = findViewById(R.id.ibtnRecipes);
            this.ibtnProfile = findViewById(R.id.ibtnProfile);
            this.etSearchBar = findViewById(R.id.etSearchBar);
            this.rvFridge = findViewById(R.id.rvFridge);


            //take content of fridge
            //create and populate the recycler
            final ViewFridgeController viewFridgeController = new ViewFridgeController();
            ArrayList<Food> data = viewFridgeController.takeContent();
            RecyclerFridgeCustom recyclerFridgeCustom = new RecyclerFridgeCustom( this.context, data );

            //setting
            rvFridge.setAdapter(recyclerFridgeCustom);
            rvFridge.setLayoutManager(new GridLayoutManager(this.context, 3));

            //assign listener
            this.ibtnAddFood.setOnClickListener(this);
            this.ibtnRecipes.setOnClickListener(this);
            this.ibtnProfile.setOnClickListener(this);

            //assign text watcher
            //override for searching in this instance
            this.etSearchBar.addTextChangedListener(new TextChangedListener<EditText>(this.etSearchBar) {

                @Override
                public void onTextChanged(EditText target, Editable s) {
                    //take the input in string form
                    String input = target.getText().toString();
                    //query all food that contains input as substring
                    ArrayList<Food> substringData = viewFridgeController.takeContentWithSubstring(input);
                    Log.e("substrings", substringData.toArray().toString());
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
                    intent = new Intent(v.getContext(), ProfileActivity.class);
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
