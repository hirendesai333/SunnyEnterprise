package com.example.sunnyenterprise.activities;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
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
    private final String TAG = OrderActivity.class.getSimpleName();

    RecyclerView productList;
    OrderAdapter orderAdapter;
    ImageView imageViewbackCart;
    List<Value> ordersList;
    ProgressDialog progressDialog;
    ApiCallInterface api;
    int CustomerId;
    CardView filter;

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

        filter = findViewById(R.id.filterCardview);
        filter.setOnClickListener(v -> {
            showFilterDialog();
        });

        imageViewbackCart = findViewById(R.id.imageViewBackfromOrder);
        imageViewbackCart.setOnClickListener(view -> onBackPressed());
    }

    private void showFilterDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(OrderActivity.this);
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.custom_filter_dialog, viewGroup, false);
        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();

        Spinner spinCountry;
        spinCountry = dialogView.findViewById(R.id.spinCountry);

        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, getResources()
                .getStringArray(R.array.status));

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinCountry.setAdapter(adapter);
        spinCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        Button filter = dialogView.findViewById(R.id.filterButton);
        filter.setOnClickListener(v -> {
            alertDialog.dismiss();
        });

        alertDialog.show();
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