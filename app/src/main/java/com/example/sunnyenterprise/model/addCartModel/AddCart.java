package com.example.sunnyenterprise.model.addCartModel;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddCart {

    @Expose
    @SerializedName("ProductId")
    private Long mProductId;

    @Expose
    @SerializedName("CustomerId")
    private Long mCustomerId;

    @Expose
    @SerializedName("sizeQuantities")
    private List<SizeQuantity> mSizeQuantities;

    public AddCart(Long mProductId, Long mCustomerId, List<SizeQuantity> mSizeQuantities    ) {
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

}
