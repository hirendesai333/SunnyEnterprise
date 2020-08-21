package com.example.sunnyenterprise.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.sunnyenterprise.adapters.CompanyAdapter;
import com.example.sunnyenterprise.R;
import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

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

    // this change is from chirag


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        drawerLayout = findViewById(R.id.drawerLayout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                /*switch (id) {
                    case R.id.profile:
                        *//*Intent profileIntent = new Intent(getApplicationContext(), UserActivity.class);
                        startActivity(profileIntent);
                        break;
                    case R.id.logOut:
                        LogOut();
                        break;
                    default:
                        return true;
                }*/
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
        sliderLayout = findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(SliderLayout.Animations.FILL); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setScrollTimeInSec(1); //set scroll delay in seconds :

        setSliderViews();

        dataList = findViewById(R.id.dataList);
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

        companyAdapter = new CompanyAdapter(this, titles, images);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(companyAdapter);

    }

    private void setSliderViews() {
        for (int i = 0; i <= 3; i++) {
            SliderView sliderView = new SliderView(this);
            switch (i) {
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
            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderView.setDescription("ad# " + (i + 1));
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    //perform onclick event
                }
            });
            sliderLayout.addSliderView(sliderView);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_topbar, menu);
        return true;
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
        finish();
    }
}