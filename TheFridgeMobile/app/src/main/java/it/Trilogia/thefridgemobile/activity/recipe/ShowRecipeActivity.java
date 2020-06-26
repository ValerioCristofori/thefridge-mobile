package it.Trilogia.thefridgemobile.activity.recipe;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
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
        setContentView(R.layout.layout_recipe_description);

        new Holder( this );

    }

    class Holder implements View.OnClickListener{

        private Context context;
        private ImageView ivRecipe;
        private TextView tvTitle;
        private ListView lvIngredientsUsed;
        private ListView lvIngredientsMissed;

        Holder(Context context){
            this.context = context;

            // init views
            this.ivRecipe = findViewById(R.id.ivRecipe);
            this.tvTitle = findViewById(R.id.tvTitle);
            Button btnLink = findViewById(R.id.btnLink);
            lvIngredientsUsed = findViewById(R.id.lvIngredientsUsed);
            lvIngredientsMissed = findViewById(R.id.lvIngredientsMissed);

            //set listener
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
            ArrayList<String> listIngredientsUsed = this.bld_ingredients_string( recipe.getUsedIngredients());
            ArrayList<String> listIngredientsMissed = this.bld_ingredients_string( recipe.getMissedIngredients());
            tvTitle.setText(recipe.getTitle());
            ArrayAdapter<String> adapterUsed = new ArrayAdapter<>(this.context, R.layout.custom_text_view,  listIngredientsUsed);
            ArrayAdapter<String> adapterMissed = new ArrayAdapter<>(this.context, R.layout.custom_text_view,  listIngredientsMissed);

            Picasso.with(this.context)
                    .load( recipe.getImage() )
                    .into( ivRecipe );

            lvIngredientsUsed.setAdapter(adapterUsed);
            lvIngredientsMissed.setAdapter(adapterMissed);
        }

        private ArrayList<String> bld_ingredients_string( ArrayList<Food> ingredients ) {
            ArrayList<String> listIngredients = new ArrayList<>();
            for( Food food : ingredients  ){
                listIngredients.add(String.format("• %s", food.getName()));
            }
            return listIngredients;
        }

        @Override
        public void onClick(View v) {
            switch(v.getId()){

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
