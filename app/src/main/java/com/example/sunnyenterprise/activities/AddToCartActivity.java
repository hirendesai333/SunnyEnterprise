package com.example.sunnyenterprise.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sunnyenterprise.R;
import com.example.sunnyenterprise.adapters.AddToCartAdapter;
import com.example.sunnyenterprise.model.CustomerObj;
import com.example.sunnyenterprise.model.cartListModel.CartList;
import com.example.sunnyenterprise.model.placeOrderModel.Item;
import com.example.sunnyenterprise.recyclerviewInterface.OnDeleteItemInterface;
import com.example.sunnyenterprise.retrofit.ApiCallInterface;
import com.example.sunnyenterprise.retrofit.ApiService;
import com.example.sunnyenterprise.utils.Preferences;


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
    ImageView homeBtnFromCart;
    Button btnCheckout, btnCancel, btnDelete;
    TextView tvCartEmpty, tvCartItems, tvGrandTotal;
    int CustomerId;

    Preferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_cart);

        /*SharedPreferences sharedPreferences = getSharedPreferences("sharePrefCustomerId", Context.MODE_PRIVATE);
        CustomerId = sharedPreferences.getInt("customer_id", 0);*/

        preferences = new Preferences(AddToCartActivity.this);

        CustomerId = (int) preferences.getId();

        imageViewbackCart = findViewById(R.id.imageViewBackfromCart);
        imageViewbackCart.setOnClickListener(view -> onBackPressed());

        homeBtnFromCart = findViewById(R.id.homeButtonfromCart);
        homeBtnFromCart.setOnClickListener(view -> {
            startActivity(new Intent(AddToCartActivity.this, HomeActivity.class));
        });

        tvCartEmpty = findViewById(R.id.tvCartEmpty);
        tvCartItems = findViewById(R.id.tvTotalItems);
        tvGrandTotal = findViewById(R.id.tvGrandTotal);

        productList = findViewById(R.id.addTocartRecyclerView);
        productList.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        productList.setLayoutManager(layoutManager);

        addToCartAdapter = new AddToCartAdapter(this, cartLists, this);

        api = ApiService.createService(ApiCallInterface.class);

        btnCheckout = findViewById(R.id.checkoutBtn);
        btnCheckout.setOnClickListener(view -> {
            placeOrder();
        });

        clearCartBtn = findViewById(R.id.clearCartBtn);
        clearCartBtn.setOnClickListener(view -> {
//            clearCartProducts();
            showAlertDialog();
        });

    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(AddToCartActivity.this);
        builder.setTitle("Are You Sure...");
        builder.setNegativeButton("CANCEL", (dialog, which) -> Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show());
        builder.setPositiveButton("DELETE", (dialog, which) -> clearCartProducts());
        builder.show();
    }

    public void showProgressDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgress(10);
        progressDialog.setMax(100);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getCartList();
    }

    private void getCartList() {
        showProgressDialog();
        Call<List<CartList>> call = api.getCartList(CustomerId);
        call.enqueue(new Callback<List<CartList>>() {
            @Override
            public void onResponse(Call<List<CartList>> call, Response<List<CartList>> response) {
                cartLists = response.body();
                if (cartLists.size() == 0) {
                    tvCartEmpty.setVisibility(View.VISIBLE);
                    tvCartItems.setText("0 items");
                    addToCartAdapter.setData(cartLists);
                    clearCartBtn.setVisibility(View.GONE);
                    tvGrandTotal.setText("0");
                    progressDialog.cancel();
                } else {
                    clearCartBtn.setVisibility(View.VISIBLE);
                    addToCartAdapter.setData(cartLists);
                    productList.setAdapter(addToCartAdapter);
                    tvCartItems.setText(cartLists.size() + " Items");
                    tvGrandTotal.setText("" + cartLists.get(0).getGrandTotal());
                    progressDialog.cancel();
                }
            }

            @Override
            public void onFailure(Call<List<CartList>> call, Throwable t) {
                Toast.makeText(AddToCartActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void clearCartProducts() {
        Call<Boolean> customerObj = api.deleteCartList(CustomerId);
        customerObj.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                onResume();
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {

            }
        });
    }

    @Override
    public void deleteItemID(int id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(AddToCartActivity.this);
        builder.setTitle("Are You Sure...");
        builder.setNegativeButton("CANCEL", (dialog, which) -> Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show());
        builder.setPositiveButton("DELETE", (dialog, which) -> deletefromDialog(id));
        builder.show();

    }

    public void deletefromDialog(int productId) {
        Call<CartList> deleteCall = api.deleteCartItem(productId);
        deleteCall.enqueue(new Callback<CartList>() {
            @Override
            public void onResponse(Call<CartList> call, Response<CartList> response) {
                onResume();
            }

            @Override
            public void onFailure(Call<CartList> call, Throwable t) {
            }
        });
    }

    private void placeOrder() {
        CustomerObj customerObj = new CustomerObj((long) CustomerId);
        Call<Item> itemCall = api.placeOrder(customerObj);
        itemCall.enqueue(new Callback<Item>() {
            @Override
            public void onResponse(Call<Item> call, Response<Item> response) {
                onResume();
                Toast.makeText(AddToCartActivity.this, "Order has been placed!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Item> call, Throwable t) {

            }
        });

    }

}