package it.valeriocristofori.thefridgemobile.activity.addfood;

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
import it.valeriocristofori.thefridgemobile.activity.home.HomeActivity;
import it.valeriocristofori.thefridgemobile.activity.profile.ProfileActivity;
import it.valeriocristofori.thefridgemobile.activity.recipe.SearchRecipesActivity;
import it.valeriocristofori.thefridgemobile.controller.AddFoodController;
import it.valeriocristofori.thefridgemobile.implementation.instance.Instance;
import it.valeriocristofori.thefridgemobile.model.customize.TextChangedListener;
import it.valeriocristofori.thefridgemobile.model.customize.recycler.RecyclerFridgeCustom;
import it.valeriocristofori.thefridgemobile.model.customize.recycler.RecyclerSearchFoodCustom;
import it.valeriocristofori.thefridgemobile.model.entity.Food;

public class SearchFoodActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_food);

        new Holder(this);
    }

    class Holder implements View.OnClickListener{

        private Context context;
        private Intent intent;

        private ImageButton ibtnFridge;
        private ImageButton ibtnRecipes;
        private ImageButton ibtnProfile;
        private EditText etSearchBar;

        //declare attr for recycler
        private RecyclerView rvSearchFood;
        private int images[] = Instance.getSingletonInstance().getImages();

        public Holder(final Context context){
            //init
            this.context = context;
            //init image buttons
            this.ibtnFridge = findViewById(R.id.ibtnFridge);
            this.ibtnRecipes = findViewById(R.id.ibtnRecipes);
            this.ibtnProfile = findViewById(R.id.ibtnProfile);
            this.etSearchBar = findViewById(R.id.etSearchBar);

            //init for recycler
            //and populate it
            this.rvSearchFood = findViewById(R.id.rvSearchFood);

            //new the logic controller
            final AddFoodController addFoodController = new AddFoodController();

            //assign text watcher
            //override for searching in this instance
            this.etSearchBar.addTextChangedListener(new TextChangedListener<EditText>(this.etSearchBar) {

                @Override
                public void onTextChanged(EditText target, Editable s) {
                    //take the input in string form
                    String input = target.getText().toString();
                    //query all food that contains input as substring
                    ArrayList<Food> substringData = addFoodController.takeContentWithSubstring(input);

                    //init the recycler
                    int[] arrayImages = createImagesArray(substringData);
                    RecyclerSearchFoodCustom recyclerSearchFoodCustom = new RecyclerSearchFoodCustom( context, substringData, arrayImages );

                    //setting
                    rvSearchFood.setAdapter(recyclerSearchFoodCustom);
                    rvSearchFood.setLayoutManager(new GridLayoutManager(context, 3));
                }
            });

            //assign listener
            this.ibtnFridge.setOnClickListener(this);
            this.ibtnRecipes.setOnClickListener(this);
            this.ibtnProfile.setOnClickListener(this);
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

            }
        }
    }
}
