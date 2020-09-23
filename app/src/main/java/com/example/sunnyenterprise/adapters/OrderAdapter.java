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
import com.example.sunnyenterprise.activities.OrderDetailsActivity;
import com.example.sunnyenterprise.model.ordersModel.Value;
import com.squareup.picasso.Picasso;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {
    List<Value> valueList;
    Context context;

    public OrderAdapter(List<Value> valueList, Context mContext) {
        this.valueList = valueList;
        this.context = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_grid_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ctitle.setText(valueList.get(position).getProductName());
        holder.cTvQuantity.setText("  "+valueList.get(position).getQuantity());
        holder.ccolor.setText("no data");
        holder.cTvSize.setText("no data");
        Picasso.get()
                .load(valueList.get(position).getImageS3Url())
                .into(holder.cgridIcon);
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
        TextView ctitle, ccolor, cTvQuantity, cTvSize;
        ImageView cgridIcon;
        CardView constraintLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ctitle = itemView.findViewById(R.id.textViewAddToCart);
            cgridIcon = itemView.findViewById(R.id.imageViewAddToCart);
            ccolor = itemView.findViewById(R.id.colorText);
            cTvQuantity = itemView.findViewById(R.id.tvQuantity);
            cTvSize = itemView.findViewById(R.id.tvSize);
            constraintLayout = itemView.findViewById(R.id.parent_layout);

            itemView.setOnClickListener(view -> {
                Intent i = new Intent(view.getContext(),OrderDetailsActivity.class);
                i.putExtra("title",valueList.get(getAdapterPosition()).getId());
                view.getContext().startActivity(i);
            });

        }
    }
}
