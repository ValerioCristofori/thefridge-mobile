package it.Trilogia.thefridgemobile.view.activity.recipe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import it.Trilogia.thefridgemobile.R;
import it.Trilogia.thefridgemobile.model.implementation.instance.Instance;
import it.Trilogia.thefridgemobile.view.activity.addfood.AddFoodActivity;
import it.Trilogia.thefridgemobile.view.activity.home.HomeActivity;
import it.Trilogia.thefridgemobile.view.activity.profile.ProfileActivity;
import it.Trilogia.thefridgemobile.view.customize.animation.AnimationCustom;

public class SearchRecipesActivity extends AppCompatActivity {

    private int numRecipes = 1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_search_recipes);

        new Holder(this);
    }

    @Override
    public void onBackPressed() {
    }



    class Holder implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

        private Context context;
        private View vFridge, vAddFood, vRecipe, vProfile;

        Holder(Context context){
            //init context
            this.context = context;

            //init image buttons
            ImageButton ibtnAddFood = findViewById(R.id.ibtnAddFood);
            ImageButton ibtnProfile = findViewById(R.id.ibtnProfile);
            ImageButton ibtnFridge = findViewById(R.id.ibtnFridge);
            vFridge = findViewById(R.id.vFridge);
            vAddFood = findViewById(R.id.vAddFood);
            vRecipe = findViewById(R.id.vRecipe);
            vProfile = findViewById(R.id.vProfile);




            //init radios
            //radio group
            RadioGroup rgNumRecipe = findViewById(R.id.rgNumRecipe);

            Button btnSearch = findViewById(R.id.btnSearch);



            //assign listener
            ibtnAddFood.setOnClickListener(this);
            ibtnProfile.setOnClickListener(this);
            ibtnFridge.setOnClickListener(this);
            btnSearch.setOnClickListener(this);

            rgNumRecipe.setOnCheckedChangeListener(this);

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

                case R.id.btnSearch:
                    if( Instance.getSingletonInstance()
                                    .getCurrentUser()
                                        .getFridge()
                                            .getListFood()
                                                .size() == 0 ){
                            //Make toast for error message
                            //Fridge empty
                            this.displayErrorMessage(getString(R.string.error_message_fridge));
                    }else {
                        intent = new Intent(v.getContext(), ChooseRecipesActivity.class);
                        intent.putExtra("num_recipes", numRecipes);
                        startActivityForResult(intent, 0);
                    }
                    break;

            }





        }

        private void displayErrorMessage( String message ){
            //refactor this in the ToastCustom class!

            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom_layout_alert,
                    (ViewGroup) findViewById(R.id.custom_toast_container));

            TextView text = layout.findViewById(R.id.text);
            text.setText(message);


            Toast toast = new Toast(getApplicationContext());
            toast.setGravity(Gravity.TOP, 0, 0);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(layout);
            toast.show();

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
