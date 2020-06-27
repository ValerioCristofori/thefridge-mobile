package it.Trilogia.thefridgemobile.activity.profile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import it.Trilogia.thefridgemobile.R;
import it.Trilogia.thefridgemobile.activity.home.HomeActivity;
import it.Trilogia.thefridgemobile.activity.addfood.AddFoodActivity;
import it.Trilogia.thefridgemobile.activity.recipe.SearchRecipesActivity;
import it.Trilogia.thefridgemobile.activity.sign.MainActivity;
import it.Trilogia.thefridgemobile.implementation.instance.Instance;
import it.Trilogia.thefridgemobile.model.customize.animation.AnimationCustom;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_profile);

        new Holder();

    }
    @Override
    public void onBackPressed() {
    }

    class Holder implements View.OnClickListener{

        private View vFridge, vAddFood, vRecipe, vProfile;

        Holder(){
            //init image buttons
            Button btnDelete = findViewById(R.id.btnDelete);
            ImageButton ibtnAddFood = findViewById(R.id.ibtnAddFood);
            ImageButton ibtnRecipes = findViewById(R.id.ibtnRecipes);
            ImageButton ibtnFrifge = findViewById(R.id.ibtnFridge);
            Button btnAboutUs = findViewById(R.id.btnAboutUs);
            Button btnLogout = findViewById(R.id.btnLogout);

            vFridge = findViewById(R.id.vFridge);
            vAddFood = findViewById(R.id.vAddFood);
            vRecipe = findViewById(R.id.vRecipe);
            vProfile = findViewById(R.id.vProfile);

            TextView tvUsername = findViewById(R.id.tvUsername);
            //query per sapere username
            String username = Instance.getSingletonInstance().getCurrentUser().getUsername();

            String welcome = getString(R.string.welcome);
            String text = welcome.concat(String.format(" " + username) );
            tvUsername.setText(text);

            TextView tvEmail = findViewById(R.id.tvEmail);
            //query per sapere email
            String email = "Email:";
            text = email.concat(String.format(" " + Instance.getSingletonInstance().getCurrentUser().getEmail() ) );

            tvEmail.setText(text);

            //assign listener
            btnDelete.setOnClickListener(this);
            ibtnAddFood.setOnClickListener(this);
            ibtnRecipes.setOnClickListener(this);
            ibtnFrifge.setOnClickListener(this);
            btnAboutUs.setOnClickListener(this);
            btnLogout.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            switch(v.getId()) {

                case R.id.btnLogout:

                    SharedPreferences pref = getApplicationContext().getSharedPreferences("checkbox", ProfileActivity.MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.clear();
                    editor.commit();

                    Intent intent = new Intent(v.getContext(), MainActivity.class);
                    startActivityForResult(intent, 0);
                    break;

                case R.id.btnAboutUs:
                    intent = new Intent(v.getContext(), AboutUs.class);
                    startActivityForResult(intent,0);
                    break;

                case R.id.btnDelete:
                    intent = new Intent(v.getContext(), DeleteAccount.class);
                    startActivityForResult(intent,0);
                    break;

                case R.id.ibtnRecipes:
                    AnimationCustom.start_circular_reveal_anim( vRecipe );
                    intent = new Intent(v.getContext(), SearchRecipesActivity.class);
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

            }


        }
    }

}
