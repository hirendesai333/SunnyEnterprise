package com.example.sunnyenterprise.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterViewFlipper;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sunnyenterprise.adapters.CompanyAdapter;
import com.example.sunnyenterprise.R;
import com.example.sunnyenterprise.adapters.FlipperAdapter;
import com.example.sunnyenterprise.model.Banner;
import com.example.sunnyenterprise.model.Company;
import com.example.sunnyenterprise.retrofit.ApiCallInterface;
import com.example.sunnyenterprise.retrofit.ApiService;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;

    RecyclerView dataList;
    List<String> titles;
    List<Integer> images;
    CompanyAdapter companyAdapter;

    SliderLayout sliderLayout;
    ImageView mButton;

    ImageView notifyImage, imageViewCt;

    List<Banner> bannerList;
    List<Company> companyList;


    ApiCallInterface api;


    //adapterviewflipper object
    private AdapterViewFlipper adapterViewFlipper;

    ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        notifyImage = findViewById(R.id.imageViewNotificatino);
        notifyImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(HomeActivity.this, "clicked! ", Toast.LENGTH_SHORT).show();
                Intent notificationIntent = new Intent(HomeActivity.this, NotificationActivity.class);
                startActivity(notificationIntent);
                Toast.makeText(HomeActivity.this, "Swipe to remove the notification", Toast.LENGTH_SHORT).show();
            }
        });

        imageViewCt = findViewById(R.id.imageViewCart);
        imageViewCt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cartIntent = new Intent(HomeActivity.this, AddToCartActivity.class);
                startActivity(cartIntent);
            }
        });


        drawerLayout = findViewById(R.id.imageCartMain);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.home:
//                        drawerLayout.openDrawer(GravityCompat.END);
                        break;
                    case R.id.orders:
                        Intent cartIntent = new Intent(HomeActivity.this, OrderActivity.class);
                        startActivity(cartIntent);
                        break;
                    default:
                        return true;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        mButton = findViewById(R.id.imageViewOpenMenu);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        //for auto imageslider
       /* sliderLayout = findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(SliderLayout.Animations.FILL); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setScrollTimeInSec(1); //set scroll delay in seconds :

        setSliderViews();
*/
        /*dataList = findViewById(R.id.dataList);
        titles = new ArrayList<>();
        images = new ArrayList<>();

        titles.add("First company");
        titles.add("Second company");
        titles.add("Third company");
        titles.add("Fourth company");
        titles.add("Fifth company");
        titles.add("Sixth company");

        images.add(R.drawable.companytwo);
        images.add(R.drawable.companytwo);
        images.add(R.drawable.companytwo);
        images.add(R.drawable.companytwo);
        images.add(R.drawable.companytwo);
        images.add(R.drawable.companytwo);
        images.add(R.drawable.companytwo);

        companyAdapter = new CompanyAdapter(this, companyList);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(companyAdapter);*/

        dataList = findViewById(R.id.dataList);
        dataList.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        dataList.setLayoutManager(layoutManager);

        companyAdapter = new CompanyAdapter(getApplicationContext(), companyList);

        api = ApiService.createService(ApiCallInterface.class);

        getCompanies();

        //getting adapterviewflipper
        adapterViewFlipper = (AdapterViewFlipper) findViewById(R.id.adapterViewFlipper);

        Call<List<Banner>> call = api.getBanners();

        call.enqueue(new Callback<List<Banner>>() {
            @Override
            public void onResponse(Call<List<Banner>> call, Response<List<Banner>> response) {
                //getting list of heroes
                List<Banner> banners = response.body();
                FlipperAdapter adapter = new FlipperAdapter(getApplicationContext(), banners);

                //adding it to adapterview flipper
                adapterViewFlipper.setAdapter(adapter);
                adapterViewFlipper.setFlipInterval(3000);
                adapterViewFlipper.startFlipping();

            }

            @Override
            public void onFailure(Call<List<Banner>> call, Throwable t) {
                Toast.makeText(HomeActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getCompanies() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Content Loader");
        progressDialog.setProgress(10);
        progressDialog.setMax(100);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        Call<List<Company>> call = api.getCompanies();

        call.enqueue(new Callback<List<Company>>() {
            @Override
            public void onResponse(Call<List<Company>> call, Response<List<Company>> response) {
                progressDialog.cancel();
                companyList = response.body();
                companyAdapter.setData(companyList);
                dataList.setAdapter(companyAdapter);
            }

            @Override
            public void onFailure(Call<List<Company>> call, Throwable t) {
                Toast.makeText(HomeActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

/*
    private void setSliderViews() {
        for (int i = 0; i <= bannerList.size(); i++) {
            SliderView sliderView = new SliderView(getApplicationContext());
            sliderView.setImageUrl(banner.getImgURL());
                     */
/*switch (i) {
                         case 0:
                             sliderView.setImageUrl("https://images-eu.ssl-images-amazon.com/images/G/31/img20/Wireless/SamsungM/M01/Aug18_GW/P38631710_IN_WLME_SamsungGalaxy_MO1_New_Launch_Tall_hero_1500x600._CB407421657_.jpg");

                             break;
                         case 1:
                             sliderView.setImageUrl("https://images.pexels.com/photos/218983/pexels-photo-218983.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                             break;
                         case 2:
                             sliderView.setImageUrl("https://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260");
                             break;
                         case 3:
                             sliderView.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                             break;

                     }*//*


            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
//            sliderView.setDescription("ad# " + (i + 1));
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    //perform onclick event
                }
            });
            sliderLayout.addSliderView(sliderView);
        }
    }
*/


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}