package it.valeriocristofori.thefridgemobile.activity.sign;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import it.valeriocristofori.thefridgemobile.R;
import it.valeriocristofori.thefridgemobile.activity.home.HomeActivity;
import it.valeriocristofori.thefridgemobile.controller.RegistrationController;
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
                    this.displayErrorMessage("Username wrong");
                    return;
                }
                if( !sv.validSyntaxEmail(tfEmail.getText().toString()) ){
                    //launch toast for email error
                    this.displayErrorMessage("Email wrong");
                    return;
                }
                if( !sv.validSyntaxPassword(tfPassword.getText().toString()) ){
                    //launch toast for pass error
                    this.displayErrorMessage("Password wrong");
                    return;
                }

                RegistrationController registrationController = new RegistrationController();
                if( registrationController.isValidUsername(tfUsername.getText().toString()) ){
                    //all syntax error verified
                    try {
                        registrationController.registration( tfUsername.getText().toString(),tfPassword.getText().toString(),tfEmail.getText().toString() );
                        //remand home GUI
                        startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                else{
                    this.displayErrorMessage("Username already used");
                    return;
                }


            }

        }

        private void displayErrorMessage( String message ){
            //duplicated codes
            //refactor this in the ToastCustom class!

            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom_alert_layout,
                    (ViewGroup) findViewById(R.id.custom_toast_container));

            TextView text = (TextView) layout.findViewById(R.id.text);
            text.setText(message);


            Toast toast = new Toast(getApplicationContext());
            toast.setGravity(Gravity.TOP, 0, 0);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(layout);
            toast.show();

        }


    }





}
