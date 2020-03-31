package it.valeriocristofori.thefridgemobile.activity.profile;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import it.valeriocristofori.thefridgemobile.R;

public class DeleteAccount extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_account);

        //creazione pop up
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .7), (int) (height * .5));

        Holder holder = new Holder();

    }

    class Holder implements View.OnClickListener {
        private Button btnYes;
        private Button btnNo;
        private Intent intent;

        public Holder() {

            this.btnYes = findViewById(R.id.btnYes);
            this.btnNo = findViewById(R.id.btnNo);

            this.btnYes.setOnClickListener(this);
            this.btnNo.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            switch (v.getId()) {

                case R.id.btnNo:
                    intent = new Intent(v.getContext(), ProfileActivity.class);
                    startActivityForResult(intent, 0);
                    break;

                case R.id.btnYes:
                    //cancella dati da DB
                    intent = new Intent(v.getContext(), RegisterActivity.class);
                    startActivityForResult(intent, 0);
                    break;
            }
        }
    }
}
    
