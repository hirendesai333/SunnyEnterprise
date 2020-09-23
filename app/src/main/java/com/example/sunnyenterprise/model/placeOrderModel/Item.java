
package com.example.sunnyenterprise.model.placeOrderModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Item {

    @SerializedName("Address")
    private Object mAddress;
    @SerializedName("AddressBilling")
    private Object mAddressBilling;
    @SerializedName("BillingAddress")
    private Object mBillingAddress;
    @SerializedName("BillingCity")
    private Object mBillingCity;
    @SerializedName("BillingConsigneeName")
    private Object mBillingConsigneeName;
    @SerializedName("BillingCountry")
    private Object mBillingCountry;
    @SerializedName("BillingEmail")
    private Object mBillingEmail;
    @SerializedName("BillingLandmark")
    private Object mBillingLandmark;
    @SerializedName("BillingLastName")
    private Object mBillingLastName;
    @SerializedName("BillingMobile")
    private Object mBillingMobile;
    @SerializedName("BillingPincode")
    private Object mBillingPincode;
    @SerializedName("BillingState")
    private Object mBillingState;
    @SerializedName("CGST")
    private Long mCGST;
    @SerializedName("cartItems")
    private List<Object> mCartItems;
    @SerializedName("City")
    private Object mCity;
    @SerializedName("ColorName")
    private Object mColorName;
    @SerializedName("ConsigneeName")
    private Object mConsigneeName;
    @SerializedName("Country")
    private Object mCountry;
    @SerializedName("CouponCode")
    private Object mCouponCode;
    @SerializedName("CouponCodeId")
    private Object mCouponCodeId;
    @SerializedName("couponItem")
    private List<Object> mCouponItem;
    @SerializedName("CouponName")
    private Object mCouponName;
    @SerializedName("CourierId")
    private Long mCourierId;
    @SerializedName("CreatedAt")
    private String mCreatedAt;
    @SerializedName("CreatedBy")
    private Long mCreatedBy;
    @SerializedName("CreatedDateString")
    private String mCreatedDateString;
    @SerializedName("CurrentBalance")
    private Long mCurrentBalance;
    @SerializedName("Customer")
    private Object mCustomer;
    @SerializedName("CustomerId")
    private Long mCustomerId;
    @SerializedName("CustomerName")
    private Object mCustomerName;
    @SerializedName("DeliveredOn")
    private Object mDeliveredOn;
    @SerializedName("Discount")
    private Long mDiscount;
    @SerializedName("Email")
    private Object mEmail;
    @SerializedName("FullAddress")
    private String mFullAddress;
    @SerializedName("GST")
    private Long mGST;
    @SerializedName("GSTNumber")
    private Object mGSTNumber;
    @SerializedName("Height")
    private Long mHeight;
    @SerializedName("IGST")
    private Long mIGST;
    @SerializedName("Id")
    private Long mId;
    @SerializedName("ImageUrl")
    private Object mImageUrl;
    @SerializedName("InvoiceNumber")
    private String mInvoiceNumber;
    @SerializedName("IsWallateBalanceApply")
    private Boolean mIsWallateBalanceApply;
    @SerializedName("Landmark")
    private Object mLandmark;
    @SerializedName("LastName")
    private Object mLastName;
    @SerializedName("Length")
    private Long mLength;
    @SerializedName("Mobile")
    private Object mMobile;
    @SerializedName("NetSales")
    private Long mNetSales;
    @SerializedName("OrderDate")
    private String mOrderDate;
    @SerializedName("OrderDateString")
    private String mOrderDateString;
    @SerializedName("orderDetails")
    private Object mOrderDetails;
    @SerializedName("OriginalPrice")
    private Long mOriginalPrice;
    @SerializedName("payment")
    private Object mPayment;
    @SerializedName("PaymentId")
    private Object mPaymentId;
    @SerializedName("PaymentMode")
    private Object mPaymentMode;
    @SerializedName("PaymentType")
    private Object mPaymentType;
    @SerializedName("Pincode")
    private Object mPincode;
    @SerializedName("Price")
    private Long mPrice;
    @SerializedName("Product")
    private Object mProduct;
    @SerializedName("ProductName")
    private Object mProductName;
    @SerializedName("Profit")
    private Long mProfit;
    @SerializedName("PurchasePrice")
    private Long mPurchasePrice;
    @SerializedName("PurchaseRate")
    private Long mPurchaseRate;
    @SerializedName("Quantity")
    private Long mQuantity;
    @SerializedName("RawPrice")
    private Long mRawPrice;
    @SerializedName("SGST")
    private Long mSGST;
    @SerializedName("SKU")
    private Object mSKU;
    @SerializedName("Sales")
    private Long mSales;
    @SerializedName("selected")
    private Object mSelected;
    @SerializedName("SellerAddress")
    private Object mSellerAddress;
    @SerializedName("SellerName")
    private Object mSellerName;
    @SerializedName("ShipRocketOrderId")
    private Long mShipRocketOrderId;
    @SerializedName("ShipmentId")
    private Long mShipmentId;
    @SerializedName("ShippingAddress")
    private Object mShippingAddress;
    @SerializedName("ShippingCharge")
    private Long mShippingCharge;
    @SerializedName("shippingCharges")
    private ShippingCharges mShippingCharges;
    @SerializedName("ShippingIsBilling")
    private Boolean mShippingIsBilling;
    @SerializedName("SizeName")
    private Object mSizeName;
    @SerializedName("Slug")
    private Object mSlug;
    @SerializedName("SlugUrl")
    private Object mSlugUrl;
    @SerializedName("Source")
    private String mSource;
    @SerializedName("State")
    private Object mState;
    @SerializedName("Status")
    private Object mStatus;
    @SerializedName("StatusId")
    private Long mStatusId;
    @SerializedName("UpdatedAt")
    private String mUpdatedAt;
    @SerializedName("UpdatedBy")
    private Long mUpdatedBy;
    @SerializedName("WallateBalance")
    private Long mWallateBalance;
    @SerializedName("Wbalance")
    private Object mWbalance;
    @SerializedName("Weight")
    private Long mWeight;
    @SerializedName("Width")
    private Long mWidth;

    public Object getAddress() {
        return mAddress;
    }

    public void setAddress(Object address) {
        mAddress = address;
    }

    public Object getAddressBilling() {
        return mAddressBilling;
    }

    public void setAddressBilling(Object addressBilling) {
        mAddressBilling = addressBilling;
    }

    public Object getBillingAddress() {
        return mBillingAddress;
    }

    public void setBillingAddress(Object billingAddress) {
        mBillingAddress = billingAddress;
    }

    public Object getBillingCity() {
        return mBillingCity;
    }

    public void setBillingCity(Object billingCity) {
        mBillingCity = billingCity;
    }

    public Object getBillingConsigneeName() {
        return mBillingConsigneeName;
    }

    public void setBillingConsigneeName(Object billingConsigneeName) {
        mBillingConsigneeName = billingConsigneeName;
    }

    public Object getBillingCountry() {
        return mBillingCountry;
    }

    public void setBillingCountry(Object billingCountry) {
        mBillingCountry = billingCountry;
    }

    public Object getBillingEmail() {
        return mBillingEmail;
    }

    public void setBillingEmail(Object billingEmail) {
        mBillingEmail = billingEmail;
    }

    public Object getBillingLandmark() {
        return mBillingLandmark;
    }

    public void setBillingLandmark(Object billingLandmark) {
        mBillingLandmark = billingLandmark;
    }

    public Object getBillingLastName() {
        return mBillingLastName;
    }

    public void setBillingLastName(Object billingLastName) {
        mBillingLastName = billingLastName;
    }

    public Object getBillingMobile() {
        return mBillingMobile;
    }

    public void setBillingMobile(Object billingMobile) {
        mBillingMobile = billingMobile;
    }

    public Object getBillingPincode() {
        return mBillingPincode;
    }

    public void setBillingPincode(Object billingPincode) {
        mBillingPincode = billingPincode;
    }

    public Object getBillingState() {
        return mBillingState;
    }

    public void setBillingState(Object billingState) {
        mBillingState = billingState;
    }

    public Long getCGST() {
        return mCGST;
    }

    public void setCGST(Long cGST) {
        mCGST = cGST;
    }

    public List<Object> getCartItems() {
        return mCartItems;
    }

    public void setCartItems(List<Object> cartItems) {
        mCartItems = cartItems;
    }

    public Object getCity() {
        return mCity;
    }

    public void setCity(Object city) {
        mCity = city;
    }

    public Object getColorName() {
        return mColorName;
    }

    public void setColorName(Object colorName) {
        mColorName = colorName;
    }

    public Object getConsigneeName() {
        return mConsigneeName;
    }

    public void setConsigneeName(Object consigneeName) {
        mConsigneeName = consigneeName;
    }

    public Object getCountry() {
        return mCountry;
    }

    public void setCountry(Object country) {
        mCountry = country;
    }

    public Object getCouponCode() {
        return mCouponCode;
    }

    public void setCouponCode(Object couponCode) {
        mCouponCode = couponCode;
    }

    public Object getCouponCodeId() {
        return mCouponCodeId;
    }

    public void setCouponCodeId(Object couponCodeId) {
        mCouponCodeId = couponCodeId;
    }

    public List<Object> getCouponItem() {
        return mCouponItem;
    }

    public void setCouponItem(List<Object> couponItem) {
        mCouponItem = couponItem;
    }

    public Object getCouponName() {
        return mCouponName;
    }

    public void setCouponName(Object couponName) {
        mCouponName = couponName;
    }

    public Long getCourierId() {
        return mCourierId;
    }

    public void setCourierId(Long courierId) {
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

    public String getCreatedDateString() {
        return mCreatedDateString;
    }

    public void setCreatedDateString(String createdDateString) {
        mCreatedDateString = createdDateString;
    }

    public Long getCurrentBalance() {
        return mCurrentBalance;
    }

    public void setCurrentBalance(Long currentBalance) {
        mCurrentBalance = currentBalance;
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

    public Object getCustomerName() {
        return mCustomerName;
    }

    public void setCustomerName(Object customerName) {
        mCustomerName = customerName;
    }

    public Object getDeliveredOn() {
        return mDeliveredOn;
    }

    public void setDeliveredOn(Object deliveredOn) {
        mDeliveredOn = deliveredOn;
    }

    public Long getDiscount() {
        return mDiscount;
    }

    public void setDiscount(Long discount) {
        mDiscount = discount;
    }

    public Object getEmail() {
        return mEmail;
    }

    public void setEmail(Object email) {
        mEmail = email;
    }

    public String getFullAddress() {
        return mFullAddress;
    }

    public void setFullAddress(String fullAddress) {
        mFullAddress = fullAddress;
    }

    public Long getGST() {
        return mGST;
    }

    public void setGST(Long gST) {
        mGST = gST;
    }

    public Object getGSTNumber() {
        return mGSTNumber;
    }

    public void setGSTNumber(Object gSTNumber) {
        mGSTNumber = gSTNumber;
    }

    public Long getHeight() {
        return mHeight;
    }

    public void setHeight(Long height) {
        mHeight = height;
    }

    public Long getIGST() {
        return mIGST;
    }

    public void setIGST(Long iGST) {
        mIGST = iGST;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Object getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(Object imageUrl) {
        mImageUrl = imageUrl;
    }

    public String getInvoiceNumber() {
        return mInvoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        mInvoiceNumber = invoiceNumber;
    }

    public Boolean getIsWallateBalanceApply() {
        return mIsWallateBalanceApply;
    }

    public void setIsWallateBalanceApply(Boolean isWallateBalanceApply) {
        mIsWallateBalanceApply = isWallateBalanceApply;
    }

    public Object getLandmark() {
        return mLandmark;
    }

    public void setLandmark(Object landmark) {
        mLandmark = landmark;
    }

    public Object getLastName() {
        return mLastName;
    }

    public void setLastName(Object lastName) {
        mLastName = lastName;
    }

    public Long getLength() {
        return mLength;
    }

    public void setLength(Long length) {
        mLength = length;
    }

    public Object getMobile() {
        return mMobile;
    }

    public void setMobile(Object mobile) {
        mMobile = mobile;
    }

    public Long getNetSales() {
        return mNetSales;
    }

    public void setNetSales(Long netSales) {
        mNetSales = netSales;
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

    public Object getOrderDetails() {
        return mOrderDetails;
    }

    public void setOrderDetails(Object orderDetails) {
        mOrderDetails = orderDetails;
    }

    public Long getOriginalPrice() {
        return mOriginalPrice;
    }

    public void setOriginalPrice(Long originalPrice) {
        mOriginalPrice = originalPrice;
    }

    public Object getPayment() {
        return mPayment;
    }

    public void setPayment(Object payment) {
        mPayment = payment;
    }

    public Object getPaymentId() {
        return mPaymentId;
    }

    public void setPaymentId(Object paymentId) {
        mPaymentId = paymentId;
    }

    public Object getPaymentMode() {
        return mPaymentMode;
    }

    public void setPaymentMode(Object paymentMode) {
        mPaymentMode = paymentMode;
    }

    public Object getPaymentType() {
        return mPaymentType;
    }

    public void setPaymentType(Object paymentType) {
        mPaymentType = paymentType;
    }

    public Object getPincode() {
        return mPincode;
    }

    public void setPincode(Object pincode) {
        mPincode = pincode;
    }

    public Long getPrice() {
        return mPrice;
    }

    public void setPrice(Long price) {
        mPrice = price;
    }

    public Object getProduct() {
        return mProduct;
    }

    public void setProduct(Object product) {
        mProduct = product;
    }

    public Object getProductName() {
        return mProductName;
    }

    public void setProductName(Object productName) {
        mProductName = productName;
    }

    public Long getProfit() {
        return mProfit;
    }

    public void setProfit(Long profit) {
        mProfit = profit;
    }

    public Long getPurchasePrice() {
        return mPurchasePrice;
    }

    public void setPurchasePrice(Long purchasePrice) {
        mPurchasePrice = purchasePrice;
    }

    public Long getPurchaseRate() {
        return mPurchaseRate;
    }

    public void setPurchaseRate(Long purchaseRate) {
        mPurchaseRate = purchaseRate;
    }

    public Long getQuantity() {
        return mQuantity;
    }

    public void setQuantity(Long quantity) {
        mQuantity = quantity;
    }

    public Long getRawPrice() {
        return mRawPrice;
    }

    public void setRawPrice(Long rawPrice) {
        mRawPrice = rawPrice;
    }

    public Long getSGST() {
        return mSGST;
    }

    public void setSGST(Long sGST) {
        mSGST = sGST;
    }

    public Object getSKU() {
        return mSKU;
    }

    public void setSKU(Object sKU) {
        mSKU = sKU;
    }

    public Long getSales() {
        return mSales;
    }

    public void setSales(Long sales) {
        mSales = sales;
    }

    public Object getSelected() {
        return mSelected;
    }

    public void setSelected(Object selected) {
        mSelected = selected;
    }

    public Object getSellerAddress() {
        return mSellerAddress;
    }

    public void setSellerAddress(Object sellerAddress) {
        mSellerAddress = sellerAddress;
    }

    public Object getSellerName() {
        return mSellerName;
    }

    public void setSellerName(Object sellerName) {
        mSellerName = sellerName;
    }

    public Long getShipRocketOrderId() {
        return mShipRocketOrderId;
    }

    public void setShipRocketOrderId(Long shipRocketOrderId) {
        mShipRocketOrderId = shipRocketOrderId;
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

    public Long getShippingCharge() {
        return mShippingCharge;
    }

    public void setShippingCharge(Long shippingCharge) {
        mShippingCharge = shippingCharge;
    }

    public ShippingCharges getShippingCharges() {
        return mShippingCharges;
    }

    public void setShippingCharges(ShippingCharges shippingCharges) {
        mShippingCharges = shippingCharges;
    }

    public Boolean getShippingIsBilling() {
        return mShippingIsBilling;
    }

    public void setShippingIsBilling(Boolean shippingIsBilling) {
        mShippingIsBilling = shippingIsBilling;
    }

    public Object getSizeName() {
        return mSizeName;
    }

    public void setSizeName(Object sizeName) {
        mSizeName = sizeName;
    }

    public Object getSlug() {
        return mSlug;
    }

    public void setSlug(Object slug) {
        mSlug = slug;
    }

    public Object getSlugUrl() {
        return mSlugUrl;
    }

    public void setSlugUrl(Object slugUrl) {
        mSlugUrl = slugUrl;
    }

    public String getSource() {
        return mSource;
    }

    public void setSource(String source) {
        mSource = source;
    }

    public Object getState() {
        return mState;
    }

    public void setState(Object state) {
        mState = state;
    }

    public Object getStatus() {
        return mStatus;
    }

    public void setStatus(Object status) {
        mStatus = status;
    }

    public Long getStatusId() {
        return mStatusId;
    }

    public void setStatusId(Long statusId) {
        mStatusId = statusId;
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

    public Long getWallateBalance() {
        return mWallateBalance;
    }

    public void setWallateBalance(Long wallateBalance) {
        mWallateBalance = wallateBalance;
    }

    public Object getWbalance() {
        return mWbalance;
    }

    public void setWbalance(Object wbalance) {
        mWbalance = wbalance;
    }

    public Long getWeight() {
        return mWeight;
    }

    public void setWeight(Long weight) {
        mWeight = weight;
    }

    public Long getWidth() {
        return mWidth;
    }

    public void setWidth(Long width) {
        mWidth = width;
    }

}
