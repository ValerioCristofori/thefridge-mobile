package it.Trilogia.thefridgemobile.activity.tutorial;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import it.Trilogia.thefridgemobile.R;
import it.Trilogia.thefridgemobile.activity.home.HomeActivity;

public class TutorialActivityRecipe extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_tutorial_search_recipes);
        new Holder(this);
    }

    class Holder implements View.OnClickListener {

        private Context context;

        Holder(Context context){
            this.context = context;

            ConstraintLayout clRecipe = findViewById(R.id.clTutorial);
            clRecipe.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if( view.getId() == R.id.clTutorial ){

                startActivity(new Intent(this.context, TutorialActivityProfile.class));

            }
        }
    }
}
