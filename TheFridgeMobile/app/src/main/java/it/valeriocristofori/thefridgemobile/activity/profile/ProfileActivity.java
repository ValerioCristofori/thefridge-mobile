package it.valeriocristofori.thefridgemobile.activity.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import it.valeriocristofori.thefridgemobile.R;
import it.valeriocristofori.thefridgemobile.activity.HomeActivity;
import it.valeriocristofori.thefridgemobile.activity.addfood.AddFoodActivity;
import it.valeriocristofori.thefridgemobile.activity.recipe.SearchRecipesActivity;

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
        private TextView tvUsername;
        private TextView tvEmail;
        private Intent intent;
        private String welcome = "Hi ";
        private String username, text;

        public Holder(){
            //init image buttons
            this.btnDelete = findViewById(R.id.btnDelete);
            this.ibtnAddFood = (ImageButton)findViewById(R.id.ibtnAddFood);
            this.ibtnRecipes = (ImageButton)findViewById(R.id.ibtnRecipes);
            this.ibtnFrifge = (ImageButton)findViewById(R.id.ibtnFridge);

            this.tvUsername = findViewById(R.id.tvUsername);
            //query DB per sapere username
            username = "Carl";
            //////////
            text = welcome.concat(username);
            tvUsername.setText(text);

            this.tvEmail = findViewById(R.id.tvEmail);
            //query DB per sapere email
            tvEmail.setText("email@gmail.com");

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
