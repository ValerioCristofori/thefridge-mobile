package it.valeriocristofori.thefridgemobile.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import it.valeriocristofori.thefridgemobile.R;

public class ToastCustom extends AppCompatActivity {

    public void buildToast(Toast toast, String message ){
        LayoutInflater inflater = getLayoutInflater(); // this call to getLayoutInflater gives errors ----> build a Activity manager
        View layout = inflater.inflate(R.layout.custom_alert_layout,
                (ViewGroup) findViewById(R.id.custom_toast_container));

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText(message);
        toast.setView(layout);
    }

}
