package com.example.sunnyenterprise.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sunnyenterprise.R;
import com.example.sunnyenterprise.adapters.AddToCartAdapter;
import com.example.sunnyenterprise.model.cartListModel.CartList;
import com.example.sunnyenterprise.model.categoryModel.Category;
import com.example.sunnyenterprise.recyclerviewInterface.OnDeleteItemInterface;
import com.example.sunnyenterprise.retrofit.ApiCallInterface;
import com.example.sunnyenterprise.retrofit.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddToCartActivity extends AppCompatActivity implements OnDeleteItemInterface {
    private String TAG = AddToCartActivity.class.getSimpleName();

    RecyclerView productList;
    AddToCartAdapter addToCartAdapter;

    ImageView imageViewbackCart;
    List<CartList> cartLists;
    ApiCallInterface api;
    ProgressDialog progressDialog;

    ImageView clearCartBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_cart);

        imageViewbackCart = findViewById(R.id.imageViewBackfromCart);
        imageViewbackCart.setOnClickListener(view -> onBackPressed());

        productList = findViewById(R.id.addTocartRecyclerView);
        productList.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        productList.setLayoutManager(layoutManager);

        addToCartAdapter = new AddToCartAdapter(this, cartLists, this::deleteItemID);

        api = ApiService.createService(ApiCallInterface.class);

        clearCartBtn = findViewById(R.id.clearCartBtn);
        clearCartBtn.setOnClickListener(view -> {
            clearCartProducts();
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getCartList();
    }

    private void getCartList() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Content Loader");
        progressDialog.setProgress(10);
        progressDialog.setMax(100);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        Call<List<CartList>> call = api.getCartList(1);

        call.enqueue(new Callback<List<CartList>>() {
            @Override
            public void onResponse(Call<List<CartList>> call, Response<List<CartList>> response) {
                cartLists = response.body();
                addToCartAdapter.setData(cartLists);
                productList.setAdapter(addToCartAdapter);
                progressDialog.cancel();
            }

            @Override
            public void onFailure(Call<List<CartList>> call, Throwable t) {
                Toast.makeText(AddToCartActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void clearCartProducts() {
        Call<CartList> deleteCall = api.deleteCartList(1);
        deleteCall.enqueue(new Callback<CartList>() {
            @Override
            public void onResponse(Call<CartList> call, Response<CartList> response) {
                Log.d(TAG, "delete cart products by cat id"+response.code());

            }

            @Override
            public void onFailure(Call<CartList> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });

    }

    @Override
    public void deleteItemID(int id) {
        Call<CartList> deleteCall = api.deleteCartItem(id);
        deleteCall.enqueue(new Callback<CartList>() {
            @Override
            public void onResponse(Call<CartList> call, Response<CartList> response) {
                Log.d(TAG, "deleteItem by id"+response.code());

            }

            @Override
            public void onFailure(Call<CartList> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
    }
}