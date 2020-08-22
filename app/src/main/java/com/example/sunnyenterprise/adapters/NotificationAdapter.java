package com.example.sunnyenterprise.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sunnyenterprise.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {
    List<String> titles;
    LayoutInflater inflater;

    public NotificationAdapter(Context context, List<String> titles) {
        this.inflater = LayoutInflater.from(context);
        this.titles = titles;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.notification_grid_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.notificationTitle.setText(titles.get(position));

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        String formattedDate = df.format(c.getTime());

        holder.notificationTime.setText(formattedDate);


    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView notificationTitle, notificationTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            notificationTitle = itemView.findViewById(R.id.textViewNotification);
            notificationTime = itemView.findViewById(R.id.textViewTime);

        }
    }
}
