package it.valeriocristofori.thefridgemobile.model.customize.recycler;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import it.valeriocristofori.thefridgemobile.R;
import it.valeriocristofori.thefridgemobile.controller.ViewFridgeController;
import it.valeriocristofori.thefridgemobile.implementation.instance.Instance;
import it.valeriocristofori.thefridgemobile.model.entity.Food;

public class RecyclerFridgeCustom extends RecyclerView.Adapter<RecyclerFridgeCustom.MyViewHolder> {

    private Context context;
    private ArrayList<Food> listFood;
    private int images[] = Instance.getSingletonInstance().getImages();


    public RecyclerFridgeCustom(Context context, ArrayList<Food> listFood ) {
        this.context = context;
        this.listFood = listFood;
    }

    @NonNull
    @Override
    public RecyclerFridgeCustom.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.food_box_for_delete,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerFridgeCustom.MyViewHolder holder, final int position) {
        holder.tvFridgeFood.setText(listFood.get(position).getName());
        holder.ivFridgeFood.setImageResource(this.selectImage(listFood.get(position)));

        //setting the click and long click event
        holder.mainLayout.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                holder.ibtnDelete.setVisibility(View.VISIBLE);
                //if return true not triggered the on click event
                return true;
            }
        });

        holder.mainLayout.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                if(holder.ibtnDelete.getVisibility() == View.VISIBLE ){
                    holder.ibtnDelete.setVisibility(View.INVISIBLE);
                }
            }
        });

        //setting the click event on delete button
        holder.ibtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.ibtnDelete.setVisibility(View.INVISIBLE);
                //call query to db for delete
                ViewFridgeController viewFridgeController = new ViewFridgeController();
                viewFridgeController.deleteFood(listFood.get(position));

                //removing item
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, listFood.size());


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
        ImageButton ibtnDelete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvFridgeFood = itemView.findViewById(R.id.tvRecipe);
            ivFridgeFood = itemView.findViewById(R.id.ivRecipe);
            ibtnDelete = itemView.findViewById(R.id.ibtnDelete);
            mainLayout = itemView.findViewById(R.id.mainLayout);


        }
    }


    private int selectImage(Food food) {
        switch(food.getCategory()){
            case "fruit": return images[0];
            case "vegetable": return images[1];
            case "meat": return images[2];
            case "fish": return images[3];
            case "cereal_flour": return images[4];
            case "pasta_bread": return images[5];
            case "legumes": return images[6];
            case "mushrooms": return images[7];
            case "dairy_product": return images[8];
            case "dessert": return images[9];
            case "spices": return images[10];
            case "sauces": return images[11];
            case "beverages": return images[12];
            case "vegan": return images[13];
            case "oils": return images[14];
            default: return images[0];
        }
    }



}
