package com.example.sunnyenterprise.model.ordersModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Orders {

    @SerializedName("IsOffsetProvided")
    private Boolean mIsOffsetProvided;
    @SerializedName("IsPageProvided")
    private Boolean mIsPageProvided;
    @SerializedName("Limit")
    private Long mLimit;
    @SerializedName("Offset")
    private Long mOffset;
    @SerializedName("Page")
    private Long mPage;
    @SerializedName("PageSize")
    private Long mPageSize;
    @SerializedName("SortBy")
    private String mSortBy;
    @SerializedName("SortDirection")
    private Object mSortDirection;
    @SerializedName("TotalCount")
    private Long mTotalCount;
    @SerializedName("TotalRecords")
    private Long mTotalRecords;
    @SerializedName("Values")
    private List<Value> mValues;

    public Boolean getIsOffsetProvided() {
        return mIsOffsetProvided;
    }

    public void setIsOffsetProvided(Boolean isOffsetProvided) {
        mIsOffsetProvided = isOffsetProvided;
    }

    public Boolean getIsPageProvided() {
        return mIsPageProvided;
    }

    public void setIsPageProvided(Boolean isPageProvided) {
        mIsPageProvided = isPageProvided;
    }

    public Long getLimit() {
        return mLimit;
    }

    public void setLimit(Long limit) {
        mLimit = limit;
    }

    public Long getOffset() {
        return mOffset;
    }

    public void setOffset(Long offset) {
        mOffset = offset;
    }

    public Long getPage() {
        return mPage;
    }

    public void setPage(Long page) {
        mPage = page;
    }

    public Long getPageSize() {
        return mPageSize;
    }

    public void setPageSize(Long pageSize) {
        mPageSize = pageSize;
    }

    public String getSortBy() {
        return mSortBy;
    }

    public void setSortBy(String sortBy) {
        mSortBy = sortBy;
    }

    public Object getSortDirection() {
        return mSortDirection;
    }

    public void setSortDirection(Object sortDirection) {
        mSortDirection = sortDirection;
    }

    public Long getTotalCount() {
        return mTotalCount;
    }

    public void setTotalCount(Long totalCount) {
        mTotalCount = totalCount;
    }

    public Long getTotalRecords() {
        return mTotalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
        mTotalRecords = totalRecords;
    }

    public List<Value> getValues() {
        return mValues;
    }

    public void setValues(List<Value> values) {
        mValues = values;
    }

}
