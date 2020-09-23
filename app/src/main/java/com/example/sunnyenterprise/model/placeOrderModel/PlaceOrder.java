
package com.example.sunnyenterprise.model.placeOrderModel;


import com.google.gson.annotations.SerializedName;

public class PlaceOrder {

    @SerializedName("Code")
    private Long mCode;
    @SerializedName("IsSuccessStatusCode")
    private Boolean mIsSuccessStatusCode;
    @SerializedName("IsValid")
    private Boolean mIsValid;
    @SerializedName("Item")
    private Item mItem;
    @SerializedName("Message")
    private String mMessage;

    public Long getCode() {
        return mCode;
    }

    public void setCode(Long code) {
        mCode = code;
    }

    public Boolean getIsSuccessStatusCode() {
        return mIsSuccessStatusCode;
    }

    public void setIsSuccessStatusCode(Boolean isSuccessStatusCode) {
        mIsSuccessStatusCode = isSuccessStatusCode;
    }

    public Boolean getIsValid() {
        return mIsValid;
    }

    public void setIsValid(Boolean isValid) {
        mIsValid = isValid;
    }

    public Item getItem() {
        return mItem;
    }

    public void setItem(Item item) {
        mItem = item;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

}
