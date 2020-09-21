package com.example.sunnyenterprise.model.ordersModel;

import com.google.gson.annotations.SerializedName;

public class Value {

    @SerializedName("BillingAddress")
    private Object mBillingAddress;
    @SerializedName("CancelReason")
    private Object mCancelReason;
    @SerializedName("CanceledDate")
    private Object mCanceledDate;
    @SerializedName("CanceledDateString")
    private String mCanceledDateString;
    @SerializedName("Color")
    private Object mColor;
    @SerializedName("ColorCode")
    private Object mColorCode;
    @SerializedName("ColorId")
    private Long mColorId;
    @SerializedName("Comment")
    private Object mComment;
    @SerializedName("ConsigneeName")
    private Object mConsigneeName;
    @SerializedName("couponCode")
    private Object mCouponCode;
    @SerializedName("CourierId")
    private Object mCourierId;
    @SerializedName("CreatedAt")
    private String mCreatedAt;
    @SerializedName("CreatedBy")
    private Long mCreatedBy;
    @SerializedName("Customer")
    private Object mCustomer;
    @SerializedName("CustomerId")
    private Long mCustomerId;
    @SerializedName("DealId")
    private Long mDealId;
    @SerializedName("DeliveredOn")
    private Object mDeliveredOn;
    @SerializedName("DeliveredOnString")
    private String mDeliveredOnString;
    @SerializedName("Discount")
    private Double mDiscount;
    @SerializedName("FeedbackId")
    private Long mFeedbackId;
    @SerializedName("feedbackImages")
    private Object mFeedbackImages;
    @SerializedName("GSTNumber")
    private Object mGSTNumber;
    @SerializedName("GrandTotal")
    private Double mGrandTotal;
    @SerializedName("Id")
    private Long mId;
    @SerializedName("ImageS3Url")
    private String mImageS3Url;
    @SerializedName("IsCancelled")
    private Boolean mIsCancelled;
    @SerializedName("IsFeedbackSubmitted")
    private Boolean mIsFeedbackSubmitted;
    @SerializedName("IsReplace")
    private Boolean mIsReplace;
    @SerializedName("Issue")
    private Object mIssue;
    @SerializedName("LastName")
    private Object mLastName;
    @SerializedName("ListPrice")
    private Double mListPrice;
    @SerializedName("Mobile")
    private Object mMobile;
    @SerializedName("OrderDate")
    private String mOrderDate;
    @SerializedName("OrderDateString")
    private String mOrderDateString;
    @SerializedName("OrderId")
    private Long mOrderId;
    @SerializedName("OriginalPrice")
    private Double mOriginalPrice;
    @SerializedName("OriginalRate")
    private Double mOriginalRate;
    @SerializedName("PaymentType")
    private Object mPaymentType;
    @SerializedName("Price")
    private Double mPrice;
    @SerializedName("ProductCurrentPrice")
    private Double mProductCurrentPrice;
    @SerializedName("ProductId")
    private Long mProductId;
    @SerializedName("ProductImage")
    private String mProductImage;
    @SerializedName("ProductMain")
    private Object mProductMain;
    @SerializedName("ProductMainId")
    private Long mProductMainId;
    @SerializedName("ProductName")
    private String mProductName;
    @SerializedName("PurchasePrice")
    private Double mPurchasePrice;
    @SerializedName("PurchaseRate")
    private Double mPurchaseRate;
    @SerializedName("Quantity")
    private Long mQuantity;
    @SerializedName("Rate")
    private Long mRate;
    @SerializedName("RelativeTime")
    private Object mRelativeTime;
    @SerializedName("ReplaceDate")
    private Object mReplaceDate;
    @SerializedName("ReplaceDateString")
    private String mReplaceDateString;
    @SerializedName("ReplacePickupDate")
    private Object mReplacePickupDate;
    @SerializedName("RepliedBy")
    private Long mRepliedBy;
    @SerializedName("SPrice")
    private Double mSPrice;
    @SerializedName("Seller")
    private Object mSeller;
    @SerializedName("SellerAddress")
    private Object mSellerAddress;
    @SerializedName("SellerId")
    private Long mSellerId;
    @SerializedName("SellerName")
    private Object mSellerName;
    @SerializedName("ShipRocketOrder")
    private Object mShipRocketOrder;
    @SerializedName("ShipRocketOrderId")
    private Long mShipRocketOrderId;
    @SerializedName("ShipRocketOrderTrackingUrl")
    private Object mShipRocketOrderTrackingUrl;
    @SerializedName("ShipmentId")
    private Long mShipmentId;
    @SerializedName("ShippingAddress")
    private Object mShippingAddress;
    @SerializedName("ShippingCharge")
    private Double mShippingCharge;
    @SerializedName("Size")
    private Object mSize;
    @SerializedName("SizeId")
    private Long mSizeId;
    @SerializedName("Sku")
    private Object mSku;
    @SerializedName("Slug")
    private String mSlug;
    @SerializedName("Status")
    private String mStatus;
    @SerializedName("StatusId")
    private Long mStatusId;
    @SerializedName("TotalAmount")
    private Double mTotalAmount;
    @SerializedName("UpdatedAt")
    private String mUpdatedAt;
    @SerializedName("UpdatedBy")
    private Long mUpdatedBy;
    @SerializedName("WallateBalance")
    private Double mWallateBalance;

