package it.valeriocristofori.thefridgemobile.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
        private RecyclerView rvFridge;
        private Intent intent;
        private Context context;
        private int images[] = {R.drawable.category_fruit,R.drawable.category_vegetable,R.drawable.category_meat,
                R.drawable.category_fish,R.drawable.category_cereal,R.drawable.category_bread,R.drawable.category_legume,
                R.drawable.category_mushroom,R.drawable.category_dairy_product,R.drawable.category_dessert,R.drawable.category_spices,
                R.drawable.category_sauces,R.drawable.category_beverage,R.drawable.category_vegan,R.drawable.category_oil};

        public Holder(Context context){
            //take context
            this.context = context;
            //init image buttons
            this.ibtnAddFood = findViewById(R.id.ibtnAddFood);
            this.ibtnRecipes = findViewById(R.id.ibtnRecipes);
            this.ibtnProfile = findViewById(R.id.ibtnProfile);
            this.rvFridge = findViewById(R.id.rvFridge);


            //take content of fridge
            //create and populate the recycler
            ViewFridgeController viewFridgeController = new ViewFridgeController();
            ArrayList<Food> data = viewFridgeController.takeContent();
            int[] arrayImages = this.createImagesArray(data);
            RecyclerFridgeCustom recyclerFridgeCustom = new RecyclerFridgeCustom( this.context, data, arrayImages );

            //setting
            rvFridge.setAdapter(recyclerFridgeCustom);
            rvFridge.setLayoutManager(new GridLayoutManager(this.context, 3));

            //assign listener
            this.ibtnAddFood.setOnClickListener(this);
            this.ibtnRecipes.setOnClickListener(this);
            this.ibtnProfile.setOnClickListener(this);
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

        private int[] createImagesArray(ArrayList<Food> data) {
            int arrayImages[] = new int[data.size()];
            for(int i = 0; i < data.size(); i++ ){
                arrayImages[i] = this.selectImage(data.get(i));
            }
            return arrayImages;
        }

        private int selectImage(Food food) {
            switch(food.getCategory()){
                case "fruit": return images[0];
                case "vegetable": return images[1];
                case "meat": return images[2];
                case "fish": return images[3];
                case "cereal_flour": return images[4];
                case "pasta_bread": return images[5];
                case "legumes": return images[6];
                case "mushrooms": return images[7];
                case "dairy_product": return images[8];
                case "dessert": return images[9];
                case "spices": return images[10];
                case "sauces": return images[11];
                case "beverages": return images[12];
                case "vegan": return images[13];
                case "oils": return images[14];
                default: return images[0];
            }
        }
    }

}
