package it.valeriocristofori.thefridgemobile.activity.recipe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import it.valeriocristofori.thefridgemobile.R;
import it.valeriocristofori.thefridgemobile.controller.ChooseRecipesController;
import it.valeriocristofori.thefridgemobile.model.entity.Recipe;

public class ShowRecipeActivity extends AppCompatActivity {

    private Recipe recipe;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_description);

        Holder holder = new Holder( this );

    }

    class Holder implements View.OnClickListener{

        private Context context;
        private ImageView ivRecipe;
        private TextView tvIngredients;
        private TextView tvDescription;
        private TextView tvTitle;
        private ImageButton ibtnLeftArrow;

        public Holder(Context context){
            this.context = context;

            // init views
            this.ivRecipe = findViewById(R.id.ivRecipe);
            this.tvTitle = findViewById(R.id.tvTitle);
            this.tvDescription = findViewById(R.id.tvDescription);
            this.tvIngredients = findViewById(R.id.tvIngredients);
            this.ibtnLeftArrow = findViewById(R.id.ibtnLeftArrow);

            this.getData();
            this.setData();

            //set listener
            this.ibtnLeftArrow.setOnClickListener( this );


        }

        private void getData() {
            Bundle bundle = getIntent().getExtras();
            recipe = (Recipe) bundle.getSerializable("recipe");
        }

        private void setData() {
            tvTitle.setText(recipe.getTitle());
            tvIngredients.setText((CharSequence) recipe.getIngredients());
            tvDescription.setText(recipe.getDescription());

            Picasso.with(this.context)
                    .load( recipe.getImage() )
                    .into( ivRecipe );

        }

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.ibtnLeftArrow:
                    Intent intent = new Intent( v.getContext(), ChooseRecipesController.class);
                    startActivityForResult( intent, 0);
                    break;
            }
        }

    }
}
