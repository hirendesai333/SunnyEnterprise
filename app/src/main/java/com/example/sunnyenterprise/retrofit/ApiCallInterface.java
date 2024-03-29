package com.example.sunnyenterprise.retrofit;

import com.example.sunnyenterprise.model.CustomerObj;
import com.example.sunnyenterprise.model.orderDetailsModel.OrderDetails;
import com.example.sunnyenterprise.model.addCartModel.AddCart;
import com.example.sunnyenterprise.model.addToCartModel.AddToCart;
import com.example.sunnyenterprise.model.bannerModel.Banner;
import com.example.sunnyenterprise.model.cartListModel.CartList;
import com.example.sunnyenterprise.model.categoryModel.Category;
import com.example.sunnyenterprise.model.companyModel.Company;
import com.example.sunnyenterprise.model.loginModel.Login;
import com.example.sunnyenterprise.model.ordersModel.Orders;
import com.example.sunnyenterprise.model.placeOrderModel.Item;
import com.example.sunnyenterprise.model.productDetailModel.ProductDetails;
import com.example.sunnyenterprise.model.productModel.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiCallInterface {
    @GET("banner/bannerimages")
    Call<List<Banner>> getBanners();

    @GET("collections/companies")
    Call<List<Company>> getCompanies();

    @GET("collections/category")
    Call<List<Category>> getCategories(
            @Query("companyId") int companyId
    );

    @GET("product/GetProducts")
    Call<Product> getProducts(
            @Query("CategoryId") int categoryId,
            @Query("offset") int offset,
            @Query("limit") int limit
    );

    @GET("customer/Login")
    Call<Login> getLoginDetails(
            @Query("mobile") String mobile
    );

    @GET("product/GetProductBySlug/{slug}")
    Call<ProductDetails> getProductDetail(@Path("slug") String slug);

    @POST("cart/AddCart")
    Call<AddToCart> postData(@Body AddCart addCart);

    @GET("cart/Cart/{customerId}")
    Call<List<CartList>> getCartList(@Path("customerId") int customerId);

    @POST("cart/ClearCart")
    Call<Boolean> deleteCartList(@Query("CustomerId") int CustomerId);

    @GET("cart/CartRemoveItem/{cartId}")
    Call<CartList> deleteCartItem(@Path(("cartId")) int cartId);

    @GET("order/GetOrdersByCustomerId/{customerId}")
    Call<Orders> getOrdersByCustomerId(@Path("customerId") int customerId);

    @POST("checkout/PlacedOrder")
    Call<Item> placeOrder(@Body CustomerObj customerObj);

    @GET("order/GetOrderDetailsById/{orderDetailId}")
    Call<OrderDetails> getOrderDetailsById(@Path("orderDetailId") long orderDetailId);

}