
package com.example.sunnyenterprise.model.productDetailModel;

import com.google.gson.annotations.SerializedName;

public class Color {

    @SerializedName("Code")
    private String mCode;
    @SerializedName("Id")
    private Long mId;
    @SerializedName("IsFilter")
    private Boolean mIsFilter;
    @SerializedName("Name")
    private String mName;
    @SerializedName("Slug")
    private String mSlug;

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

    public String getSlug() {
        return mSlug;
    }

    public void setSlug(String slug) {
        mSlug = slug;
    }

}
