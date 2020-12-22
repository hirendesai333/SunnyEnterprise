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

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.sunnyenterprise.R;
import com.example.sunnyenterprise.adapters.ProductColorAdapter;
import com.example.sunnyenterprise.adapters.ProductSizeAdapter;
import com.example.sunnyenterprise.model.addCartModel.AddCart;
import com.example.sunnyenterprise.model.addCartModel.SizeQuantity;
import com.example.sunnyenterprise.model.addToCartModel.AddToCart;
import com.example.sunnyenterprise.model.productDetailModel.Color;
import com.example.sunnyenterprise.model.productDetailModel.ProductDetails;
import com.example.sunnyenterprise.model.productDetailModel.ProductImage;
import com.example.sunnyenterprise.model.productDetailModel.Size;
import com.example.sunnyenterprise.recyclerviewInterface.OnSizeQtyClick;
import com.example.sunnyenterprise.recyclerviewInterface.RecyclerViewClickInterface;
import com.example.sunnyenterprise.retrofit.ApiCallInterface;
import com.example.sunnyenterprise.retrofit.ApiService;
import com.example.sunnyenterprise.utils.Preferences;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailsActivity extends AppCompatActivity implements RecyclerViewClickInterface, OnSizeQtyClick {

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

    String imageurl;
   // ImageView imageViewProduct;

    ProgressDialog progressDialog;

    public String slugString = null;

    private int sizeId = 0;
    int quantity = 0;
    boolean isQtyAdded = true;

    Preferences preferences;

    ImageSlider imageSlider;
    List<SlideModel> slideModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        preferences = new Preferences(this);

        tvPrice = findViewById(R.id.textMrp);
        tvStyle = findViewById(R.id.tvStyle);

        sizeList = findViewById(R.id.recyclerviewSize);
        sizeList.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        sizeList.setLayoutManager(layoutManager);

        colorList = findViewById(R.id.recyclerviewColor);
        colorList.setHasFixedSize(true);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        colorList.setLayoutManager(layoutManager2);

        imageSlider = findViewById(R.id.image_slider);

        addtocartButton = findViewById(R.id.addTocartBtn);

        productColorAdapter = new ProductColorAdapter(this, cList, this);

        Intent i = getIntent();
        String title = i.getStringExtra("productTitle");
        textView = findViewById(R.id.textViewproductDetails);
        textView.setText(title);

        long ProductId = Long.parseLong(i.getStringExtra("product_id"));
        long CustomerId = preferences.getId();

        api = ApiService.createService(ApiCallInterface.class);

        productSizeAdapter = new ProductSizeAdapter(this, pList, this);

        AddCart addCart = new AddCart(ProductId, CustomerId, sizeQuantityList);

        addtocartButton.setOnClickListener(view -> {
            if (sizeQuantityList.size() > 0) {
                if (isQtyAdded) {
                    Call<AddToCart> addCartCall = api.postData(addCart);
                    addCartCall.enqueue(new Callback<AddToCart>() {
                        @Override
                        public void onResponse(@NotNull Call<AddToCart> call, @NotNull Response<AddToCart> response) {
                            Toast.makeText(ProductDetailsActivity.this, "Code: " + response.code(), Toast.LENGTH_SHORT).show();
                            if (response.code() == 200) {
                                sizeQuantityList.clear();
                                startActivity(new Intent(ProductDetailsActivity.this, AddToCartActivity.class));
                            } else {
                                Toast.makeText(ProductDetailsActivity.this, "try again!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(@NotNull Call<AddToCart> call, @NotNull Throwable t) {
                            Toast.makeText(ProductDetailsActivity.this, "onFailure " + t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    Toast.makeText(this, "Please enter Quality in all sizes", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Please add at least one size", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView imageView = findViewById(R.id.imageViewProductDetailsback);
        imageView.setOnClickListener(view -> onBackPressed());

        ImageView home = findViewById(R.id.homeButtonProductDetails);
        home.setOnClickListener(v -> {
            startActivity(new Intent(this, HomeActivity.class));
        });

        slugString = i.getStringExtra("slug");

    }

    @Override
    public void onItemClick(final int position, final String slugString) {
        Call<ProductDetails> call = api.getProductDetail(slugString);
        call.enqueue(new Callback<ProductDetails>() {
            @Override
            public void onResponse(Call<ProductDetails> call, Response<ProductDetails> response) {
                if (response.body() != null) {
                    getProductDetails(response.body().getSingleProduct().getSlug());
                }
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
        getProductDetails(slugString);
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
                   // Picasso.get().load(imageurl).into(imageViewProduct);
                    List<ProductImage> imageList = (List<ProductImage>) response.body().getSingleProduct().getProductImages();
                    for (int i = 0; i < imageList.size(); i++) {

                        imageurl = imageList.get(0).getImageURL();
                        slideModels.add(new SlideModel(imageurl, ScaleTypes.CENTER_CROP));
                        imageSlider.setImageList(slideModels);
                    }

                }

            }

            @Override
            public void onFailure(Call<ProductDetails> call, Throwable t) {
                android.widget.Toast.makeText(ProductDetailsActivity.this, t.getLocalizedMessage(), android.widget.Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onClickQty(Editable Qty, int id) {
        if (!Qty.toString().trim().isEmpty()) {
            sizeId = id;
            quantity = Integer.parseInt(Qty.toString());
            for (int i = 0; i < sizeQuantityList.size(); i++) {
                if (sizeQuantityList.get(i).getSizeId() == id) {
                    SizeQuantity sizeQuantity = new SizeQuantity(sizeId, quantity);
                    sizeQuantityList.set(i, sizeQuantity);
                }
            }
        }
        checkQtyOfAll();
    }

    @Override
    public void onClickCheckbox(int id) {
        sizeId = id;
        SizeQuantity sizeQuantity = new SizeQuantity(sizeId, 0);
        sizeQuantityList.add(sizeQuantity);
        checkQtyOfAll();
    }

    @Override
    public void deleteSelection(int id) {
        for (int i = 0; i < sizeQuantityList.size(); i++) {
            if (sizeQuantityList.get(i).getSizeId() == id) {
                sizeQuantityList.remove(i);
            }
        }
        checkQtyOfAll();
    }

    public void checkQtyOfAll() {
        for (int i = 0; i < sizeQuantityList.size(); i++) {
            if (sizeQuantityList.get(i).getQuantity() == 0) {
                isQtyAdded = false;
                break;
            } else {
                isQtyAdded = true;
            }
        }
    }
}