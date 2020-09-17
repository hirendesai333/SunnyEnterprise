
package com.example.sunnyenterprise.model.productModel;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("TotalRecords")
    @Expose
    private Integer totalRecords;
    @SerializedName("Values")
    @Expose
    private List<Value> values = null;
    @SerializedName("Offset")
    @Expose
    private Integer offset;
    @SerializedName("Limit")
    @Expose
    private Integer limit;
    @SerializedName("IsOffsetProvided")
    @Expose
    private Boolean isOffsetProvided;
    @SerializedName("Page")
    @Expose
    private Integer page;
    @SerializedName("PageSize")
    @Expose
    private Integer pageSize;
    @SerializedName("SortBy")
    @Expose
    private String sortBy;
    @SerializedName("TotalCount")
    @Expose
    private Integer totalCount;
    @SerializedName("SortDirection")
    @Expose
    private Object sortDirection;
    @SerializedName("IsPageProvided")
    @Expose
    private Boolean isPageProvided;

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Boolean getIsOffsetProvided() {
        return isOffsetProvided;
    }

    public void setIsOffsetProvided(Boolean isOffsetProvided) {
        this.isOffsetProvided = isOffsetProvided;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Object getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(Object sortDirection) {
        this.sortDirection = sortDirection;
    }

    public Boolean getIsPageProvided() {
        return isPageProvided;
    }

    public void setIsPageProvided(Boolean isPageProvided) {
        this.isPageProvided = isPageProvided;
    }


}
