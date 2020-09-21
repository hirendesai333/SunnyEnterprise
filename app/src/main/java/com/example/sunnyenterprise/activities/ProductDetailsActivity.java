package com.example.sunnyenterprise.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sunnyenterprise.R;
import com.example.sunnyenterprise.adapters.ProductColorAdapter;
import com.example.sunnyenterprise.adapters.ProductSizeAdapter;
import com.example.sunnyenterprise.model.addCartModel.AddCart;
import com.example.sunnyenterprise.model.addCartModel.SizeQuantity;
import com.example.sunnyenterprise.model.addToCartModel.AddToCart;
import com.example.sunnyenterprise.model.addToCartModel.Item;
import com.example.sunnyenterprise.model.productDetailModel.Color;
import com.example.sunnyenterprise.model.productDetailModel.ProductDetails;
import com.example.sunnyenterprise.model.productDetailModel.Size;
import com.example.sunnyenterprise.recyclerviewInterface.OnSizeClickInterface;
import com.example.sunnyenterprise.recyclerviewInterface.RecyclerViewClickInterface;
import com.example.sunnyenterprise.retrofit.ApiCallInterface;
import com.example.sunnyenterprise.retrofit.ApiService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailsActivity extends AppCompatActivity implements RecyclerViewClickInterface {

    private String TAG = ProductDetailsActivity.class.getSimpleName();

    TextView textView, tvPrice, tvStyle;
    Button addtocartButton;
    ApiCallInterface api;
    Double singleProduct;
    RecyclerView sizeList, colorList;

    ProductSizeAdapter productSizeAdapter;
    ProductColorAdapter productColorAdapter;

    List<Size> pList;
    List<Color> cList;

    ArrayList<SizeQuantity> sizeQuantityList = new ArrayList<>();
    ArrayList<Item> itemArrayList = new ArrayList<>();

    String imageurl;
    ImageView imageViewProduct;

    ProgressDialog progressDialog;

    private static final String slug = "123";

    public int sizeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        tvPrice = findViewById(R.id.textMrp);
        tvStyle = findViewById(R.id.tvStyle);

        sizeList = findViewById(R.id.recyclerviewSize);
        sizeList.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        sizeList.setLayoutManager(layoutManager);

        colorList = findViewById(R.id.recyclerviewColor);
        colorList.setHasFixedSize(true);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
        colorList.setLayoutManager(layoutManager2);

        imageViewProduct = findViewById(R.id.imageProduct);
        addtocartButton = findViewById(R.id.addTocartBtn);

        productColorAdapter = new ProductColorAdapter(this, cList, this);

        Intent i = getIntent();
        String title = i.getStringExtra("productTitle");
        textView = findViewById(R.id.textViewproductDetails);
        textView.setText(title);

        long ProductId = Long.parseLong(i.getStringExtra("product_id"));
        long CustomerId = 1;

        api = ApiService.createService(ApiCallInterface.class);

        productSizeAdapter = new ProductSizeAdapter(this, pList, id -> {
            /*for (int j=0; j<productSizeAdapter.getItemCount(); j++){
                int qty = ProductSizeAdapter.pList.get(j).getId();
                Log.d(TAG, "QTY"+qty);
            }*/

            sizeId = id;
            int quantity = 20;
            SizeQuantity sizeQuantity = new SizeQuantity(sizeId, quantity);
            sizeQuantityList.add(sizeQuantity);
            Log.d(TAG, String.valueOf(sizeId));

            AddCart addCart = new AddCart(ProductId, CustomerId, sizeQuantityList);

            addtocartButton.setOnClickListener(view -> {
                Call<AddToCart> addCartCall = api.postData(addCart);
                addCartCall.enqueue(new Callback<AddToCart>() {
                    @Override
                    public void onResponse(Call<AddToCart> call, Response<AddToCart> response) {
                        Toast.makeText(ProductDetailsActivity.this, "Code: " + response.code(), Toast.LENGTH_SHORT).show();
                        if (response.code() == 200) {

                            startActivity(new Intent(ProductDetailsActivity.this, AddToCartActivity.class));
                        } else {
                            Toast.makeText(ProductDetailsActivity.this, "response code error!", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<AddToCart> call, Throwable t) {
                        Toast.makeText(ProductDetailsActivity.this, "onFailure " + t.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
            });
        });

        ImageView imageView = findViewById(R.id.imageViewProductDetailsback);
        imageView.setOnClickListener(view -> onBackPressed());

    }

    @Override
    public void onItemClick(final int position, final String slug) {
        Call<ProductDetails> call = api.getProductDetail(slug);
        call.enqueue(new Callback<ProductDetails>() {
            @Override
            public void onResponse(Call<ProductDetails> call, Response<ProductDetails> response) {
                getProductDetails(response.body().getSingleProduct().getSlug());
            }

            @Override
            public void onFailure(Call<ProductDetails> call, Throwable t) {
                android.widget.Toast.makeText(ProductDetailsActivity.this, t.getLocalizedMessage(), android.widget.Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getProductDetails(slug);
    }

    private void getProductDetails(String newSlug) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgress(10);
        progressDialog.setMax(100);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        Call<ProductDetails> call = api.getProductDetail(newSlug);

        call.enqueue(new Callback<ProductDetails>() {
            @Override
            public void onResponse(Call<ProductDetails> call, Response<ProductDetails> response) {
                progressDialog.cancel();

                String productName = response.body().getSingleProduct().getName();
                tvStyle.setText(productName);

                singleProduct = response.body().getSingleProduct().getPrice();
                double price = singleProduct;
                tvPrice.setText("" + price);

                cList = response.body().getSingleProduct().getColors();
                productColorAdapter.setData(cList, response.body().getSingleProduct());
                colorList.setAdapter(productColorAdapter);

                pList = response.body().getSingleProduct().getSizes();
                productSizeAdapter.setData(pList);
                sizeList.setAdapter(productSizeAdapter);

                if (response.body().getSingleProduct().getProductImages().size() > 0) {
                    imageurl = response.body().getSingleProduct().getProductImages().get(0).getImageURL();
                    Picasso.get().load(imageurl).into(imageViewProduct);
                }

            }

            @Override
            public void onFailure(Call<ProductDetails> call, Throwable t) {
                android.widget.Toast.makeText(ProductDetailsActivity.this, t.getLocalizedMessage(), android.widget.Toast.LENGTH_SHORT).show();
            }
        });

    }


}