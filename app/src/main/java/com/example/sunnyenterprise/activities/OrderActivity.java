package com.example.sunnyenterprise.activities;

import android.app.ProgressDialog;
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

    ApiCallInterface api;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        productList = findViewById(R.id.orderRecyclerView);
        productList.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        productList.setLayoutManager(layoutManager);

        orderAdapter = new OrderAdapter(ordersList, this);


        api = ApiService.createService(ApiCallInterface.class);

        getOrdersByCustomerId();

        imageViewbackCart = findViewById(R.id.imageViewBackfromOrder);
        imageViewbackCart.setOnClickListener(view -> onBackPressed());
    }

    private void getOrdersByCustomerId() {
        /*Call<List<Orders>> ordersCall = api.getOrdersByCustomerId();
        ordersCall.enqueue(new Callback<List<Orders>>() {
            @Override
            public void onResponse(Call<List<Orders>> call, Response<List<Orders>> response) {
                Log.d(TAG, "response code" + response.code());
                ordersList = response.body();
                orderAdapter.setData(ordersList);
                productList.setAdapter(orderAdapter);
            }

            @Override
            public void onFailure(Call<List<Orders>> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });*/

        Call<Orders> ordersCall = api.getOrdersByCustomerId();
        ordersCall.enqueue(new Callback<Orders>() {
            @Override
            public void onResponse(Call<Orders> call, Response<Orders> response) {
                Log.d(TAG, "response code" + response.code());
                ordersList = response.body().getValues();
                orderAdapter.setData(ordersList);
                productList.setAdapter(orderAdapter);

            }

            @Override
            public void onFailure(Call<Orders> call, Throwable t) {
                Log.d(TAG, t.getMessage());

            }
        });
    }
}