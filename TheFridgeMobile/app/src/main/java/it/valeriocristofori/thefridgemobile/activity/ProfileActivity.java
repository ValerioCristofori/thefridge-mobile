package it.valeriocristofori.thefridgemobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import it.valeriocristofori.thefridgemobile.R;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        Holder holder = new Holder();
    }

    class Holder implements View.OnClickListener{
        private ImageButton ibtnAddFood;
        private ImageButton ibtnRecipes;
        private ImageButton ibtnFrifge;
        private Button btnDelete;
        private Intent intent;

        public Holder(){
            //init image buttons
            this.btnDelete = findViewById(R.id.btnDelete);
            this.ibtnAddFood = (ImageButton)findViewById(R.id.ibtnAddFood);
            this.ibtnRecipes = (ImageButton)findViewById(R.id.ibtnRecipes);
            this.ibtnFrifge = (ImageButton)findViewById(R.id.ibtnFridge);

            //assign listener
            this.btnDelete.setOnClickListener(this);
            this.ibtnAddFood.setOnClickListener(this);
            this.ibtnRecipes.setOnClickListener(this);
            this.ibtnFrifge.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            switch(v.getId()) {

                case R.id.btnDelete:
                    intent = new Intent(v.getContext(), DeleteAccount.class);
                    startActivityForResult(intent,0);
                    break;

                case R.id.ibtnRecipes:
                    intent = new Intent(v.getContext(), ChooseRecipesActivity.class);
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

            }


        }
    }

}
