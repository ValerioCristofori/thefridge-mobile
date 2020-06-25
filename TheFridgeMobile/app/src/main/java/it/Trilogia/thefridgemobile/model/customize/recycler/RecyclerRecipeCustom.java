package it.Trilogia.thefridgemobile.model.customize.recycler;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import it.Trilogia.thefridgemobile.R;
import it.Trilogia.thefridgemobile.activity.recipe.ShowRecipeActivity;
import it.Trilogia.thefridgemobile.model.entity.Recipe;

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
    public void onBindViewHolder(@NonNull RecyclerRecipeCustom.MyViewHolder holder, final int position) {
        //setting image use Picasso for link
        Picasso.with(this.context)
                .load( recipes.get(position).getImage() )
                .into(holder.ivRecipe);

        holder.tvRecipe.setText(recipes.get(position).getTitle());


        //set click on item listener
        //assign onClick method of MyViewHolder
        holder.ibtnRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //remand to list food
                Intent intent = new Intent(context, ShowRecipeActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("recipe", recipes.get(position));
                intent.putExtras( bundle );
                context.startActivity(intent);
            }
        });

        holder.ibtnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //provide a recipe sharing

            }
        });
    }

    @Override
    public int getItemCount() {
        return this.recipes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView ivRecipe;
        TextView tvRecipe;
        ConstraintLayout clRecipe;
        ImageButton ibtnRecipe;
        ImageButton ibtnShare;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivRecipe = itemView.findViewById(R.id.ivRecipe);
            tvRecipe = itemView.findViewById(R.id.tvRecipe);
            clRecipe = itemView.findViewById(R.id.clRecipe);
            ibtnRecipe = itemView.findViewById(R.id.ibtnRecipe);
            ibtnShare = itemView.findViewById(R.id.ibtnShare);

        }
    }
}
