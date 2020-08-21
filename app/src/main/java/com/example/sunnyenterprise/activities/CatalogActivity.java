package com.example.sunnyenterprise.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sunnyenterprise.R;
import com.example.sunnyenterprise.adapters.CatalogAdapter;

import java.util.ArrayList;
import java.util.List;

public class CatalogActivity extends AppCompatActivity {
    RecyclerView dataList;
    List<String> titles;
    List<Integer> images;
    CatalogAdapter catalogAdapter;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        Toolbar toolbar = findViewById(R.id.toolBar);

        Intent i = getIntent();
        String title = i.getStringExtra("title");

        textView = findViewById(R.id.catalogTitle);
        textView.setText(title);

        dataList = findViewById(R.id.catalogRecyclerView);
        titles = new ArrayList<>();
        images = new ArrayList<>();

        titles.add("First catalog");
        titles.add("Second catalog");
        titles.add("Third catalog");
        titles.add("Fourth catalog");
        titles.add("Fifth catalog");
        titles.add("Sixth catalog");

        images.add(R.drawable.catalog);
        images.add(R.drawable.catalog);
        images.add(R.drawable.catalog);
        images.add(R.drawable.catalog);
        images.add(R.drawable.catalog);
        images.add(R.drawable.catalog);

        catalogAdapter = new CatalogAdapter(this, titles, images);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(catalogAdapter);

        ImageView imageView = findViewById(R.id.backImageCatalog);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();

            }
        });
    }



}