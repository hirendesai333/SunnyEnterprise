package com.example.sunnyenterprise.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sunnyenterprise.R;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

public class ProductDetailsActivity extends AppCompatActivity {

    SliderLayout sliderLayout;

    TextView textView;

    Button addtocartButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        //        Toolbar toolbar = findViewById(R.id.toolBar);

        Intent i = getIntent();
        String title = i.getStringExtra("productTitle");
        /*toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        toolbar.setTitle(title);*/

        textView = findViewById(R.id.textViewproductDetails);
        textView.setText(title);

//        getSupportActionBar().setTitle(title);

        //for auto imageslider
        sliderLayout = findViewById(R.id.productImageSlider);
        sliderLayout.setIndicatorAnimation(SliderLayout.Animations.SLIDE); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
//        sliderLayout.setScrollTimeInSec(5);

        setSliderViews();

        addtocartButton = findViewById(R.id.addTocartBtn);
        addtocartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cartIntent = new Intent(getApplicationContext(), AddToCartActivity.class);
                startActivity(cartIntent);
            }
        });

        ImageView imageView = findViewById(R.id.imageViewProductDetailsback);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void setSliderViews() {
        for (int i = 0; i <= 1; i++) {
            SliderView sliderView = new SliderView(this);
            switch (i) {
                case 0:
                    sliderView.setImageUrl("https://www.americommerce.com/images/X-product-pages-that-make-us-want-to-buy.png");
//                    sliderView.setImageDrawable(R.drawable.shirt);
                    break;
            }

            sliderView.setImageScaleType(ImageView.ScaleType.FIT_CENTER);
            sliderView.setDescription("Note: ");
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    //perform onclick event
                }
            });
            sliderLayout.addSliderView(sliderView);

        }


    }
}