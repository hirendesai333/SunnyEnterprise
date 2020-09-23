
package com.example.sunnyenterprise.model.placeOrderModel;

import com.google.gson.annotations.SerializedName;

public class ShippingCharges {

    @SerializedName("Id")
    private Long mId;
    @SerializedName("IsCod")
    private Boolean mIsCod;
    @SerializedName("MaxAmount")
    private Long mMaxAmount;
    @SerializedName("ShippingPrice")
    private Long mShippingPrice;

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Boolean getIsCod() {
        return mIsCod;
    }

    public void setIsCod(Boolean isCod) {
        mIsCod = isCod;
    }

    public Long getMaxAmount() {
        return mMaxAmount;
    }

    public void setMaxAmount(Long maxAmount) {
        mMaxAmount = maxAmount;
    }

    public Long getShippingPrice() {
        return mShippingPrice;
    }

    public void setShippingPrice(Long shippingPrice) {
        mShippingPrice = shippingPrice;
    }

}
