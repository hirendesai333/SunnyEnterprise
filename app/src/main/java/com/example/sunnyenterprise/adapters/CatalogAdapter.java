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
import com.example.sunnyenterprise.model.Category;
import com.example.sunnyenterprise.model.Company;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CatalogAdapter extends RecyclerView.Adapter<CatalogAdapter.CatalogViewHolder> {
    /*List<String> titles;
    List<Integer> images;*/
    Context context;
    List<Category> categoryList;

    public CatalogAdapter(Context context, List<Category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CatalogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.catalog_grid_layout, parent, false);
        return new CatalogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CatalogAdapter.CatalogViewHolder holder, int position) {
        holder.title.setText(categoryList.get(position).getName());
        Picasso.get().load(categoryList.get(position).getImageURL()).into(holder.gridIcon);

//        holder.gridIcon.setImageResource(images.get(position));
        holder.catalogGridview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ProductActivity.class);
                intent.putExtra("titleCatalog", String.valueOf(holder.title.getText()));
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public void setData(List<Category> categoryList) {
        this.categoryList = categoryList;
        notifyDataSetChanged();
    }

    public class CatalogViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView gridIcon;
        CardView catalogGridview;

        public CatalogViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.catalogText);
            gridIcon = itemView.findViewById(R.id.catalogImage);
            catalogGridview = itemView.findViewById(R.id.catalogGridview);

        }
    }
}
