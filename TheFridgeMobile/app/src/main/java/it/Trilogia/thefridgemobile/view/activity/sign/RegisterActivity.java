package it.Trilogia.thefridgemobile.view.activity.sign;

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


import it.Trilogia.thefridgemobile.R;
import it.Trilogia.thefridgemobile.view.activity.tutorial.TutorialActivity;
import it.Trilogia.thefridgemobile.controller.RegistrationController;
import it.Trilogia.thefridgemobile.controller.SyntaxValidation;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_signup);
        new Holder();
    }

    class Holder implements View.OnClickListener{
        private EditText tfUsername;
        private EditText tfEmail;
        private EditText tfPassword;

        Holder(){
            //binding xml components and java components
            this.tfUsername = findViewById(R.id.tfUsername);
            this.tfEmail = findViewById(R.id.tfEmail);
            this.tfPassword = findViewById(R.id.tfPassword);
            Button btnSignup = findViewById(R.id.btnSignup);

            //assign click listener
            btnSignup.setOnClickListener(this);

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
                    this.displayErrorMessage(getString(R.string.error_message_username));
                    return;
                }
                if( !sv.validSyntaxEmail(tfEmail.getText().toString()) ){
                    //launch toast for email error
                    this.displayErrorMessage(getString(R.string.error_message_email));
                    return;
                }
                if( !sv.validSyntaxPassword(tfPassword.getText().toString()) ){
                    //launch toast for pass error
                    this.displayErrorMessage(getString(R.string.error_message_password));
                    return;
                }

                RegistrationController registrationController = new RegistrationController();
                if( registrationController.isValidUsername(tfUsername.getText().toString()) ){
                    //all syntax error verified
                    try {
                        registrationController.registration( tfUsername.getText().toString(),tfPassword.getText().toString(),tfEmail.getText().toString() );

                        //remand to the tutorial activity
                        startActivity(new Intent(RegisterActivity.this, TutorialActivity.class));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                else{
                    this.displayErrorMessage(getString(R.string.error_message_already_used));
                }

            }

        }

        private void displayErrorMessage( String message ){
            //duplicated codes
            //refactor this in the ToastCustom class!

            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom_layout_alert,
                    (ViewGroup) findViewById(R.id.custom_toast_container));

            TextView text = layout.findViewById(R.id.text);
            text.setText(message);

            Toast toast = new Toast(getApplicationContext());
            toast.setGravity(Gravity.TOP, 0, 0);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(layout);
            toast.show();

        }


    }

}
