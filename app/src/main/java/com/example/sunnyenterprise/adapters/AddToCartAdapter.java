package com.example.sunnyenterprise.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sunnyenterprise.R;
import com.example.sunnyenterprise.model.cartListModel.CartList;
import com.example.sunnyenterprise.model.categoryModel.Category;
import com.example.sunnyenterprise.model.productDetailModel.Size;

import java.util.List;

public class AddToCartAdapter extends RecyclerView.Adapter<AddToCartAdapter.ViewHolder> {
    /*List<String> titles,colors;
    List<Integer> images;*/
    LayoutInflater inflater;
    List<CartList> cartLists;

    public AddToCartAdapter(Context mContext, List<CartList> cartLists) {
        /*this.titles = titles;
        this.images = images;
        this.colors = colors;*/
        this.cartLists = cartLists;
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
        holder.ctitle.setText(cartLists.get(position).getName());
//        holder.ccolor.setText(colors.get(position));
//        holder.cgridIcon.setImageResource(images.get(position));

    }

    @Override
    public int getItemCount() {
        return cartLists.size();
    }

    public void setData(List<CartList> cartLists) {
        this.cartLists = cartLists;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView ctitle,ccolor;
        ImageView cgridIcon;
//        CardView cproductgridView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ctitle = itemView.findViewById(R.id.textViewAddToCart);
            cgridIcon = itemView.findViewById(R.id.imageViewAddToCart);
            ccolor = itemView.findViewById(R.id.colorText);

        }
    }
}
