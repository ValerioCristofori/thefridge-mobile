package it.valeriocristofori.thefridgemobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import it.valeriocristofori.thefridgemobile.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create this.Holder
        Holder holder = new Holder();

    }

    class Holder implements View.OnClickListener{
        private Button btn_login;
        private Button btn_signup;

        public Holder(){
            //init login button
            this.btn_login = (Button)findViewById(R.id.btnLogin);
            //init signup button
            this.btn_signup = (Button)findViewById(R.id.btnSignup);

            //assign click listener
            this.btn_login.setOnClickListener(this);
            this.btn_signup.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.btnLogin){
                //remand home GUI
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
            }
            else if(v.getId() == R.id.btnSignup){
                //remand to register GUI
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        }
    }


}
