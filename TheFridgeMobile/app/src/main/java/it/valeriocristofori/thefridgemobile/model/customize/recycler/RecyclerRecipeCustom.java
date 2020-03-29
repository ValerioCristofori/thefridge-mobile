package it.valeriocristofori.thefridgemobile.model.customize.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import it.valeriocristofori.thefridgemobile.R;
import it.valeriocristofori.thefridgemobile.model.entity.Recipe;

public class RecyclerRecipeCustom extends RecyclerView.Adapter<RecyclerRecipeCustom.MyViewHolder> {

    private Context context;
    private ArrayList<Recipe> recipes;

    public RecyclerRecipeCustom(Context context , ArrayList<Recipe> recipes ){
        this.context = context;
        this.recipes = recipes;
    }

    @NonNull
    @Override
    public RecyclerRecipeCustom.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.recipe_cardview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerRecipeCustom.MyViewHolder holder, int position) {
        //holder.ivRecipe.setImageResource(recipes.get(position).getImage());
        holder.tvRecipe.setText(recipes.get(position).getTitle());

        //set click on item listener
        //.............
    }

    @Override
    public int getItemCount() {
        return this.recipes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView ivRecipe;
        TextView tvRecipe;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivRecipe = itemView.findViewById(R.id.ivRecipe);
            tvRecipe = itemView.findViewById(R.id.tvRecipe);
        }
    }
}
