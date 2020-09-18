package com.example.sunnyenterprise.model.addCartModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SizeQuantity {

    @SerializedName("SizeId")
    @Expose
    private Integer sizeId;
    @SerializedName("Quantity")
    @Expose
    private Integer quantity;

    public SizeQuantity(Integer sizeId, Integer quantity) {
        this.sizeId = sizeId;
        this.quantity = quantity;
    }

    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
