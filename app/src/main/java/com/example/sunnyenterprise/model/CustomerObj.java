
package com.example.sunnyenterprise.model;

import com.google.gson.annotations.SerializedName;

public class CustomerObj {

    @SerializedName("CustomerId")
    private Long mCustomerId;

    public CustomerObj(Long mCustomerId) {
        this.mCustomerId = mCustomerId;
    }

    public Long getCustomerId() {
        return mCustomerId;
    }

    public void setCustomerId(Long customerId) {
        mCustomerId = customerId;
    }

}
