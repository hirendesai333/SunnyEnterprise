package com.example.sunnyenterprise.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Banner {

    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("Text")
    @Expose
    private String text;
    @SerializedName("ImgURL")
    @Expose
    private String imgURL;
    @SerializedName("Order")
    @Expose
    private Integer order;
    @SerializedName("Active")
    @Expose
    private Boolean active;
    @SerializedName("RedirectURL")
    @Expose
    private Object redirectURL;
    @SerializedName("ImageS3URL")
    @Expose
    private Object imageS3URL;
    @SerializedName("FileName")
    @Expose
    private Object fileName;
    @SerializedName("FilePath")
    @Expose
    private Object filePath;
    @SerializedName("CategoryId")
    @Expose
    private Integer categoryId;
    @SerializedName("ProductMainId")
    @Expose
    private Integer productMainId;
    @SerializedName("CategorySlug")
    @Expose
    private Object categorySlug;
    @SerializedName("IsContainProduct")
    @Expose
    private Boolean isContainProduct;
    @SerializedName("ProductId")
    @Expose
    private Integer productId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Object getRedirectURL() {
        return redirectURL;
    }

    public void setRedirectURL(Object redirectURL) {
        this.redirectURL = redirectURL;
    }

    public Object getImageS3URL() {
        return imageS3URL;
    }

    public void setImageS3URL(Object imageS3URL) {
        this.imageS3URL = imageS3URL;
    }

    public Object getFileName() {
        return fileName;
    }

    public void setFileName(Object fileName) {
        this.fileName = fileName;
    }

    public Object getFilePath() {
        return filePath;
    }

    public void setFilePath(Object filePath) {
        this.filePath = filePath;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getProductMainId() {
        return productMainId;
    }

    public void setProductMainId(Integer productMainId) {
        this.productMainId = productMainId;
    }

    public Object getCategorySlug() {
        return categorySlug;
    }

    public void setCategorySlug(Object categorySlug) {
        this.categorySlug = categorySlug;
    }

    public Boolean getIsContainProduct() {
        return isContainProduct;
    }

    public void setIsContainProduct(Boolean isContainProduct) {
        this.isContainProduct = isContainProduct;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

}