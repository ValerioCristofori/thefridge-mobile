package it.Trilogia.thefridgemobile.activity.addfood;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import it.Trilogia.thefridgemobile.R;
import it.Trilogia.thefridgemobile.activity.home.HomeActivity;
import it.Trilogia.thefridgemobile.activity.profile.ProfileActivity;
import it.Trilogia.thefridgemobile.activity.recipe.SearchRecipesActivity;
import it.Trilogia.thefridgemobile.controller.AddFoodController;
import it.Trilogia.thefridgemobile.implementation.instance.Instance;
import it.Trilogia.thefridgemobile.model.customize.TextChangedListener;
import it.Trilogia.thefridgemobile.model.customize.animation.AnimationCustom;
import it.Trilogia.thefridgemobile.model.customize.recycler.RecyclerSearchFoodCustom;
import it.Trilogia.thefridgemobile.model.entity.Food;

public class SearchFoodActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_search_food);

        new Holder(this);
    }

    class Holder implements View.OnClickListener{

        private Context context;
        private EditText etSearchBar;
        private View vFridge, vAddFood, vRecipe, vProfile;

        //declare attr for recycler
        private RecyclerView rvSearchFood;
        private int[] images = Instance.getSingletonInstance().getImages();

        Holder(final Context context){
            //init
            this.context = context;
            //init image buttons
            ImageButton ibtnFridge = findViewById(R.id.ibtnFridge);
            ImageButton ibtnRecipes = findViewById(R.id.ibtnRecipes);
            ImageButton ibtnProfile = findViewById(R.id.ibtnProfile);
            ImageButton ibtnAddFood = findViewById(R.id.ibtnAddFood);
            this.etSearchBar = findViewById(R.id.etSearchBar);

            vFridge = findViewById(R.id.vFridge);
            vAddFood = findViewById(R.id.vAddFood);
            vRecipe = findViewById(R.id.vRecipe);
            vProfile = findViewById(R.id.vProfile);

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
            ibtnFridge.setOnClickListener(this);
            ibtnRecipes.setOnClickListener(this);
            ibtnProfile.setOnClickListener(this);
            ibtnAddFood.setOnClickListener(this);
        }

        private int[] createImagesArray(ArrayList<Food> data) {
            int[] arrayImages = new int[data.size()];
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
                    AnimationCustom.start_circular_reveal_anim( vProfile );
                    Intent intent = new Intent(v.getContext(), ProfileActivity.class);
                    startActivityForResult(intent,0);
                    break;

                case R.id.ibtnFridge:
                    AnimationCustom.start_circular_reveal_anim( vFridge );
                    intent = new Intent(v.getContext(), HomeActivity.class);
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
