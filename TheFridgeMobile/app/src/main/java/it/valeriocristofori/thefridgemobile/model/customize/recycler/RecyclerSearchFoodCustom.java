package it.valeriocristofori.thefridgemobile.model.customize.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import it.valeriocristofori.thefridgemobile.R;
import it.valeriocristofori.thefridgemobile.activity.addfood.ListFoodActivity;
import it.valeriocristofori.thefridgemobile.controller.AddFoodController;
import it.valeriocristofori.thefridgemobile.model.entity.Food;

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
        View view = layoutInflater.inflate(R.layout.food_box_cardview,parent,false);

        return new RecyclerSearchFoodCustom.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerSearchFoodCustom.MyViewHolder holder, final int position) {
        holder.tvFridgeFood.setText(listFood.get(position).getName());
        holder.ivFridgeFood.setImageResource(images[position]);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add food in current fridge
                Toast.makeText(context, listFood.get(position).getName(), Toast.LENGTH_SHORT).show();

                //call query to insert food
                String foodName = listFood.get(position).getName();
                AddFoodController addFoodController = new AddFoodController();
                addFoodController.insertFood(foodName);
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
