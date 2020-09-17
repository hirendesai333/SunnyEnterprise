package com.example.sunnyenterprise.model.productModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Value {
    @SerializedName("IsSelected")
    @Expose
    private Boolean isSelected;
    @SerializedName("IsProductInOffer")
    @Expose
    private Boolean isProductInOffer;
    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("Productid")
    @Expose
    private Integer productid;
    @SerializedName("CategoryId")
    @Expose
    private Integer categoryId;
    @SerializedName("OfferId")
    @Expose
    private Integer offerId;
    @SerializedName("DealId")
    @Expose
    private Integer dealId;
    @SerializedName("NewArrivalsId")
    @Expose
    private Integer newArrivalsId;
    @SerializedName("IsFeatured")
    @Expose
    private Boolean isFeatured;
    @SerializedName("Category")
    @Expose
    private String category;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("MainProduct")
    @Expose
    private Object mainProduct;
    @SerializedName("Description")
    @Expose
    private Object description;
    @SerializedName("Features")
    @Expose
    private Object features;
    @SerializedName("WarrantyInfo")
    @Expose
    private Object warrantyInfo;
    @SerializedName("ImageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("Star")
    @Expose
    private Double star;
    @SerializedName("Sku")
    @Expose
    private String sku;
    @SerializedName("ColorId")
    @Expose
    private Integer colorId;
    @SerializedName("Value")
    @Expose
    private Object value;
    @SerializedName("DefaultProductId")
    @Expose
    private Integer defaultProductId;
    @SerializedName("Color")
    @Expose
    private String color;
    @SerializedName("ColorCode")
    @Expose
    private String colorCode;
    @SerializedName("CurrentStock")
    @Expose
    private Integer currentStock;
    @SerializedName("Slug")
    @Expose
    private String slug;
    @SerializedName("Price")
    @Expose
    private Double price;
    @SerializedName("MaxPrice")
    @Expose
    private Double maxPrice;
    @SerializedName("imageS3URL")
    @Expose
    private Object imageS3URL;
    @SerializedName("ShortDescription")
    @Expose
    private Object shortDescription;
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
    @SerializedName("Height")
    @Expose
    private Double height;
    @SerializedName("Width")
    @Expose
    private Double width;
    @SerializedName("Length")
    @Expose
    private Double length;
    @SerializedName("ProductWeight")
    @Expose
    private Double productWeight;
    @SerializedName("ShipmentWeight")
    @Expose
    private Double shipmentWeight;
    @SerializedName("ProductMainId")
    @Expose
    private Integer productMainId;
    @SerializedName("Discount")
    @Expose
    private Integer discount;
    @SerializedName("Seller")
    @Expose
    private Object seller;
    @SerializedName("MetaTitle")
    @Expose
    private Object metaTitle;
    @SerializedName("MetaDescription")
    @Expose
    private Object metaDescription;
    @SerializedName("JSONLD")
    @Expose
    private Object jSONLD;
    @SerializedName("ColorList")
    @Expose
    private Object colorList;
    @SerializedName("IsSales")
    @Expose
    private Boolean isSales;
    @SerializedName("IsNewProduct")
    @Expose
    private Boolean isNewProduct;
    @SerializedName("IsPopuler")
    @Expose
    private Boolean isPopuler;
    @SerializedName("productImages")
    @Expose
    private Object productImages;
    @SerializedName("productVideos")
    @Expose
    private Object productVideos;
    @SerializedName("sizes")
    @Expose
    private Object sizes;
    @SerializedName("colors")
    @Expose
    private Object colors;
    @SerializedName("SizeGuide")
    @Expose
    private Object sizeGuide;
    @SerializedName("ProductImage")
    @Expose
    private Object productImage;
    @SerializedName("product")
    @Expose
    private Object product;
    @SerializedName("abstractproduct")
    @Expose
    private Object abstractproduct;
    @SerializedName("IsAvailableCart")
    @Expose
    private Boolean isAvailableCart;
    @SerializedName("IsAvailableWishlist")
    @Expose
    private Boolean isAvailableWishlist;
    @SerializedName("PriceAfterDiscount")
    @Expose
    private Double priceAfterDiscount;
    @SerializedName("BreadCrumbData")
    @Expose
    private Object breadCrumbData;
    @SerializedName("BreadCrumb")
    @Expose
    private Object breadCrumb;
    @SerializedName("Percentage")
    @Expose
    private Integer percentage;
    @SerializedName("DiscountPer")
    @Expose
    private Double discountPer;
    @SerializedName("Count")
    @Expose
    private Integer count;
    @SerializedName("SellerId")
    @Expose
    private Integer sellerId;
    @SerializedName("CustomerId")
    @Expose
    private Integer customerId;
    @SerializedName("CategorySlug")
    @Expose
    private Object categorySlug;
    @SerializedName("IsinWishlist")
    @Expose
    private Boolean isinWishlist;
    @SerializedName("SalesCount")
    @Expose
    private Integer salesCount;
    @SerializedName("StarWidth")
    @Expose
    private Double starWidth;
    @SerializedName("Quantity")
    @Expose
    private Integer quantity;
    @SerializedName("Proid")
    @Expose
    private Integer proid;
    @SerializedName("SizeId")
    @Expose
    private Integer sizeId;
    @SerializedName("Size")
    @Expose
    private String size;
    @SerializedName("SizeCode")
    @Expose
    private Object sizeCode;
    @SerializedName("ImageUrl1")
    @Expose
    private Object imageUrl1;
    @SerializedName("ImageUrl2")
    @Expose
    private Object imageUrl2;
    @SerializedName("ImageUrl3")
    @Expose
    private Object imageUrl3;
    @SerializedName("ImageUrl4")
    @Expose
    private Object imageUrl4;
    @SerializedName("Feedbackcount")
    @Expose
    private Integer feedbackcount;
    @SerializedName("ProductSalesCountMessage")
    @Expose
    private Object productSalesCountMessage;

    public Boolean getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(Boolean isSelected) {
        this.isSelected = isSelected;
    }

    public Boolean getIsProductInOffer() {
        return isProductInOffer;
    }

    public void setIsProductInOffer(Boolean isProductInOffer) {
        this.isProductInOffer = isProductInOffer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getOfferId() {
        return offerId;
    }

    public void setOfferId(Integer offerId) {
        this.offerId = offerId;
    }

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    public Integer getNewArrivalsId() {
        return newArrivalsId;
    }

    public void setNewArrivalsId(Integer newArrivalsId) {
        this.newArrivalsId = newArrivalsId;
    }

    public Boolean getIsFeatured() {
        return isFeatured;
    }

    public void setIsFeatured(Boolean isFeatured) {
        this.isFeatured = isFeatured;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getMainProduct() {
        return mainProduct;
    }

    public void setMainProduct(Object mainProduct) {
        this.mainProduct = mainProduct;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Double getStar() {
        return star;
    }

    public void setStar(Double star) {
        this.star = star;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Integer getDefaultProductId() {
        return defaultProductId;
    }

    public void setDefaultProductId(Integer defaultProductId) {
        this.defaultProductId = defaultProductId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public Integer getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(Integer currentStock) {
        this.currentStock = currentStock;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Object getImageS3URL() {
        return imageS3URL;
    }

    public void setImageS3URL(Object imageS3URL) {
        this.imageS3URL = imageS3URL;
    }

    public Object getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(Object shortDescription) {
        this.shortDescription = shortDescription;
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

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(Double productWeight) {
        this.productWeight = productWeight;
    }

    public Double getShipmentWeight() {
        return shipmentWeight;
    }

    public void setShipmentWeight(Double shipmentWeight) {
        this.shipmentWeight = shipmentWeight;
    }

    public Integer getProductMainId() {
        return productMainId;
    }

    public void setProductMainId(Integer productMainId) {
        this.productMainId = productMainId;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Object getSeller() {
        return seller;
    }

    public void setSeller(Object seller) {
        this.seller = seller;
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

    public Object getJSONLD() {
        return jSONLD;
    }

    public void setJSONLD(Object jSONLD) {
        this.jSONLD = jSONLD;
    }

    public Object getColorList() {
        return colorList;
    }

    public void setColorList(Object colorList) {
        this.colorList = colorList;
    }

    public Boolean getIsSales() {
        return isSales;
    }

    public void setIsSales(Boolean isSales) {
        this.isSales = isSales;
    }

    public Boolean getIsNewProduct() {
        return isNewProduct;
    }

    public void setIsNewProduct(Boolean isNewProduct) {
        this.isNewProduct = isNewProduct;
    }

    public Boolean getIsPopuler() {
        return isPopuler;
    }

    public void setIsPopuler(Boolean isPopuler) {
        this.isPopuler = isPopuler;
    }

    public Object getProductImages() {
        return productImages;
    }

    public void setProductImages(Object productImages) {
        this.productImages = productImages;
    }

    public Object getProductVideos() {
        return productVideos;
    }

    public void setProductVideos(Object productVideos) {
        this.productVideos = productVideos;
    }

    public Object getSizes() {
        return sizes;
    }

    public void setSizes(Object sizes) {
        this.sizes = sizes;
    }

    public Object getColors() {
        return colors;
    }

    public void setColors(Object colors) {
        this.colors = colors;
    }

    public Object getSizeGuide() {
        return sizeGuide;
    }

    public void setSizeGuide(Object sizeGuide) {
        this.sizeGuide = sizeGuide;
    }

    public Object getProductImage() {
        return productImage;
    }

    public void setProductImage(Object productImage) {
        this.productImage = productImage;
    }

    public Object getProduct() {
        return product;
    }

    public void setProduct(Object product) {
        this.product = product;
    }

    public Object getAbstractproduct() {
        return abstractproduct;
    }

    public void setAbstractproduct(Object abstractproduct) {
        this.abstractproduct = abstractproduct;
    }

    public Boolean getIsAvailableCart() {
        return isAvailableCart;
    }

    public void setIsAvailableCart(Boolean isAvailableCart) {
        this.isAvailableCart = isAvailableCart;
    }

    public Boolean getIsAvailableWishlist() {
        return isAvailableWishlist;
    }

    public void setIsAvailableWishlist(Boolean isAvailableWishlist) {
        this.isAvailableWishlist = isAvailableWishlist;
    }

    public Double getPriceAfterDiscount() {
        return priceAfterDiscount;
    }

    public void setPriceAfterDiscount(Double priceAfterDiscount) {
        this.priceAfterDiscount = priceAfterDiscount;
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

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public Double getDiscountPer() {
        return discountPer;
    }

    public void setDiscountPer(Double discountPer) {
        this.discountPer = discountPer;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Object getCategorySlug() {
        return categorySlug;
    }

    public void setCategorySlug(Object categorySlug) {
        this.categorySlug = categorySlug;
    }

    public Boolean getIsinWishlist() {
        return isinWishlist;
    }

    public void setIsinWishlist(Boolean isinWishlist) {
        this.isinWishlist = isinWishlist;
    }

    public Integer getSalesCount() {
        return salesCount;
    }

    public void setSalesCount(Integer salesCount) {
        this.salesCount = salesCount;
    }

    public Double getStarWidth() {
        return starWidth;
    }

    public void setStarWidth(Double starWidth) {
        this.starWidth = starWidth;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }

    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Object getSizeCode() {
        return sizeCode;
    }

    public void setSizeCode(Object sizeCode) {
        this.sizeCode = sizeCode;
    }

    public Object getImageUrl1() {
        return imageUrl1;
    }

    public void setImageUrl1(Object imageUrl1) {
        this.imageUrl1 = imageUrl1;
    }

    public Object getImageUrl2() {
        return imageUrl2;
    }

    public void setImageUrl2(Object imageUrl2) {
        this.imageUrl2 = imageUrl2;
    }

    public Object getImageUrl3() {
        return imageUrl3;
    }

    public void setImageUrl3(Object imageUrl3) {
        this.imageUrl3 = imageUrl3;
    }

    public Object getImageUrl4() {
        return imageUrl4;
    }

    public void setImageUrl4(Object imageUrl4) {
        this.imageUrl4 = imageUrl4;
    }

    public Integer getFeedbackcount() {
        return feedbackcount;
    }

    public void setFeedbackcount(Integer feedbackcount) {
        this.feedbackcount = feedbackcount;
    }

    public Object getProductSalesCountMessage() {
        return productSalesCountMessage;
    }

    public void setProductSalesCountMessage(Object productSalesCountMessage) {
        this.productSalesCountMessage = productSalesCountMessage;
    }
}
