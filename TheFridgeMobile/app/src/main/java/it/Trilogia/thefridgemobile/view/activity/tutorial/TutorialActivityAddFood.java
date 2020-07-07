package it.Trilogia.thefridgemobile.view.activity.tutorial;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import it.Trilogia.thefridgemobile.R;

public class TutorialActivityAddFood extends AppCompatActivity {
    private static int typing = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_tutorial_addfood);
        new Holder(this);
    }

    class Holder implements View.OnClickListener {

        private Context context;

        Holder(Context context){
            this.context = context;

            ConstraintLayout clAddFood = findViewById(R.id.clTutorial);
            clAddFood.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if( view.getId() == R.id.clTutorial ) {
                typing++;
                if (typing == 1) {
                    ImageView vButtonFood = findViewById(R.id.vButtonFood);
                    TextView tvTutorialSearchFood = findViewById(R.id.tvTutorialSearchFood);
                    TextView tvTutorialAddFood = findViewById(R.id.tvTutorialAddFood);
                    vButtonFood.setVisibility(View.VISIBLE);
                    tvTutorialSearchFood.setVisibility(View.VISIBLE);
                    tvTutorialAddFood.setVisibility(View.INVISIBLE);

                } else if (typing == 2) {
                    startActivity(new Intent(this.context, TutorialActivityRecipe.class));
                }
            }
        }
    }
}
