package com.example.sunnyenterprise.retrofit;

import com.example.sunnyenterprise.model.Banner;
import com.example.sunnyenterprise.model.Category;
import com.example.sunnyenterprise.model.Company;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiCallInterface {
    @GET("banner/bannerimages")
    Call<List<Banner>> getBanners();

    @GET("collections/companies")
    Call<List<Company>> getCompanies();

    @GET("collections/category?companyId=19")
    Call<List<Category>> getCategories();
}