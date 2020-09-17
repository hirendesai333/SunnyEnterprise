
package com.example.sunnyenterprise.model.productDetailModel;

import com.google.gson.annotations.SerializedName;

public class ProductDetails {

    @SerializedName("SingleProduct")
    private SingleProduct mSingleProduct;

    public SingleProduct getSingleProduct() {
        return mSingleProduct;
    }

    public void setSingleProduct(SingleProduct singleProduct) {
        mSingleProduct = singleProduct;
    }

}
