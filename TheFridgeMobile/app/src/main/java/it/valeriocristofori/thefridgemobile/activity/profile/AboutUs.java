package it.valeriocristofori.thefridgemobile.activity.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import it.valeriocristofori.thefridgemobile.R;
import it.valeriocristofori.thefridgemobile.activity.addfood.AddFoodActivity;
import it.valeriocristofori.thefridgemobile.activity.home.HomeActivity;
import it.valeriocristofori.thefridgemobile.activity.recipe.SearchRecipesActivity;
import it.valeriocristofori.thefridgemobile.implementation.instance.Instance;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);

        Holder holder = new Holder();

    }

    class Holder implements View.OnClickListener{
        private ImageButton ibtnBack;
        private Intent intent;

        private String username, text;

        public Holder(){
            //init image buttons
            this.ibtnBack = (ImageButton)findViewById(R.id.ibtnBack);

            //assign listener
            this.ibtnBack.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            switch(v.getId()) {

                case R.id.ibtnBack:
                    intent = new Intent(v.getContext(), ProfileActivity.class);
                    startActivityForResult(intent,0);
                    break;

            }

        }
    }

}
