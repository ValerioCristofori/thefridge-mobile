package it.valeriocristofori.thefridgemobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import it.valeriocristofori.thefridgemobile.R;

public class AddFoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_food);

        Holder holder = new Holder();
    }

    class Holder implements View.OnClickListener{
        private ImageButton ibtnFridge;
        private ImageButton ibtnRecipes;
        private ImageButton ibtnProfile;
        private Intent intent;

        public Holder(){
            //init image buttons
            this.ibtnFridge = (ImageButton)findViewById(R.id.ibtnFridge);
            this.ibtnRecipes = findViewById(R.id.ibtnRecipes);
            this.ibtnProfile = (ImageButton)findViewById(R.id.ibtnProfile);

            //assign listener
            this.ibtnFridge.setOnClickListener(this);
            this.ibtnRecipes.setOnClickListener(this);
            this.ibtnProfile.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

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
                    intent = new Intent(v.getContext(), ChooseRecipesActivity.class);
                    startActivityForResult(intent,0);
                    break;

            }

        }
    }

}
