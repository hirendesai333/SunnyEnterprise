package com.example.sunnyenterprise.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sunnyenterprise.R;
import com.example.sunnyenterprise.activities.CatalogActivity;
import com.example.sunnyenterprise.activities.ProductActivity;
import com.example.sunnyenterprise.activities.ProductDetailsActivity;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    List<String> titles;
    List<Integer> images;
    LayoutInflater inflater;

    public ProductAdapter(Context ctx, List<String> titles, List<Integer> images) {
        this.titles = titles;
        this.images = images;
        this.inflater = LayoutInflater.from(ctx);
    }

    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.product_grid_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductAdapter.ViewHolder holder, int position) {
        holder.ptitle.setText(titles.get(position));
        holder.pgridIcon.setImageResource(images.get(position));

        holder.productgridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ProductDetailsActivity.class);
                intent.putExtra("productTitle", String.valueOf(holder.ptitle.getText()));
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView ptitle;
        ImageView pgridIcon;
        CardView productgridView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ptitle = itemView.findViewById(R.id.productName);
            pgridIcon = itemView.findViewById(R.id.productImage);
            productgridView = itemView.findViewById(R.id.productGridView);
        }
    }
}
