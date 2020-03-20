package it.valeriocristofori.thefridgemobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import it.valeriocristofori.thefridgemobile.R;
import it.valeriocristofori.thefridgemobile.controller.SyntaxValidation;
import it.valeriocristofori.thefridgemobile.model.ToastFactory;

public class MainActivity extends AppCompatActivity {

    //change here and in Register Activity text input layout and text fields consulting https://www.youtube.com/watch?v=EVgxH2UhyQk

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create this.Holder
        Holder holder = new Holder();

    }

    class Holder implements View.OnClickListener{
        private TextInputEditText tfUsername;
        private TextInputEditText tfPassword;
        private Button btnLogin;
        private Button btnSignup;

        public Holder(){
            //init login button
            this.btnLogin = (Button)findViewById(R.id.btnLogin);
            //init signup button
            this.btnSignup = (Button)findViewById(R.id.btnSignup);
            //binding xml components and java components
            this.tfUsername = (TextInputEditText)findViewById(R.id.tfUsername);
            this.tfPassword = (TextInputEditText)findViewById(R.id.tfPassword);

            //assign click listener
            this.btnLogin.setOnClickListener(this);
            this.btnSignup.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.btnLogin){
                //login use case

                //syntax control
                //instance controller for input
                SyntaxValidation sv = new SyntaxValidation();
                if( !sv.validSyntaxUsername(tfUsername.getText().toString()) ){
                    //launch toast for username error
                    ToastFactory toastFactory = new ToastFactory();
                    toastFactory.displayUsernameError();
                    return;
                }
                if( !sv.validSyntaxPassword(tfPassword.getText().toString()) ){
                    //launch toast for pass error
                    ToastFactory toastFactory = new ToastFactory();
                    toastFactory.displayPasswordError();
                    return;
                }

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
