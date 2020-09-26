package com.example.sunnyenterprise.recyclerviewInterface;

import android.text.Editable;

public interface OnSizeQtyClick {
    void onClickQty(Editable Qty, int id);
    void onClickCheckbox(int id);
    void deleteSelection(int id);
}