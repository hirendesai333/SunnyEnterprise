package com.example.sunnyenterprise.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sunnyenterprise.R;
import com.example.sunnyenterprise.adapters.ProductAdapter;
import com.example.sunnyenterprise.model.productModel.Product;
import com.example.sunnyenterprise.model.productModel.Value;
import com.example.sunnyenterprise.retrofit.ApiCallInterface;
import com.example.sunnyenterprise.retrofit.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductActivity extends AppCompatActivity {
    RecyclerView rvProducts;
    ProductAdapter productAdapter;

    TextView textViewProductTil;

    List<Value> productsList;

    ApiCallInterface api;

    ProgressDialog progressDialog;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        Intent intentget = getIntent();
        String titleProduct = intentget.getStringExtra("titleCatalog");

        textViewProductTil = findViewById(R.id.tvProductTitle);
        textViewProductTil.setText(titleProduct);

        rvProducts = findViewById(R.id.productRecyclerview);

        productAdapter = new ProductAdapter(this, productsList);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        rvProducts.setLayoutManager(gridLayoutManager);

        api = ApiService.createService(ApiCallInterface.class);

        getProducts();

        ImageView imageView = findViewById(R.id.imageViewProductback);
        imageView.setOnClickListener(view -> onBackPressed());
    }

    private void getProducts() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgress(10);
        progressDialog.setMax(100);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        Intent i = getIntent();
        String getCatId = i.getStringExtra("cat_id");

        Call<Product> call = api.getProducts(Integer.parseInt(getCatId), 0, 10000);

        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                progressDialog.cancel();
                productsList = response.body().getValues();
                productAdapter.setData(productsList);
                rvProducts.setAdapter(productAdapter);
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                Toast.makeText(ProductActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.d("onFailure", "onFailure called: " + t.getLocalizedMessage());

            }
        });
    }

}