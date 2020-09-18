package com.example.sunnyenterprise.model.addCartModel;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddCart {
    @SerializedName("ProductId")
    @Expose
    private Long mProductId;

    @SerializedName("CustomerId")
    @Expose
    private Long mCustomerId;

    @SerializedName("sizeQuantities")
    @Expose
    private List<SizeQuantity> mSizeQuantities = null;

    public AddCart(Long mProductId, Long mCustomerId, ArrayList<SizeQuantity> mSizeQuantities) {
        this.mProductId = mProductId;
        this.mCustomerId = mCustomerId;
        this.mSizeQuantities = mSizeQuantities;
    }

    public Long getCustomerId() {
        return mCustomerId;
    }

    public void setCustomerId(Long customerId) {
        mCustomerId = customerId;
    }

    public Long getProductId() {
        return mProductId;
    }

    public void setProductId(Long productId) {
        mProductId = productId;
    }

    public List<SizeQuantity> getSizeQuantities() {
        return mSizeQuantities;
    }

    public void setSizeQuantities(List<SizeQuantity> sizeQuantities) {
        mSizeQuantities = sizeQuantities;
    }

    @Override
    public String toString() {
        return "AddCart{" +
                "mProductId=" + mProductId +
                ", mCustomerId=" + mCustomerId +
                ", mSizeQuantities=" + mSizeQuantities +
                '}';
    }
}
