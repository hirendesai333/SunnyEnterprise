
package com.example.sunnyenterprise.model.productDetailModel;

import com.google.gson.annotations.SerializedName;
public class Size {

    @SerializedName("Code")
    private String mCode;
    @SerializedName("Id")
    private Long mId;
    @SerializedName("IsAvailable")
    private Boolean mIsAvailable;
    @SerializedName("IsFilter")
    private Boolean mIsFilter;
    @SerializedName("Name")
    private String mName;
    @SerializedName("ProductMainId")
    private Long mProductMainId;
    @SerializedName("Slug")
    private Object mSlug;

    public String getCode() {
        return mCode;
    }

    public void setCode(String code) {
        mCode = code;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Boolean getIsAvailable() {
        return mIsAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        mIsAvailable = isAvailable;
    }

    public Boolean getIsFilter() {
        return mIsFilter;
    }

    public void setIsFilter(Boolean isFilter) {
        mIsFilter = isFilter;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Long getProductMainId() {
        return mProductMainId;
    }

    public void setProductMainId(Long productMainId) {
        mProductMainId = productMainId;
    }

    public Object getSlug() {
        return mSlug;
    }

    public void setSlug(Object slug) {
        mSlug = slug;
    }

}
