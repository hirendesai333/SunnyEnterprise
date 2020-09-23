package com.example.sunnyenterprise.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sunnyenterprise.R;
import com.example.sunnyenterprise.adapters.NotificationAdapter;

import java.util.ArrayList;
import java.util.List;

public class NotificationActivity extends AppCompatActivity {
    RecyclerView notifyList;
    List<String> titles;
    NotificationAdapter notificationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
//        Toast.makeText(NotificationActivity.this, "Swipe to remove the notification", Toast.LENGTH_SHORT).show();

        notifyList = findViewById(R.id.notificationRecyclerview);
        titles = new ArrayList<>();

        titles.add("First notification");
        titles.add("Second notification");
        titles.add("Third notification");
        titles.add("Fourth notification");
        titles.add("Fifth notification");
        titles.add("Sixth notification");

        notificationAdapter = new NotificationAdapter(this, titles);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        notifyList.setLayoutManager(gridLayoutManager);
        notifyList.setAdapter(notificationAdapter);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder target, int direction) {
                int position = target.getAdapterPosition();
                titles.remove(position);

                notificationAdapter.notifyDataSetChanged();
            }
        });
        itemTouchHelper.attachToRecyclerView(notifyList);

        ImageView imageView = findViewById(R.id.backimagenotify);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}