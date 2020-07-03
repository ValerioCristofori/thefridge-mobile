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
import it.Trilogia.thefridgemobile.activity.sign.MainActivity;

public class TutorialActivityProfile extends AppCompatActivity {
    private static int typing = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_tutorial_profile);
        new Holder(this);
    }

    class Holder implements View.OnClickListener {

        private Context context;

        Holder(Context context){
            this.context = context;
            ConstraintLayout clProfile = findViewById(R.id.clTutorial);

            clProfile.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if( view.getId() == R.id.clTutorial ){
                typing++;
                if( typing == 1 ){
                    TextView tvTutorialLastMessage = findViewById(R.id.tvTutorialLastMessage);
                    TextView tvTutorialProfile = findViewById(R.id.tvTutorialProfile);
                    tvTutorialLastMessage.setVisibility(View.VISIBLE);
                    tvTutorialProfile.setVisibility(View.INVISIBLE);

                }else if( typing == 2 ){
                    //remand login gui
                    startActivity(new Intent(this.context, MainActivity.class));
                }


            }
        }
    }
}
