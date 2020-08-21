package com.example.sunnyenterprise.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.sunnyenterprise.R;
import com.example.sunnyenterprise.adapters.AddToCartAdapter;

import java.util.ArrayList;
import java.util.List;

public class AddToCartActivity extends AppCompatActivity {
    RecyclerView productList;
    List<String> titles;
    List<Integer> images;
    AddToCartAdapter addToCartAdapter;

    ImageView imageViewbackCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_cart);

        productList = findViewById(R.id.addTocartRecyclerView);
        titles = new ArrayList<>();
        images = new ArrayList<>();

        titles.add("First product");
        titles.add("Second product");
        titles.add("Third product");
        titles.add("Fourth product");
        titles.add("Fifth product");
        titles.add("Sixth product");

        images.add(R.drawable.catalog);
        images.add(R.drawable.catalog);
        images.add(R.drawable.catalog);
        images.add(R.drawable.catalog);
        images.add(R.drawable.catalog);
        images.add(R.drawable.catalog);
        images.add(R.drawable.catalog);

        addToCartAdapter = new AddToCartAdapter(titles, images, this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        productList.setLayoutManager(gridLayoutManager);
        productList.setAdapter(addToCartAdapter);

        imageViewbackCart = findViewById(R.id.imageViewBackfromCart);
        imageViewbackCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}