    public Object getBillingAddress() {
        return mBillingAddress;
    }

    public void setBillingAddress(Object billingAddress) {
        mBillingAddress = billingAddress;
    }

    public Object getCancelReason() {
        return mCancelReason;
    }

    public void setCancelReason(Object cancelReason) {
        mCancelReason = cancelReason;
    }

    public Object getCanceledDate() {
        return mCanceledDate;
    }

    public void setCanceledDate(Object canceledDate) {
        mCanceledDate = canceledDate;
    }

    public String getCanceledDateString() {
        return mCanceledDateString;
    }

    public void setCanceledDateString(String canceledDateString) {
        mCanceledDateString = canceledDateString;
    }

    public Object getColor() {
        return mColor;
    }

    public void setColor(Object color) {
        mColor = color;
    }

    public Object getColorCode() {
        return mColorCode;
    }

    public void setColorCode(Object colorCode) {
        mColorCode = colorCode;
    }

    public Long getColorId() {
        return mColorId;
    }

    public void setColorId(Long colorId) {
        mColorId = colorId;
    }

    public Object getComment() {
        return mComment;
    }

    public void setComment(Object comment) {
        mComment = comment;
    }

    public Object getConsigneeName() {
        return mConsigneeName;
    }

    public void setConsigneeName(Object consigneeName) {
        mConsigneeName = consigneeName;
    }

    public Object getCouponCode() {
        return mCouponCode;
    }

    public void setCouponCode(Object couponCode) {
        mCouponCode = couponCode;
    }

    public Object getCourierId() {
        return mCourierId;
    }

