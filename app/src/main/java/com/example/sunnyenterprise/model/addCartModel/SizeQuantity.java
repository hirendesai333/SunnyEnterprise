package com.example.sunnyenterprise.model.addCartModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SizeQuantity {

    @Expose
    @SerializedName("SizeId")
    private Long mSizeId;

    @Expose
    @SerializedName("Quantity")
    private Long mQuantity;

    public SizeQuantity(Long mSizeId, Long mQuantity) {
        this.mSizeId = mSizeId;
        this.mQuantity = mQuantity;
    }

    public Long getQuantity() {
        return mQuantity;
    }

    public void setQuantity(Long quantity) {
        mQuantity = quantity;
    }

    public Long getSizeId() {
        return mSizeId;
    }

    public void setSizeId(Long sizeId) {
        mSizeId = sizeId;
    }

}
