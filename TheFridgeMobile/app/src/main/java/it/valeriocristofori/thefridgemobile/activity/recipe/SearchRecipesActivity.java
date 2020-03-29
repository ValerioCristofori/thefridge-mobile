package it.valeriocristofori.thefridgemobile.activity.recipe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import it.valeriocristofori.thefridgemobile.R;
import it.valeriocristofori.thefridgemobile.activity.addfood.AddFoodActivity;
import it.valeriocristofori.thefridgemobile.activity.HomeActivity;
import it.valeriocristofori.thefridgemobile.activity.profile.ProfileActivity;

public class SearchRecipesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_recipes);

        Holder holder = new Holder(this);
    }

    class Holder implements View.OnClickListener{
        private Button btnSearch;
        private ImageButton ibtnAddFood;
        private ImageButton ibtnProfile;
        private ImageButton ibtnFrifge;
        private Intent intent;
        private Context context;

        public Holder(Context context){
            //init context
            this.context = context;

            //init image buttons
            this.ibtnAddFood = (ImageButton)findViewById(R.id.ibtnAddFood);
            this.ibtnProfile = (ImageButton)findViewById(R.id.ibtnProfile);
            this.ibtnFrifge = (ImageButton)findViewById(R.id.ibtnFridge);

            this.btnSearch = findViewById(R.id.btnSearch);

            //assign listener
            this.ibtnAddFood.setOnClickListener(this);
            this.ibtnProfile.setOnClickListener(this);
            this.ibtnFrifge.setOnClickListener(this);
            this.btnSearch.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

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
                    intent = new Intent(v.getContext(), ChooseRecipesActivity.class);
                    startActivityForResult(intent,0);
                    break;

            }


        }
    }

}
