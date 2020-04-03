package it.valeriocristofori.thefridgemobile.activity.sign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import it.valeriocristofori.thefridgemobile.R;
import it.valeriocristofori.thefridgemobile.activity.home.HomeActivity;
import it.valeriocristofori.thefridgemobile.controller.LoginController;
import it.valeriocristofori.thefridgemobile.controller.SyntaxValidation;
import it.valeriocristofori.thefridgemobile.db.init.DatabaseHelper;
import it.valeriocristofori.thefridgemobile.model.entity.Food;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Food> listFood;
    private DatabaseHelper db;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = DatabaseHelper.getDatabaseInstance(getApplicationContext());

        //create this.Holder
        Holder holder = new Holder();



    }

    class Holder implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
        private EditText tfUsername;
        private EditText tfPassword;
        private Button btnLogin;
        private Button btnSignup;
        private CheckBox cbRemember;

        public Holder(){
            //init login button
            this.btnLogin = findViewById(R.id.btnLogin);
            //init sign up button
            this.btnSignup = findViewById(R.id.btnSignup);
            //binding xml components and java components
            this.tfUsername = findViewById(R.id.tfUsername);
            this.tfPassword = findViewById(R.id.tfPassword);
            this.cbRemember = findViewById(R.id.cbRemember);

            //try to remember me status
            preferences = getSharedPreferences( "checkbox", MODE_PRIVATE);
            editor = preferences.edit();
            this.trylogin();

            //assign click listener
            this.btnLogin.setOnClickListener(this);
            this.btnSignup.setOnClickListener(this);
            this.cbRemember.setOnCheckedChangeListener(this);

        }

        private void trylogin() {
            String res = preferences.getString("remember", "");
            if( res.equals("true")){
                //automatic login
                String username = preferences.getString("username", "");
                String password = preferences.getString("password", "");

                Log.e("username", username);
                Log.e("password", password);

                LoginController loginController = new LoginController();
                if( loginController.isValidUser( username, password ) ) {
                    //remand home GUI
                    startActivity(new Intent(MainActivity.this, HomeActivity.class));

                }
             }
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
                    this.displayErrorMessage("Username wrong");
                    return;
                }
                if( !sv.validSyntaxPassword(tfPassword.getText().toString()) ){
                    //launch toast for pass error
                    this.displayErrorMessage("Password wrong");
                    return;
                }
                LoginController loginController = new LoginController();
                if( loginController.isValidUser( tfUsername.getText().toString(), tfPassword.getText().toString() )) {

                    if(preferences.getString("remember", "").equals("true")){ //if the checkbox is checked
                        //put username and pass in the shared preferences
                        //not good in the point of view of security ---> pass not in md5()
                        editor.putString( "username", tfUsername.getText().toString() );
                        editor.putString( "password", tfPassword.getText().toString() );
                        editor.commit();
                    }

                    //remand home GUI
                    startActivity(new Intent(MainActivity.this, HomeActivity.class));

                }else{
                    this.displayErrorMessage("Username/Password not valid");
                    return;
                }

            }
            else if(v.getId() == R.id.btnSignup){
                //remand to register GUI
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        }



        private void displayErrorMessage( String message ){
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

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if( buttonView.isChecked() ){

                editor.putString( "remember", "true");
                editor.commit();

            }else{

                editor.putString( "remember", "false");
                editor.commit();
            }
        }
    }


}
