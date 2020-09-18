package com.example.sunnyenterprise.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
import com.example.sunnyenterprise.model.productDetailModel.Color;
import com.example.sunnyenterprise.model.productDetailModel.ProductDetails;
import com.example.sunnyenterprise.model.productDetailModel.Size;
import com.example.sunnyenterprise.recyclerviewInterface.RecyclerViewClickInterface;
import com.example.sunnyenterprise.retrofit.ApiCallInterface;
import com.example.sunnyenterprise.retrofit.ApiService;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;
import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailsActivity extends AppCompatActivity implements RecyclerViewClickInterface {
    SliderLayout sliderLayout;
    TextView textView, tvPrice, tvStyle;
    Button addtocartButton;
    ApiCallInterface api;
    Double singleProduct;
    RecyclerView sizeList, colorList;

    //adapters
    ProductSizeAdapter productSizeAdapter;
    ProductColorAdapter productColorAdapter;

    List<Size> pList;
    List<Color> cList;

    String imageurl;
    ImageView imageViewProduct;

    private static final String slug = "123";

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

        productSizeAdapter = new ProductSizeAdapter(this, pList);
        productColorAdapter = new ProductColorAdapter(this, cList, this);

        api = ApiService.createService(ApiCallInterface.class);

        Intent i = getIntent();
        String title = i.getStringExtra("productTitle");
        textView = findViewById(R.id.textViewproductDetails);
        textView.setText(title);

        //for auto imageslider
//        sliderLayout = findViewById(R.id.productImageSlider);
//        sliderLayout.setIndicatorAnimation(SliderLayout.Animations.SLIDE); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
//        sliderLayout.setScrollTimeInSec(5);

//        setSliderViews();

        addtocartButton = findViewById(R.id.addTocartBtn);
        addtocartButton.setOnClickListener(view -> {
            long ProductId = 182;
            long CustomerId = 1;
            long sizeId = 1;
            long quantity = 100;

            List<SizeQuantity> sizeQuantity = Collections.singletonList(new SizeQuantity(sizeId, quantity));
            AddCart addCart = new AddCart(ProductId, CustomerId, sizeQuantity);

            Call<AddCart> cartCall = api.postData(addCart);
            cartCall.enqueue(new Callback<AddCart>() {
                @Override
                public void onResponse(Call<AddCart> call, Response<AddCart> response) {
                    Toast.makeText(ProductDetailsActivity.this, "Code: " + response.code(), Toast.LENGTH_SHORT).show();

                    /*AddCart addCartResponse = response.body();

                    long id1 = addCartResponse.getCustomerId();
                    long id2 = addCartResponse.getProductId();

                    Log.d("addCartResponse", String.valueOf(id1));
                    Log.d("addCartResponse", String.valueOf(id2));*/

                }

                @Override
                public void onFailure(Call<AddCart> call, Throwable t) {
                    Toast.makeText(ProductDetailsActivity.this, "onFailure" + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

            Intent cartIntent = new Intent(getApplicationContext(), AddToCartActivity.class);
            startActivity(cartIntent);
        });

        ImageView imageView = findViewById(R.id.imageViewProductDetailsback);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
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
                Toast.makeText(ProductDetailsActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getProductDetails(slug);
    }

    private void getProductDetails(String newSlug) {
        Call<ProductDetails> call = api.getProductDetail(newSlug);

        call.enqueue(new Callback<ProductDetails>() {
            @Override
            public void onResponse(Call<ProductDetails> call, Response<ProductDetails> response) {
                singleProduct = response.body().getSingleProduct().getPrice();
                double price = singleProduct;
                tvPrice.setText("Mrp: " + price);

                String productName = response.body().getSingleProduct().getName();
                tvStyle.setText("Style: " + productName);

                pList = response.body().getSingleProduct().getSizes();
                productSizeAdapter.setData(pList);
                sizeList.setAdapter(productSizeAdapter);

                if (response.body().getSingleProduct().getProductImages().size() > 0) {
                    imageurl = response.body().getSingleProduct().getProductImages().get(0).getImageURL();
                    Picasso.get().load(imageurl).into(imageViewProduct);
                }

                cList = response.body().getSingleProduct().getColors();
                productColorAdapter.setData(cList, response.body().getSingleProduct());
                colorList.setAdapter(productColorAdapter);
            }

            @Override
            public void onFailure(Call<ProductDetails> call, Throwable t) {
                Toast.makeText(ProductDetailsActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setSliderViews() {
        for (int i = 0; i <= 1; i++) {
            SliderView sliderView = new SliderView(this);
            switch (i) {
                case 0:
//                    sliderView.setImageUrl("https://www.americommerce.com/images/X-product-pages-that-make-us-want-to-buy.png");
                    sliderView.setImageDrawable(R.drawable.productimage);
                    break;
            }

            sliderView.setImageScaleType(ImageView.ScaleType.FIT_CENTER);
            sliderView.setDescription("Note: ");
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    //perform onclick event
                }
            });
            sliderLayout.addSliderView(sliderView);

        }
    }

}