    public void setCourierId(Object courierId) {
        mCourierId = courierId;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public Long getCreatedBy() {
        return mCreatedBy;
    }

    public void setCreatedBy(Long createdBy) {
        mCreatedBy = createdBy;
    }

    public Object getCustomer() {
        return mCustomer;
    }

    public void setCustomer(Object customer) {
        mCustomer = customer;
    }

    public Long getCustomerId() {
        return mCustomerId;
    }

    public void setCustomerId(Long customerId) {
        mCustomerId = customerId;
    }

    public Long getDealId() {
        return mDealId;
    }

    public void setDealId(Long dealId) {
        mDealId = dealId;
    }

    public Object getDeliveredOn() {
        return mDeliveredOn;
    }

    public void setDeliveredOn(Object deliveredOn) {
        mDeliveredOn = deliveredOn;
    }

    public String getDeliveredOnString() {
        return mDeliveredOnString;
    }

    public void setDeliveredOnString(String deliveredOnString) {
        mDeliveredOnString = deliveredOnString;
    }

    public Double getDiscount() {
        return mDiscount;
    }

    public void setDiscount(Double discount) {
        mDiscount = discount;
    }

    public Long getFeedbackId() {
        return mFeedbackId;
    }

    public void setFeedbackId(Long feedbackId) {
        mFeedbackId = feedbackId;
    }

    public Object getFeedbackImages() {
        return mFeedbackImages;
    }

    public void setFeedbackImages(Object feedbackImages) {
        mFeedbackImages = feedbackImages;
    }

    public Object getGSTNumber() {
        return mGSTNumber;
    }

    public void setGSTNumber(Object gSTNumber) {
        mGSTNumber = gSTNumber;
    }

    public Double getGrandTotal() {
        return mGrandTotal;
    }

    public void setGrandTotal(Double grandTotal) {
        mGrandTotal = grandTotal;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getImageS3Url() {
        return mImageS3Url;
    }

    public void setImageS3Url(String imageS3Url) {
        mImageS3Url = imageS3Url;
    }

    public Boolean getIsCancelled() {
        return mIsCancelled;
    }

    public void setIsCancelled(Boolean isCancelled) {
        mIsCancelled = isCancelled;
    }

    public Boolean getIsFeedbackSubmitted() {
        return mIsFeedbackSubmitted;
    }

    public void setIsFeedbackSubmitted(Boolean isFeedbackSubmitted) {
        mIsFeedbackSubmitted = isFeedbackSubmitted;
    }

    public Boolean getIsReplace() {
        return mIsReplace;
    }

    public void setIsReplace(Boolean isReplace) {
        mIsReplace = isReplace;
    }

    public Object getIssue() {
        return mIssue;
    }

    public void setIssue(Object issue) {
        mIssue = issue;
    }

    public Object getLastName() {
        return mLastName;
    }

    public void setLastName(Object lastName) {
        mLastName = lastName;
    }

    public Double getListPrice() {
        return mListPrice;
    }

    public void setListPrice(Double listPrice) {
        mListPrice = listPrice;
    }

    public Object getMobile() {
        return mMobile;
    }

    public void setMobile(Object mobile) {
        mMobile = mobile;
    }

    public String getOrderDate() {
        return mOrderDate;
    }

    public void setOrderDate(String orderDate) {
        mOrderDate = orderDate;
    }

    public String getOrderDateString() {
        return mOrderDateString;
    }

    public void setOrderDateString(String orderDateString) {
        mOrderDateString = orderDateString;
    }

    public Long getOrderId() {
        return mOrderId;
    }

    public void setOrderId(Long orderId) {
        mOrderId = orderId;
    }

    public Double getOriginalPrice() {
        return mOriginalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        mOriginalPrice = originalPrice;
    }

    public Double getOriginalRate() {
        return mOriginalRate;
    }

    public void setOriginalRate(Double originalRate) {
        mOriginalRate = originalRate;
    }

    public Object getPaymentType() {
        return mPaymentType;
    }

    public void setPaymentType(Object paymentType) {
        mPaymentType = paymentType;
    }

    public Double getPrice() {
        return mPrice;
    }

    public void setPrice(Double price) {
        mPrice = price;
    }

    public Double getProductCurrentPrice() {
        return mProductCurrentPrice;
    }

    public void setProductCurrentPrice(Double productCurrentPrice) {
        mProductCurrentPrice = productCurrentPrice;
    }

    public Long getProductId() {
        return mProductId;
    }

    public void setProductId(Long productId) {
        mProductId = productId;
    }

    public String getProductImage() {
        return mProductImage;
    }

    public void setProductImage(String productImage) {
        mProductImage = productImage;
    }

    public Object getProductMain() {
        return mProductMain;
    }

    public void setProductMain(Object productMain) {
        mProductMain = productMain;
    }

    public Long getProductMainId() {
        return mProductMainId;
    }

    public void setProductMainId(Long productMainId) {
        mProductMainId = productMainId;
    }

    public String getProductName() {
        return mProductName;
    }

    public void setProductName(String productName) {
        mProductName = productName;
    }

    public Double getPurchasePrice() {
        return mPurchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        mPurchasePrice = purchasePrice;
    }

    public Double getPurchaseRate() {
        return mPurchaseRate;
    }

    public void setPurchaseRate(Double purchaseRate) {
        mPurchaseRate = purchaseRate;
    }

    public Long getQuantity() {
        return mQuantity;
    }

    public void setQuantity(Long quantity) {
        mQuantity = quantity;
    }

    public Long getRate() {
        return mRate;
    }

    public void setRate(Long rate) {
        mRate = rate;
    }

    public Object getRelativeTime() {
        return mRelativeTime;
    }

    public void setRelativeTime(Object relativeTime) {
        mRelativeTime = relativeTime;
    }

    public Object getReplaceDate() {
        return mReplaceDate;
    }

    public void setReplaceDate(Object replaceDate) {
        mReplaceDate = replaceDate;
    }

    public String getReplaceDateString() {
        return mReplaceDateString;
    }

    public void setReplaceDateString(String replaceDateString) {
        mReplaceDateString = replaceDateString;
    }

    public Object getReplacePickupDate() {
        return mReplacePickupDate;
    }

    public void setReplacePickupDate(Object replacePickupDate) {
        mReplacePickupDate = replacePickupDate;
    }

    public Long getRepliedBy() {
        return mRepliedBy;
    }

    public void setRepliedBy(Long repliedBy) {
        mRepliedBy = repliedBy;
    }

    public Double getSPrice() {
        return mSPrice;
    }

    public void setSPrice(Double sPrice) {
        mSPrice = sPrice;
    }

    public Object getSeller() {
        return mSeller;
    }

    public void setSeller(Object seller) {
        mSeller = seller;
    }

    public Object getSellerAddress() {
        return mSellerAddress;
    }

    public void setSellerAddress(Object sellerAddress) {
        mSellerAddress = sellerAddress;
    }

    public Long getSellerId() {
        return mSellerId;
    }

    public void setSellerId(Long sellerId) {
        mSellerId = sellerId;
    }

    public Object getSellerName() {
        return mSellerName;
    }

    public void setSellerName(Object sellerName) {
        mSellerName = sellerName;
    }

    public Object getShipRocketOrder() {
        return mShipRocketOrder;
    }

    public void setShipRocketOrder(Object shipRocketOrder) {
        mShipRocketOrder = shipRocketOrder;
    }

    public Long getShipRocketOrderId() {
        return mShipRocketOrderId;
    }

    public void setShipRocketOrderId(Long shipRocketOrderId) {
        mShipRocketOrderId = shipRocketOrderId;
    }

    public Object getShipRocketOrderTrackingUrl() {
        return mShipRocketOrderTrackingUrl;
    }

    public void setShipRocketOrderTrackingUrl(Object shipRocketOrderTrackingUrl) {
        mShipRocketOrderTrackingUrl = shipRocketOrderTrackingUrl;
    }

    public Long getShipmentId() {
        return mShipmentId;
    }

    public void setShipmentId(Long shipmentId) {
        mShipmentId = shipmentId;
    }

    public Object getShippingAddress() {
        return mShippingAddress;
    }

    public void setShippingAddress(Object shippingAddress) {
        mShippingAddress = shippingAddress;
    }

    public Double getShippingCharge() {
        return mShippingCharge;
    }

    public void setShippingCharge(Double shippingCharge) {
        mShippingCharge = shippingCharge;
    }

    public Object getSize() {
        return mSize;
    }

    public void setSize(Object size) {
        mSize = size;
    }

    public Long getSizeId() {
        return mSizeId;
    }

    public void setSizeId(Long sizeId) {
        mSizeId = sizeId;
    }

    public Object getSku() {
        return mSku;
    }

    public void setSku(Object sku) {
        mSku = sku;
    }

    public String getSlug() {
        return mSlug;
    }

    public void setSlug(String slug) {
        mSlug = slug;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public Long getStatusId() {
        return mStatusId;
    }

    public void setStatusId(Long statusId) {
        mStatusId = statusId;
    }

    public Double getTotalAmount() {
        return mTotalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        mTotalAmount = totalAmount;
    }

    public String getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        mUpdatedAt = updatedAt;
    }

    public Long getUpdatedBy() {
        return mUpdatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        mUpdatedBy = updatedBy;
    }

    public Double getWallateBalance() {
        return mWallateBalance;
    }

    public void setWallateBalance(Double wallateBalance) {
        mWallateBalance = wallateBalance;
    }

}
