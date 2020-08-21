package com.example.sunnyenterprise.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.sunnyenterprise.R;
import com.example.sunnyenterprise.adapters.CompanyAdapter;
import com.example.sunnyenterprise.adapters.ProductAdapter;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {
    RecyclerView productList;
    List<String> titles;
    List<Integer> images;
    ProductAdapter productAdapter;

    TextView textViewProductTil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

//        Toolbar toolbarProduct = findViewById(R.id.toolbarProduct);

        Intent intentget = getIntent();
        String titleProduct = intentget.getStringExtra("titleCatalog");

        textViewProductTil = findViewById(R.id.tvProductTitle);
        textViewProductTil.setText(titleProduct);


        productList = findViewById(R.id.productRecyclerview);
        titles = new ArrayList<>();
        images = new ArrayList<>();

        titles.add("First product");
        titles.add("Second product");
        titles.add("Third product");
        titles.add("Fourth product");
        titles.add("Fifth product");
        titles.add("Sixth product");

        images.add(R.drawable.product);
        images.add(R.drawable.product);
        images.add(R.drawable.product);
        images.add(R.drawable.product);
        images.add(R.drawable.product);
        images.add(R.drawable.product);
        images.add(R.drawable.product);

        productAdapter = new ProductAdapter(this, titles, images);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        productList.setLayoutManager(gridLayoutManager);
        productList.setAdapter(productAdapter);

        ImageView imageView = findViewById(R.id.imageViewProductback);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}