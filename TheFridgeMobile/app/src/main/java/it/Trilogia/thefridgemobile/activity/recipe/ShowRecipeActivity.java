package it.Trilogia.thefridgemobile.activity.recipe;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import it.Trilogia.thefridgemobile.R;
import it.Trilogia.thefridgemobile.model.entity.Food;
import it.Trilogia.thefridgemobile.model.entity.Recipe;

public class ShowRecipeActivity extends AppCompatActivity {

    private Recipe recipe;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_description);

        new Holder( this );

    }

    class Holder implements View.OnClickListener{

        private Context context;
        private ImageView ivRecipe;
        private TextView tvUsedIngredients;
        private TextView tvMissedIngredients;
        private TextView tvTitle;

        Holder(Context context){
            this.context = context;

            // init views
            this.ivRecipe = findViewById(R.id.ivRecipe);
            this.tvTitle = findViewById(R.id.tvTitle);
            Button btnLink = findViewById(R.id.btnLink);
            this.tvUsedIngredients = findViewById(R.id.tvUsedIngredients);
            this.tvMissedIngredients = findViewById(R.id.tvMissedIngredients);
            ImageButton ibtnLeftArrow = findViewById(R.id.ibtnLeftArrow);

            //set listener
            ibtnLeftArrow.setOnClickListener( this );
            btnLink.setOnClickListener( this );

            this.getData();
            this.setData();

        }

        private void getData() {
            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                recipe = (Recipe) bundle.getSerializable("recipe");
            }
        }

        private void setData() {
            tvTitle.setText(recipe.getTitle());
            tvUsedIngredients.setText( this.bld_ingredients_string( recipe.getUsedIngredients() ) );
            tvMissedIngredients.setText( this.bld_ingredients_string( recipe.getMissedIngredients() ) );

            Picasso.with(this.context)
                    .load( recipe.getImage() )
                    .into( ivRecipe );

        }

        private String bld_ingredients_string(ArrayList<Food> usedIngredients) {
        StringBuilder str = new StringBuilder();
        for( Food food : usedIngredients ){
            str.append("- ").append(food.getName()).append("\n");
        }
        Log.e("builder", str.toString());
        return str.toString();
        }

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.ibtnLeftArrow:
                    Intent intent = new Intent( this.context, SearchRecipesActivity.class);
                    startActivity( intent );
                    break;

                case R.id.btnLink:
                    String url = recipe.getSrcLink();

                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                    break;
                    
            }
        }

    }
}
