package com.example.sunnyenterprise.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterViewFlipper;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sunnyenterprise.adapters.CompanyAdapter;
import com.example.sunnyenterprise.R;
import com.example.sunnyenterprise.adapters.FlipperAdapter;
import com.example.sunnyenterprise.model.bannerModel.Banner;
import com.example.sunnyenterprise.model.companyModel.Company;
import com.example.sunnyenterprise.retrofit.ApiCallInterface;
import com.example.sunnyenterprise.retrofit.ApiService;
import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.SliderLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;

    RecyclerView dataList;
    CompanyAdapter companyAdapter;

    SliderLayout sliderLayout;
    ImageView mButton;

    ImageView notifyImage, imageViewCt;

    List<Banner> bannerList;
    List<Company> companyList;

    ApiCallInterface api;

    private AdapterViewFlipper adapterViewFlipper;

    ProgressDialog progressDialog;

    Boolean Islogin = false;

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
                    case R.id.logOut:
                        Intent loginIntent = new Intent(HomeActivity.this, LoginActivity.class);
                        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(HomeActivity.this);
                        prefs.edit().putBoolean("Islogin", Islogin).commit();
                        startActivity(loginIntent);
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

        dataList = findViewById(R.id.dataList);

        companyAdapter = new CompanyAdapter(getApplicationContext(), companyList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        dataList.setLayoutManager(gridLayoutManager);

        api = ApiService.createService(ApiCallInterface.class);

        getCompanies();

        adapterViewFlipper =  findViewById(R.id.adapterViewFlipper);

        Call<List<Banner>> call = api.getBanners();

        call.enqueue(new Callback<List<Banner>>() {
            @Override
            public void onResponse(Call<List<Banner>> call, Response<List<Banner>> response) {
                List<Banner> banners = response.body();
                FlipperAdapter adapter = new FlipperAdapter(getApplicationContext(), banners);

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
        finish();
    }
}