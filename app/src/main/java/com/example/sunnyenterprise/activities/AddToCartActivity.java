package com.example.sunnyenterprise.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sunnyenterprise.R;
import com.example.sunnyenterprise.adapters.AddToCartAdapter;
import com.example.sunnyenterprise.model.cartListModel.CartList;
import com.example.sunnyenterprise.model.categoryModel.Category;
import com.example.sunnyenterprise.retrofit.ApiCallInterface;
import com.example.sunnyenterprise.retrofit.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddToCartActivity extends AppCompatActivity {
    RecyclerView productList;
    AddToCartAdapter addToCartAdapter;

    ImageView imageViewbackCart;
    List<CartList> cartLists;
    ApiCallInterface api;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_cart);

        productList = findViewById(R.id.addTocartRecyclerView);
        productList.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        productList.setLayoutManager(layoutManager);

        addToCartAdapter = new AddToCartAdapter(this, cartLists);

        api = ApiService.createService(ApiCallInterface.class);

        Call<List<CartList>> call = api.getCartList(1);

        call.enqueue(new Callback<List<CartList>>() {
            @Override
            public void onResponse(Call<List<CartList>> call, Response<List<CartList>> response) {
                cartLists = response.body();
                addToCartAdapter.setData(cartLists);
                productList.setAdapter(addToCartAdapter);

            }

            @Override
            public void onFailure(Call<List<CartList>> call, Throwable t) {
                Toast.makeText(AddToCartActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });

//        getCartList();

        imageViewbackCart = findViewById(R.id.imageViewBackfromCart);
        imageViewbackCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

/*    private void getCartList() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Content Loader");
        progressDialog.setProgress(10);
        progressDialog.setMax(100);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        Call<List<CartList>> call = api.getCartList();

        call.enqueue(new Callback<List<CartList>>() {
            @Override
            public void onResponse(Call<List<CartList>> call, Response<List<CartList>> response) {
                progressDialog.cancel();
                cartLists = response.body();
                addToCartAdapter.setData(cartLists);
                productList.setAdapter(addToCartAdapter);

            }

            @Override
            public void onFailure(Call<List<CartList>> call, Throwable t) {
                Toast.makeText(AddToCartActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }*/
}