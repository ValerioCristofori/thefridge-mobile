package it.valeriocristofori.thefridgemobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import it.valeriocristofori.thefridgemobile.R;

public class ChooseRecipesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_recipes);

        Holder holder = new Holder();
    }

    class Holder implements View.OnClickListener{
        private ImageButton ibtnAddFood;
        private ImageButton ibtnProfile;
        private ImageButton ibtnFrifge;
        private Intent intent;

        public Holder(){
            //init image buttons
            this.ibtnAddFood = (ImageButton)findViewById(R.id.ibtnAddFood);
            this.ibtnProfile = (ImageButton)findViewById(R.id.ibtnProfile);
            this.ibtnFrifge = (ImageButton)findViewById(R.id.ibtnFridge);

            //assign listener
            this.ibtnAddFood.setOnClickListener(this);
            this.ibtnProfile.setOnClickListener(this);
            this.ibtnFrifge.setOnClickListener(this);
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

            }
            /** error : not thread alive
             if( v.getId() == R.id.ibtnAddFood ){
             //remand add food GUI
             startActivity(new Intent( HomeActivity.this, AddFoodActivity.class ));
             }
             */


        }
    }

}
