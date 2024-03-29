package com.example.sunnyenterprise.adapters;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sunnyenterprise.R;
import com.example.sunnyenterprise.model.productDetailModel.Color;
import com.example.sunnyenterprise.model.productDetailModel.SingleProduct;
import com.example.sunnyenterprise.recyclerviewInterface.OnColorClick;

import java.util.List;

public class ProductColorAdapter extends RecyclerView.Adapter<ProductColorAdapter.ViewHolder> {
    List<Color> pList;
    LayoutInflater inflater;
    OnColorClick onColorClick;
    SingleProduct singleProduct;

    public ProductColorAdapter(Context ctx, List<Color> pList, OnColorClick onColorClick) {
        this.pList = pList;
        this.inflater = LayoutInflater.from(ctx);
        this.onColorClick = onColorClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.color_row_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (singleProduct.getSlug().equals(pList.get(position).getSlug())) {
            holder.radioButton.setChecked(true);
            holder.radioButton.setButtonTintList(
                    ColorStateList.valueOf(android.graphics.Color.parseColor("#" + pList.get(position).getCode()))
            );
//            holder.colorView.setBackgroundColor(android.graphics.Color.parseColor("#"+ pList.get(position).getCode()));

        } else {
            holder.radioButton.setChecked(false);
        }
        holder.textView.setText(pList.get(position).getName());
        holder.rootLayout.setOnClickListener(view -> onColorClick.onItemClick(position, pList.get(position).getSlug()));
        holder.radioButton.setOnCheckedChangeListener((compoundButton, b) -> {
            onColorClick.onItemClick(position, pList.get(position).getSlug());
        });

        holder.colorView.setBackgroundColor(android.graphics.Color.parseColor("#" + pList.get(position).getCode()));

    }

    @Override
    public int getItemCount() {
        return pList.size();
    }

    public void setData(List<Color> pList, SingleProduct singleProduct) {
        this.pList = pList;
        this.singleProduct = singleProduct;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        RadioButton radioButton;
        TextView textView;
        LinearLayout rootLayout;
        TextView colorView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            radioButton = itemView.findViewById(R.id.radioButtonColor);
            textView = itemView.findViewById(R.id.textViewColorName);
            rootLayout = itemView.findViewById(R.id.root_layout);
            colorView = itemView.findViewById(R.id.colorVie);

        }
    }
}
