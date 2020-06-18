package it.Trilogia.thefridgemobile.model.customize.recycler;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import it.Trilogia.thefridgemobile.R;
import it.Trilogia.thefridgemobile.controller.AddFoodController;
import it.Trilogia.thefridgemobile.model.entity.Food;

public class RecyclerSearchFoodCustom extends RecyclerView.Adapter<RecyclerSearchFoodCustom.MyViewHolder> {

    private Context context;
    private ArrayList<Food> listFood;
    private int images[];


    public RecyclerSearchFoodCustom(Context context, ArrayList<Food> listFood, int images[]){
        this.context = context;
        this.listFood = listFood;
        this.images = images;
    }

    @NonNull
    @Override
    public RecyclerSearchFoodCustom.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.food_box_for_add,parent,false);

        return new RecyclerSearchFoodCustom.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerSearchFoodCustom.MyViewHolder holder, final int position) {
        holder.tvFridgeFood.setText(listFood.get(position).getName());
        holder.ivFridgeFood.setImageResource(images[position]);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //create calendar
                Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                DatePickerDialog dpd = new DatePickerDialog( context ,android.R.style.Theme_DeviceDefault_Light_Dialog, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int mYear, int mMonth, int mDay) {

                        String expirationDate = sdf.format(new Date(mYear-1900,mMonth,mDay));
                        //call query to insert food
                        String foodName = listFood.get(position).getName();
                        AddFoodController addFoodController = new AddFoodController();
                        addFoodController.insertFood(foodName,expirationDate);

                        //add the notification
                        //when delete a food delete the related notification


                    }


                }, year, month, day);

                //when click on skip button
                dpd.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {

                        String expirationDate = "-";
                        String foodName = listFood.get(position).getName();
                        AddFoodController addFoodController = new AddFoodController();
                        addFoodController.insertFood(foodName,expirationDate);
                    }
                });

                dpd.show();
                dpd.getButton(DatePickerDialog.BUTTON_NEGATIVE).setText("skip");
            }
        });

    }

    @Override
    public int getItemCount() {
            return this.listFood.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvFridgeFood;
        ImageView ivFridgeFood;
        ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvFridgeFood = itemView.findViewById(R.id.tvRecipe);
            ivFridgeFood = itemView.findViewById(R.id.ivRecipe);
            mainLayout = itemView.findViewById(R.id.mainLayout);

        }
    }
}
