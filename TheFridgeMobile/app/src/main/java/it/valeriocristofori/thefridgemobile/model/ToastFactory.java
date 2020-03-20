package it.valeriocristofori.thefridgemobile.model;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import it.valeriocristofori.thefridgemobile.activity.RegisterActivity;

public class ToastFactory extends AppCompatActivity {

    public void displayUsernameError(){
        Context context = getApplicationContext();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }

    public void displayEmailError(){


    }

    public void displayPasswordError(){


    }

}
