package com.example.sunnyenterprise.model.categoryModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("ImageURL")
    @Expose
    private String imageURL;
    @SerializedName("ImageS3URL")
    @Expose
    private Object imageS3URL;
    @SerializedName("ParentId")
    @Expose
    private Integer parentId;
    @SerializedName("CompanyId")
    @Expose
    private Integer companyId;
    @SerializedName("CompanyName")
    @Expose
    private Object companyName;
    @SerializedName("Level")
    @Expose
    private Integer level;
    @SerializedName("IsActive")
    @Expose
    private Boolean isActive;
    @SerializedName("IsContainProduct")
    @Expose
    private Boolean isContainProduct;
    @SerializedName("Tags")
    @Expose
    private Object tags;
    @SerializedName("ShortDescription")
    @Expose
    private Object shortDescription;
    @SerializedName("Description")
    @Expose
    private Object description;
    @SerializedName("Features")
    @Expose
    private Object features;
    @SerializedName("WarrantyInfo")
    @Expose
    private Object warrantyInfo;
    @SerializedName("CreatedBy")
    @Expose
    private Integer createdBy;
    @SerializedName("CreatedAt")
    @Expose
    private String createdAt;
    @SerializedName("UpdatedBy")
    @Expose
    private Integer updatedBy;
    @SerializedName("UpdatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("FileName")
    @Expose
    private Object fileName;
    @SerializedName("FilePath")
    @Expose
    private Object filePath;
    @SerializedName("SlugUrl")
    @Expose
    private String slugUrl;
    @SerializedName("Class")
    @Expose
    private Object _class;
    @SerializedName("ShowOnHomePage")
    @Expose
    private Boolean showOnHomePage;
    @SerializedName("SEOContent")
    @Expose
    private Object sEOContent;
    @SerializedName("BreadCrumbData")
    @Expose
    private Object breadCrumbData;
    @SerializedName("BreadCrumb")
    @Expose
    private Object breadCrumb;
    @SerializedName("MetaTitle")
    @Expose
    private Object metaTitle;
    @SerializedName("MetaDescription")
    @Expose
    private Object metaDescription;
    @SerializedName("ImageURL1")
    @Expose
    private Object imageURL1;
    @SerializedName("ImageURL2")
    @Expose
    private Object imageURL2;
    @SerializedName("IsFilter")
    @Expose
    private Boolean isFilter;
    @SerializedName("SizeGuideImage")
    @Expose
    private Object sizeGuideImage;
    @SerializedName("SizeGuideS3Image")
    @Expose
    private Object sizeGuideS3Image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Object getImageS3URL() {
        return imageS3URL;
    }

    public void setImageS3URL(Object imageS3URL) {
        this.imageS3URL = imageS3URL;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Object getCompanyName() {
        return companyName;
    }

    public void setCompanyName(Object companyName) {
        this.companyName = companyName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsContainProduct() {
        return isContainProduct;
    }

    public void setIsContainProduct(Boolean isContainProduct) {
        this.isContainProduct = isContainProduct;
    }

    public Object getTags() {
        return tags;
    }

    public void setTags(Object tags) {
        this.tags = tags;
    }

    public Object getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(Object shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Object getFeatures() {
        return features;
    }

    public void setFeatures(Object features) {
        this.features = features;
    }

    public Object getWarrantyInfo() {
        return warrantyInfo;
    }

    public void setWarrantyInfo(Object warrantyInfo) {
        this.warrantyInfo = warrantyInfo;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
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

    public String getSlugUrl() {
        return slugUrl;
    }

    public void setSlugUrl(String slugUrl) {
        this.slugUrl = slugUrl;
    }

    public Object getClass_() {
        return _class;
    }

    public void setClass_(Object _class) {
        this._class = _class;
    }

    public Boolean getShowOnHomePage() {
        return showOnHomePage;
    }

    public void setShowOnHomePage(Boolean showOnHomePage) {
        this.showOnHomePage = showOnHomePage;
    }

    public Object getSEOContent() {
        return sEOContent;
    }

    public void setSEOContent(Object sEOContent) {
        this.sEOContent = sEOContent;
    }

    public Object getBreadCrumbData() {
        return breadCrumbData;
    }

    public void setBreadCrumbData(Object breadCrumbData) {
        this.breadCrumbData = breadCrumbData;
    }

    public Object getBreadCrumb() {
        return breadCrumb;
    }

    public void setBreadCrumb(Object breadCrumb) {
        this.breadCrumb = breadCrumb;
    }

    public Object getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(Object metaTitle) {
        this.metaTitle = metaTitle;
    }

    public Object getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(Object metaDescription) {
        this.metaDescription = metaDescription;
    }

    public Object getImageURL1() {
        return imageURL1;
    }

    public void setImageURL1(Object imageURL1) {
        this.imageURL1 = imageURL1;
    }

    public Object getImageURL2() {
        return imageURL2;
    }

    public void setImageURL2(Object imageURL2) {
        this.imageURL2 = imageURL2;
    }

    public Boolean getIsFilter() {
        return isFilter;
    }

    public void setIsFilter(Boolean isFilter) {
        this.isFilter = isFilter;
    }

    public Object getSizeGuideImage() {
        return sizeGuideImage;
    }

    public void setSizeGuideImage(Object sizeGuideImage) {
        this.sizeGuideImage = sizeGuideImage;
    }

    public Object getSizeGuideS3Image() {
        return sizeGuideS3Image;
    }

    public void setSizeGuideS3Image(Object sizeGuideS3Image) {
        this.sizeGuideS3Image = sizeGuideS3Image;
    }
}
