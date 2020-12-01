package com.example.sunnyenterprise.adapters;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sunnyenterprise.R;
import com.example.sunnyenterprise.model.productDetailModel.Size;
import com.example.sunnyenterprise.recyclerviewInterface.OnSizeQtyClick;

import java.util.List;

public class ProductSizeAdapter extends RecyclerView.Adapter<ProductSizeAdapter.ViewHolder> {
    public static List<Size> pList;
    LayoutInflater inflater;
    OnSizeQtyClick onSizeQtyClick;

    public ProductSizeAdapter(
            Context ctx,
            List<Size> pList,
            OnSizeQtyClick onSizeQtyClick) {
        ProductSizeAdapter.pList = pList;
        this.inflater = LayoutInflater.from(ctx);
        this.onSizeQtyClick = onSizeQtyClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.size_row_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.checkBox.setText(pList.get(position).getCode());
        holder.checkBox.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                holder.editText.setVisibility(View.VISIBLE);
                onSizeQtyClick.onClickCheckbox(pList.get(position).getId());
            } else {
                onSizeQtyClick.deleteSelection(pList.get(position).getId());
                holder.editText.setVisibility(View.GONE);
                holder.editText.getText().clear();
            }
        });

        holder.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 0) {
                    holder.checkBox.setChecked(false);
                    holder.editText.setVisibility(View.GONE);
                    onSizeQtyClick.deleteSelection(pList.get(position).getId());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                onSizeQtyClick.onClickQty(holder.editText.getText(), pList.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return pList.size();
    }

    public void setData(List<Size> pList) {
        ProductSizeAdapter.pList = pList;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        EditText editText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.checkbox);
            editText = itemView.findViewById(R.id.etQty);

        }
    }


}
