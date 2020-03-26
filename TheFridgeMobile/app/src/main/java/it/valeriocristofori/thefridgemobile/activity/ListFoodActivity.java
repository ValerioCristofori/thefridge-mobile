package it.valeriocristofori.thefridgemobile.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import it.valeriocristofori.thefridgemobile.R;
import it.valeriocristofori.thefridgemobile.model.utility.ListAllFood;

public class ListFoodActivity extends AppCompatActivity {

    private String category;
    private int imageOfCategory;
    private ArrayList arrayList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_food_layout);


        Holder holder = new Holder(this);
    }

    class Holder implements View.OnClickListener{

        ImageButton ibtnLeftArrow;
        ImageView ivSpecificCategory;
        TextView tvSpecificCategory;
        ListView lvFood;
        Context context;
        Intent intent;

        public Holder(Context context){

            ibtnLeftArrow = findViewById(R.id.ibtnLeftArrow);
            ivSpecificCategory = findViewById(R.id.ivSpecificCategory);
            tvSpecificCategory = findViewById(R.id.tvSpecificCategory);
            lvFood = findViewById(R.id.lvFood);

            this.getData();
            this.setData();

            //assign click listener
            ibtnLeftArrow.setOnClickListener(this);

            //build adapter
            ArrayAdapter arrayAdapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, arrayList);
            lvFood.setAdapter(arrayAdapter);
        }

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.ibtnLeftArrow:
                    intent = new Intent(v.getContext(), AddFoodActivity.class);
                    startActivityForResult(intent,0);
                    break;
            }
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
