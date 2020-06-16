package it.valeriocristofori.thefridgemobile.activity.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import it.valeriocristofori.thefridgemobile.R;
import it.valeriocristofori.thefridgemobile.activity.home.HomeActivity;
import it.valeriocristofori.thefridgemobile.activity.addfood.AddFoodActivity;
import it.valeriocristofori.thefridgemobile.activity.recipe.SearchRecipesActivity;
import it.valeriocristofori.thefridgemobile.implementation.instance.Instance;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        new Holder();

    }

    class Holder implements View.OnClickListener{

        Holder(){
            //init image buttons
            Button btnDelete = findViewById(R.id.btnDelete);
            ImageButton ibtnAddFood = findViewById(R.id.ibtnAddFood);
            ImageButton ibtnRecipes = findViewById(R.id.ibtnRecipes);
            ImageButton ibtnFrifge = findViewById(R.id.ibtnFridge);
            Button btnAboutUs = findViewById(R.id.btnAboutUs);

            TextView tvUsername = findViewById(R.id.tvUsername);
            //query DB per sapere username
            String username = Instance.getSingletonInstance().getCurrentUser().getUsername();
            //////////
            String welcome = "Welcome back ";
            String text = welcome.concat(username);
            tvUsername.setText(text);

            TextView tvEmail = findViewById(R.id.tvEmail);
            //query DB per sapere email
            String email = "Email: ";
            text = email.concat(Instance.getSingletonInstance().getCurrentUser().getEmail());

            tvEmail.setText(text);

            //assign listener
            btnDelete.setOnClickListener(this);
            ibtnAddFood.setOnClickListener(this);
            ibtnRecipes.setOnClickListener(this);
            ibtnFrifge.setOnClickListener(this);
            btnAboutUs.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            switch(v.getId()) {

                case R.id.btnAboutUs:
                    Intent intent = new Intent(v.getContext(), AboutUs.class);
                    startActivityForResult(intent,0);
                    break;

                case R.id.btnDelete:
                    intent = new Intent(v.getContext(), DeleteAccount.class);
                    startActivityForResult(intent,0);
                    break;

                case R.id.ibtnRecipes:
                    intent = new Intent(v.getContext(), SearchRecipesActivity.class);
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
