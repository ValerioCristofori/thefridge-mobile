package it.valeriocristofori.thefridgemobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import it.valeriocristofori.thefridgemobile.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Holder holder = new Holder();
    }

    class Holder implements View.OnClickListener{
        private ImageButton ibtnAddFood;
        private ImageButton ibtnRecipes;
        private ImageButton ibtnProfile;
        private ImageButton ibtnFridge;

        public Holder(){
            //init image buttons
            this.ibtnAddFood = (ImageButton)findViewById(R.id.ibtnAddFood);


            //assign listener
            this.ibtnAddFood.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            /** error : not thread alive
            if( v.getId() == R.id.ibtnAddFood ){
                //remand add food GUI
                startActivity(new Intent( HomeActivity.this, AddFoodActivity.class ));
            }
             */


        }
    }

}
