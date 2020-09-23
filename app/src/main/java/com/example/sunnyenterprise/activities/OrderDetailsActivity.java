package com.example.sunnyenterprise.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sunnyenterprise.R;
import com.example.sunnyenterprise.model.orderDetailsModel.OrderDetails;
import com.example.sunnyenterprise.retrofit.ApiCallInterface;
import com.example.sunnyenterprise.retrofit.ApiService;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderDetailsActivity extends AppCompatActivity {
    private String TAG = OrderDetailsActivity.class.getSimpleName();

    OrderDetails orderDetails;
    ProgressDialog progressDialog;
    ApiCallInterface api;

    ImageView imageViewProduct, imageViewBakcOrders;
    TextView tvProductName, tvOrderPrice, tvOrderQuantity;
    long iddetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        imageViewProduct = findViewById(R.id.orderImage);
        tvProductName = findViewById(R.id.productName);
        tvOrderQuantity = findViewById(R.id.orderQuantity);
        tvOrderPrice = findViewById(R.id.orderPrice);
        imageViewBakcOrders = findViewById(R.id.backImageOrderDetails);
        imageViewBakcOrders.setOnClickListener(view -> onBackPressed());

        api = ApiService.createService(ApiCallInterface.class);
        iddetail = getIntent().getLongExtra("title", 1);
        getOrderDetailsBtId();

    }

    private void showProgressDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgress(10);
        progressDialog.setMax(100);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
    }

    private void getOrderDetailsBtId() {
        showProgressDialog();

        Call<OrderDetails> orderDetailsCall = api.getOrderDetailsById(iddetail);
        orderDetailsCall.enqueue(new Callback<OrderDetails>() {
            @Override
            public void onResponse(Call<OrderDetails> call, Response<OrderDetails> response) {
                Log.d(TAG, String.valueOf(response.code()));
                orderDetails = response.body();
                Picasso.get()
                        .load(orderDetails.getImageS3Url())
                        .into(imageViewProduct);

                tvProductName.setText("Name: " + orderDetails.getProductName());
                tvOrderPrice.setText("Price: " + orderDetails.getPrice());
                tvOrderQuantity.setText("Quantity: " + orderDetails.getQuantity());
                progressDialog.cancel();

            }

            @Override
            public void onFailure(Call<OrderDetails> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
    }


}