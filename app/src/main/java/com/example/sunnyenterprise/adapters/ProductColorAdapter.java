package com.example.sunnyenterprise.adapters;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sunnyenterprise.R;
import com.example.sunnyenterprise.model.productDetailModel.Color;
import com.example.sunnyenterprise.model.productDetailModel.SingleProduct;
import com.example.sunnyenterprise.recyclerviewInterface.RecyclerViewClickInterface;

import java.util.List;

public class ProductColorAdapter extends RecyclerView.Adapter<ProductColorAdapter.ViewHolder> {

    List<Color> pList;
    LayoutInflater inflater;
    private RecyclerViewClickInterface recyclerViewClickInterface;
    SingleProduct singleProduct;

    public ProductColorAdapter(Context ctx, List<Color> pList, RecyclerViewClickInterface recyclerViewClickInterface) {
        this.pList = pList;
        this.inflater = LayoutInflater.from(ctx);
        this.recyclerViewClickInterface = recyclerViewClickInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.color_row_layout, parent, false);
        return new ProductColorAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (singleProduct.getSlug().equals(pList.get(position).getSlug())) {
            holder.radioButton.setChecked(true);
            holder.radioButton.setButtonTintList(
                    ColorStateList.valueOf(android.graphics.Color.parseColor("#"+pList.get(position).getCode()))
            );

        } else {
            holder.radioButton.setChecked(false);
        }
        holder.textView.setText(pList.get(position).getName());
        holder.rootLayout.setOnClickListener(view -> recyclerViewClickInterface.onItemClick(position, pList.get(position).getSlug()));
        holder.radioButton.setOnCheckedChangeListener((compoundButton, b) -> {
            recyclerViewClickInterface.onItemClick(position, pList.get(position).getSlug());
        });
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

    public class ViewHolder extends RecyclerView.ViewHolder {
        RadioButton radioButton;
        TextView textView;
        LinearLayout rootLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            radioButton = itemView.findViewById(R.id.radioButtonColor);
            textView = itemView.findViewById(R.id.textViewColorName);
            rootLayout = itemView.findViewById(R.id.root_layout);
        }
    }
}
