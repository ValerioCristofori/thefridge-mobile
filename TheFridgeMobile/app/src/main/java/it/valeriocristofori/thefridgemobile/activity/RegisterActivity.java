package it.valeriocristofori.thefridgemobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import it.valeriocristofori.thefridgemobile.R;
import it.valeriocristofori.thefridgemobile.controller.SyntaxValidation;
import it.valeriocristofori.thefridgemobile.model.ToastFactory;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        Holder holder = new Holder();
    }

    class Holder implements View.OnClickListener{
        private TextInputEditText tfUsername;
        private TextInputEditText tfEmail;
        private TextInputEditText tfPassword;
        private Button btnSignup;


        public Holder(){
            //binding xml components and java components
            this.tfUsername = (TextInputEditText)findViewById(R.id.tfUsername);
            this.tfEmail = (TextInputEditText)findViewById(R.id.tfEmail);
            this.tfPassword = (TextInputEditText)findViewById(R.id.tfPassword);
            this.btnSignup = (Button)findViewById(R.id.btnSignup);

            //assign click listener
            this.btnSignup.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            if( v.getId() == R.id.btnSignup ){
                //registration use case

                //syntax control
                //instance controller for input
                SyntaxValidation sv = new SyntaxValidation();
                if( !sv.validSyntaxUsername(tfUsername.getText().toString()) ){
                    //launch toast for username error
                    ToastFactory toastFactory = new ToastFactory();
                    toastFactory.displayUsernameError();
                    return;
                }
                if( !sv.validSyntaxEmail(tfEmail.getText().toString()) ){
                    //launch toast for email error
                    ToastFactory toastFactory = new ToastFactory();
                    toastFactory.displayEmailError();
                    return;
                }
                if( !sv.validSyntaxPassword(tfPassword.getText().toString()) ){
                    //launch toast for pass error
                    ToastFactory toastFactory = new ToastFactory();
                    toastFactory.displayPasswordError();
                    return;
                }

                //all syntax error verified
                //remand home GUI
                startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
            }

        }


    }





}
