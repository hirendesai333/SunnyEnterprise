package com.example.sunnyenterprise.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sunnyenterprise.R;
import com.example.sunnyenterprise.model.productDetailModel.Color;
import com.example.sunnyenterprise.recyclerviewInterface.RecyclerViewClickInterface;

import java.util.List;

public class ProductColorAdapter extends RecyclerView.Adapter<ProductColorAdapter.ViewHolder> {
    List<Color> pList;
    LayoutInflater inflater;
    private RecyclerViewClickInterface recyclerViewClickInterface;

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
        holder.radioButton.setTextColor(
                android.graphics.Color.parseColor("#000000")
        );

        holder.textView.setText(pList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return pList.size();
    }

    public void setData(List<Color> pList) {
        this.pList = pList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RadioButton radioButton;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            radioButton = itemView.findViewById(R.id.radioButtonColor);
            textView = itemView.findViewById(R.id.textViewColorName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    recyclerViewClickInterface.onItemClick(getAdapterPosition());
                }
            });
        }
    }
}
