package it.valeriocristofori.thefridgemobile.model.customize;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

import it.valeriocristofori.thefridgemobile.R;

public class BoxView extends View {

    public BoxView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init(context, attrs, 0);

    }

    private void init(Context context,AttributeSet attrs, int defStyleAttr) {
        /*
        inflate(context, R.layout.custom_box_view_layout, this);

        ImageView imageView = (ImageView) findViewById(R.id.image);
        TextView textView = (TextView) findViewById(R.id.caption);

        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.BoxView);
        imageView.setImageDrawable(R.drawable.aggiungi_carrello_icon);
        textView.setText("prova");
        attributes.recycle();
        */
    }
}
