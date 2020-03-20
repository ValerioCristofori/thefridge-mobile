package it.valeriocristofori.thefridgemobile.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import it.valeriocristofori.thefridgemobile.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init login button
        Button btn_login = (Button)findViewById(R.id.btn_login);

        //init signup button
        Button btn_signup = (Button)findViewById(R.id.btn_signup);



        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //take text from edit texts
                //control credentials


                //goto home GUI
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
            }
        });

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //remand to register GUI
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });


    }


}
