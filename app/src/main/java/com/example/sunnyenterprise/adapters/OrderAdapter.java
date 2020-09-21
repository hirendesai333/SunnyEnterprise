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
import com.example.sunnyenterprise.model.ordersModel.Orders;
import com.example.sunnyenterprise.model.ordersModel.Value;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {
    //    List<String> titles, colors;
//    List<Integer> images;
    List<Value> valueList;

    LayoutInflater inflater;

    public OrderAdapter(List<Value> valueList, Context mContext) {
        this.valueList = valueList;
        this.inflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.order_grid_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ctitle.setText(valueList.get(position).getProductName());

    }

    @Override
    public int getItemCount() {
        return valueList.size();
    }

    public void setData(List<Value> valueList) {
        this.valueList = valueList;
        notifyDataSetChanged();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView ctitle, ccolor;
        ImageView cgridIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ctitle = itemView.findViewById(R.id.textViewAddToCart);
            cgridIcon = itemView.findViewById(R.id.imageViewAddToCart);
            ccolor = itemView.findViewById(R.id.colorText);

        }
    }
}
