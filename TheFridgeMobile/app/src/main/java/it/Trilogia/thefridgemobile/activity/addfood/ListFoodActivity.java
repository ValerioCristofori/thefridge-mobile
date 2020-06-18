package it.Trilogia.thefridgemobile.activity.addfood;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import it.Trilogia.thefridgemobile.R;
import it.Trilogia.thefridgemobile.controller.AddFoodController;
import it.Trilogia.thefridgemobile.controller.NotificationController;
import it.Trilogia.thefridgemobile.model.utility.ListAllFood;

public class ListFoodActivity extends AppCompatActivity {

    private String category;
    private int imageOfCategory;
    private ArrayList arrayList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_food_layout);

        new Holder(this);
    }

    class Holder implements View.OnClickListener, AdapterView.OnItemClickListener {

        Context context;
        ImageButton ibtnLeftArrow;
        ImageView ivSpecificCategory;
        TextView tvSpecificCategory;
        ListView lvFood;
        Intent intent;
        Calendar calendar;
        DatePickerDialog dpd;
        String expirationDate;
        SimpleDateFormat sdf;
        String foodName;

        Holder(Context context){

            this.context = context;
            ibtnLeftArrow = findViewById(R.id.ibtnLeftArrow);
            ivSpecificCategory = findViewById(R.id.ivSpecificCategory);
            tvSpecificCategory = findViewById(R.id.tvSpecificCategory);
            lvFood = findViewById(R.id.lvFood);

            this.getData();
            this.setData();

            //build adapter
            ArrayAdapter arrayAdapter = new ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, arrayList);
            lvFood.setAdapter(arrayAdapter);

            //assign click listener
            ibtnLeftArrow.setOnClickListener(this);
            lvFood.setOnItemClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.ibtnLeftArrow) {
                intent = new Intent(v.getContext(), AddFoodActivity.class);
                startActivityForResult(intent, 0);
            }
        }

        @SuppressLint("SimpleDateFormat")
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

            //create calendar
            calendar = Calendar.getInstance();
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int month = calendar.get(Calendar.MONTH);
            int year = calendar.get(Calendar.YEAR);

            sdf = new SimpleDateFormat("yyyy-MM-dd");

            dpd = new DatePickerDialog(ListFoodActivity.this,android.R.style.Theme_DeviceDefault_Light_Dialog, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int mYear, int mMonth, int mDay) {

                    Date date = new Date(mYear-1900,mMonth,mDay);
                    expirationDate = sdf.format(date);
                    //call query to insert food
                    foodName = (String) arrayList.get(position);
                    AddFoodController addFoodController = new AddFoodController();
                    addFoodController.insertFood(foodName,expirationDate);

                    //add the notification
                    NotificationController notificationController = new NotificationController();
                    notificationController.createNotification(context);
                    //when delete a food delete the related notification


                }


            }, year, month, day);

            //when click on skip button
            dpd.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialogInterface) {

                    expirationDate = "-";
                    foodName = (String) arrayList.get(position);
                    AddFoodController addFoodController = new AddFoodController();
                    addFoodController.insertFood(foodName,expirationDate);
                }
            });

            dpd.show();
            dpd.getButton(DatePickerDialog.BUTTON_NEGATIVE).setText(R.string.skip_button_calendar);
            dpd.getButton(DatePickerDialog.BUTTON_POSITIVE).setText(R.string.set_button);

        }

        private void getData(){
            category = getIntent().getStringExtra("data");
            Log.d("tag",category);
            imageOfCategory = getIntent().getIntExtra("image", 1);
        }

        private void setData(){
            arrayList = (ArrayList)ListAllFood.getCategory(category);
            tvSpecificCategory.setText(category);
            ivSpecificCategory.setImageResource(imageOfCategory);
        }

    }

}
