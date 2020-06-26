package it.Trilogia.thefridgemobile.activity.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import it.Trilogia.thefridgemobile.R;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_about_us);

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
