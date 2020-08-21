package com.example.sunnyenterprise.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sunnyenterprise.R;

import java.util.List;

public class AddToCartAdapter extends RecyclerView.Adapter<AddToCartAdapter.ViewHolder> {
    List<String> titles;
    List<Integer> images;
    LayoutInflater inflater;

    public AddToCartAdapter(List<String> titles, List<Integer> images, Context mContext) {
        this.titles = titles;
        this.images = images;
        this.inflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.add_to_cart_grid_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ctitle.setText(titles.get(position));
        holder.cgridIcon.setImageResource(images.get(position));
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView ctitle;
        ImageView cgridIcon;
//        CardView cproductgridView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ctitle = itemView.findViewById(R.id.textViewAddToCart);
            cgridIcon = itemView.findViewById(R.id.imageViewAddToCart);

        }
    }
}
