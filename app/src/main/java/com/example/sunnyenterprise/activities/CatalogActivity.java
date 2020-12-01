package com.example.sunnyenterprise.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sunnyenterprise.R;
import com.example.sunnyenterprise.adapters.CatalogAdapter;
import com.example.sunnyenterprise.model.categoryModel.Category;
import com.example.sunnyenterprise.retrofit.ApiCallInterface;
import com.example.sunnyenterprise.retrofit.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CatalogActivity extends AppCompatActivity {
    RecyclerView dataList;
    List<String> titles;
    List<Integer> images;
    CatalogAdapter catalogAdapter;

    TextView textView;

    List<Category> categoryList;

    ApiCallInterface api;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        Intent i = getIntent();
        String title = i.getStringExtra("title");

        textView = findViewById(R.id.catalogTitle);
        textView.setText(title);

        dataList = findViewById(R.id.catalogRecyclerView);

        dataList.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        dataList.setLayoutManager(layoutManager);

        catalogAdapter = new CatalogAdapter(this, categoryList);

        api = ApiService.createService(ApiCallInterface.class);

        getCategories();

        ImageView imageView = findViewById(R.id.backImageCatalog);
        imageView.setOnClickListener(view -> onBackPressed());

        ImageView home = findViewById(R.id.homeButton);
        home.setOnClickListener(v -> {
            startActivity(new Intent(this, HomeActivity.class));
        });
    }

    private void getCategories() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgress(10);
        progressDialog.setMax(100);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        Intent i = getIntent();
        String companyID = i.getStringExtra("companyid");

        Call<List<Category>> call = api.getCategories(Integer.parseInt(companyID));

        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                progressDialog.cancel();
                categoryList = response.body();
                catalogAdapter.setData(categoryList);
                dataList.setAdapter(catalogAdapter);
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Toast.makeText(CatalogActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}