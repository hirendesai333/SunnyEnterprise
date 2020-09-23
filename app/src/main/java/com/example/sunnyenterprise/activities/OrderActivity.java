package com.example.sunnyenterprise.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sunnyenterprise.R;
import com.example.sunnyenterprise.adapters.OrderAdapter;
import com.example.sunnyenterprise.model.ordersModel.Orders;
import com.example.sunnyenterprise.model.ordersModel.Value;
import com.example.sunnyenterprise.recyclerviewInterface.OnOrderItemClickInterface;
import com.example.sunnyenterprise.retrofit.ApiCallInterface;
import com.example.sunnyenterprise.retrofit.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderActivity extends AppCompatActivity {
    private String TAG = OrderActivity.class.getSimpleName();

    RecyclerView productList;
    OrderAdapter orderAdapter;
    ImageView imageViewbackCart;
    List<Value> ordersList;
    ProgressDialog progressDialog;
    ApiCallInterface api;
    int CustomerId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        SharedPreferences sharedPreferences = getSharedPreferences("sharePrefCustomerId", Context.MODE_PRIVATE);
        CustomerId = sharedPreferences.getInt("customer_id", 0);

        productList = findViewById(R.id.orderRecyclerView);
        productList.setLayoutManager(new LinearLayoutManager(this));

        orderAdapter = new OrderAdapter(ordersList, this);

        api = ApiService.createService(ApiCallInterface.class);

        getOrdersByCustomerId();

        imageViewbackCart = findViewById(R.id.imageViewBackfromOrder);
        imageViewbackCart.setOnClickListener(view -> onBackPressed());
    }


    private void showProgressDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgress(10);
        progressDialog.setMax(100);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
    }

    private void getOrdersByCustomerId() {
        showProgressDialog();

        Call<Orders> ordersCall = api.getOrdersByCustomerId(CustomerId);
        ordersCall.enqueue(new Callback<Orders>() {
            @Override
            public void onResponse(Call<Orders> call, Response<Orders> response) {
                Log.d(TAG, "response code" + response.code());
                ordersList = response.body().getValues();
                orderAdapter.setData(ordersList);
                productList.setAdapter(orderAdapter);
                progressDialog.cancel();

            }

            @Override
            public void onFailure(Call<Orders> call, Throwable t) {
                Log.d(TAG, t.getMessage());

            }
        });
    }

}