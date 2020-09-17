package com.example.sunnyenterprise.model.cartListModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CartList {
    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("Quantity")
    @Expose
    private Integer quantity;
    @SerializedName("ProductMainId")
    @Expose
    private Integer productMainId;
    @SerializedName("ColorId")
    @Expose
    private Integer colorId;
    @SerializedName("ProductMain")
    @Expose
    private Object productMain;
    @SerializedName("Color")
    @Expose
    private String color;
    @SerializedName("ColorName")
    @Expose
    private String colorName;
    @SerializedName("Star")
    @Expose
    private Integer star;
    @SerializedName("Customer")
    @Expose
    private Object customer;
    @SerializedName("Email")
    @Expose
    private Object email;
    @SerializedName("Mobile")
    @Expose
    private Object mobile;
    @SerializedName("Price")
    @Expose
    private Double price;
    @SerializedName("ProductId")
    @Expose
    private Integer productId;
    @SerializedName("CurrentStock")
    @Expose
    private Integer currentStock;
    @SerializedName("MaxPrice")
    @Expose
    private Double maxPrice;
    @SerializedName("CustomerId")
    @Expose
    private Integer customerId;
    @SerializedName("AddedDate")
    @Expose
    private String addedDate;
    @SerializedName("SubTotal")
    @Expose
    private Double subTotal;
    @SerializedName("GrandTotal")
    @Expose
    private Double grandTotal;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("ImageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("SessionId")
    @Expose
    private Object sessionId;
    @SerializedName("Slug")
    @Expose
    private String slug;
    @SerializedName("TotalPrice")
    @Expose
    private Double totalPrice;
    @SerializedName("CartPrice")
    @Expose
    private Double cartPrice;
    @SerializedName("CurrentPrice")
    @Expose
    private Double currentPrice;
    @SerializedName("Size")
    @Expose
    private String size;
    @SerializedName("SizeCode")
    @Expose
    private String sizeCode;
    @SerializedName("SizeId")
    @Expose
    private Integer sizeId;
    @SerializedName("Discount")
    @Expose
    private Integer discount;
    @SerializedName("IsAvailableWishlist")
    @Expose
    private Boolean isAvailableWishlist;
    @SerializedName("DeliveryCharge")
    @Expose
    private Double deliveryCharge;
    @SerializedName("sizeQuantities")
    @Expose
    private Object sizeQuantities;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getProductMainId() {
        return productMainId;
    }

    public void setProductMainId(Integer productMainId) {
        this.productMainId = productMainId;
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public Object getProductMain() {
        return productMain;
    }

    public void setProductMain(Object productMain) {
        this.productMain = productMain;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Object getCustomer() {
        return customer;
    }

    public void setCustomer(Object customer) {
        this.customer = customer;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public Object getMobile() {
        return mobile;
    }

    public void setMobile(Object mobile) {
        this.mobile = mobile;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(Integer currentStock) {
        this.currentStock = currentStock;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Object getSessionId() {
        return sessionId;
    }

    public void setSessionId(Object sessionId) {
        this.sessionId = sessionId;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(Double cartPrice) {
        this.cartPrice = cartPrice;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSizeCode() {
        return sizeCode;
    }

    public void setSizeCode(String sizeCode) {
        this.sizeCode = sizeCode;
    }

    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Boolean getIsAvailableWishlist() {
        return isAvailableWishlist;
    }

    public void setIsAvailableWishlist(Boolean isAvailableWishlist) {
        this.isAvailableWishlist = isAvailableWishlist;
    }

    public Double getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(Double deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    public Object getSizeQuantities() {
        return sizeQuantities;
    }

    public void setSizeQuantities(Object sizeQuantities) {
        this.sizeQuantities = sizeQuantities;
    }

}

