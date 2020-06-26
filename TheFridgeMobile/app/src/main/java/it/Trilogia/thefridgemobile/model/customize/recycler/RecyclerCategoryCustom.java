package it.Trilogia.thefridgemobile.model.customize.recycler;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import it.Trilogia.thefridgemobile.R;
import it.Trilogia.thefridgemobile.activity.addfood.ListFoodActivity;

public class RecyclerCategoryCustom extends RecyclerView.Adapter<RecyclerCategoryCustom.MyViewHolder> {

    private String data[];
    private int images[];
    private Context context;

    public RecyclerCategoryCustom(Context context, String str[], int images[]) {
        this.context = context;
        this.data = str;
        this.images = images;
    }

    @NonNull
    @Override
    public RecyclerCategoryCustom.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.cardview_category_row,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,final int position) {
        holder.tvCategory.setText(data[position]);
        holder.ivCategory.setImageResource(images[position]);

        //assign onClick method of MyViewHolder
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //remand to list food
                Intent intent = new Intent(context, ListFoodActivity.class);
                intent.putExtra("data", data[position]);
                intent.putExtra("image", images[position]);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvCategory;
        ImageView ivCategory;
        ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCategory = itemView.findViewById(R.id.tvSpecificCategory);
            ivCategory = itemView.findViewById(R.id.ivCategory);
            mainLayout = itemView.findViewById(R.id.mainLayout);

        }


    }
}
