package com.example.sunnyenterprise.adapters;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sunnyenterprise.R;
import com.example.sunnyenterprise.model.productDetailModel.Size;
import com.example.sunnyenterprise.recyclerviewInterface.OnSizeClickInterface;

import java.util.List;

public class ProductSizeAdapter extends RecyclerView.Adapter<ProductSizeAdapter.ViewHolder> {
    public static List<Size> pList;
    LayoutInflater inflater;
    OnSizeClickInterface onSizeClickInterface;

    public ProductSizeAdapter(Context ctx, List<Size> pList, OnSizeClickInterface onSizeClickInterface) {
        this.pList = pList;
        this.inflater = LayoutInflater.from(ctx);
        this.onSizeClickInterface = onSizeClickInterface;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.size_row_layout, parent, false);
        return new ProductSizeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.checkBox.setText(pList.get(position).getCode());
        holder.checkBox.setOnCheckedChangeListener((compoundButton, b) -> {
            if (holder.editText.toString() == null) {
                Toast.makeText(inflater.getContext(), "please enter qty first!", Toast.LENGTH_SHORT).show();
            }else {
                if (holder.checkBox.isChecked()) {
                    onSizeClickInterface.onClickCheckbox(pList.get(position).getId(), holder.editText.getText());
                } else {
                    Toast.makeText(inflater.getContext(), "unchecked!", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    @Override
    public int getItemCount() {
        return pList.size();
    }

    public void setData(List<Size> pList) {
        this.pList = pList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        EditText editText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.checkbox);
            editText = itemView.findViewById(R.id.etQty);

        }
    }


}
