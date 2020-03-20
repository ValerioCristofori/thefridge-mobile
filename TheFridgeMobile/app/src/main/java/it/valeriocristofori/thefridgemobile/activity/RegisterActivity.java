package it.valeriocristofori.thefridgemobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import it.valeriocristofori.thefridgemobile.R;
import it.valeriocristofori.thefridgemobile.controller.SyntaxValidation;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        Holder holder = new Holder();
    }

    class Holder implements View.OnClickListener{
        private EditText tfUsername;
        private EditText tfEmail;
        private EditText tfPassword;
        private Button btnSignup;


        public Holder(){
            //binding xml components and java components
            this.tfUsername = (EditText)findViewById(R.id.tfUsername);
            this.tfEmail = (EditText)findViewById(R.id.tfEmail);
            this.tfPassword = (EditText)findViewById(R.id.tfPassword);
            this.btnSignup = (Button)findViewById(R.id.btnSignup);

            //assign click listener
            this.btnSignup.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            if( v.getId() == R.id.btnSignup){
                //registration use case

                //syntax control
                //instance controller for input
                SyntaxValidation sv = new SyntaxValidation();
                if( !sv.validSyntaxUsername(tfUsername.getText().toString()) ){
                    //launch toast for username error
                    this.displayUsernameError();
                    return;
                }
                if( !sv.validSyntaxEmail(tfEmail.getText().toString()) ){
                    //launch toast for email error
                    this.displayEmailError();
                    return;
                }
                if( !sv.validSyntaxPassword(tfPassword.getText().toString()) ){
                    //launch toast for pass error
                    this.displayPasswordError();
                    return;
                }

                //all syntax error verified
                //remand home GUI
                startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
            }

        }

        private void displayUsernameError(){
            CharSequence text = "Hello toast!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(RegisterActivity.this , text, duration);
            toast.setGravity(Gravity.TOP, 0, 0);
            toast.show();

        }

        private void displayEmailError(){
            CharSequence text = "Hello toast!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(RegisterActivity.this , text, duration);
            toast.setGravity(Gravity.TOP, 0, 0);
            toast.show();

        }

        private void displayPasswordError(){
            CharSequence text = "Hello toast!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(RegisterActivity.this , text, duration);
            toast.setGravity(Gravity.TOP, 0, 0);
            toast.show();

        }

    }





}
