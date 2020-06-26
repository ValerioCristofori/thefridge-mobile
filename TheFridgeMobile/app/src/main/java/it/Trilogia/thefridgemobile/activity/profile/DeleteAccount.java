package it.Trilogia.thefridgemobile.activity.profile;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import it.Trilogia.thefridgemobile.R;
import it.Trilogia.thefridgemobile.activity.sign.MainActivity;
import it.Trilogia.thefridgemobile.controller.DeleteAccountController;

public class DeleteAccount extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_layout_delete_account);

        //creazione pop up
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .9), (int) (height * .4));

        new Holder();

    }

    class Holder implements View.OnClickListener {

        Holder() {

            Button btnYes = findViewById(R.id.btnYes);
            Button btnNo = findViewById(R.id.btnNo);

            btnYes.setOnClickListener(this);
            btnNo.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            switch (v.getId()) {

                case R.id.btnNo:
                    Intent intent = new Intent(v.getContext(), ProfileActivity.class);
                    startActivityForResult(intent, 0);
                    break;

                case R.id.btnYes:
                    //delete user from DB
                    DeleteAccountController deleteAccountController;
                    deleteAccountController = new DeleteAccountController();
                    deleteAccountController.deleteAccount();
                    //return to register menu
                    intent = new Intent(v.getContext(), MainActivity.class);
                    startActivityForResult(intent, 0);
                    break;
            }
        }
    }

}
    
