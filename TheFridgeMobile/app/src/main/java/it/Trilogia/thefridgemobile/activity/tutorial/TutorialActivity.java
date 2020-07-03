package it.Trilogia.thefridgemobile.activity.tutorial;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import it.Trilogia.thefridgemobile.R;

public class TutorialActivity extends AppCompatActivity {

    private static int typing = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_tutorial_home);
        new Holder(this);
    }

    class Holder implements View.OnClickListener {

        private Context context;

        Holder(Context context){
            this.context = context;

            ConstraintLayout clFridge = findViewById(R.id.clTutorial);

            clFridge.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if( view.getId() == R.id.clTutorial ){
                typing++;
                Log.d("type", String.valueOf(typing));
                if( typing == 1 ) {
                    ImageView vButton = findViewById(R.id.vButtonFood);
                    TextView tvTutorialSearchFridge = findViewById(R.id.tvTutorialSearchFridge);
                    TextView tvTutorialFridge = findViewById(R.id.tvTutorialFridge);
                    vButton.setVisibility(View.VISIBLE);
                    tvTutorialSearchFridge.setVisibility(View.VISIBLE);
                    tvTutorialFridge.setVisibility(View.INVISIBLE);

                }else if( typing == 2 ) {
                    startActivity(new Intent(this.context, TutorialActivityAddFood.class));
                }

            }
        }
    }
}
