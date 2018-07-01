package com.qwersoft.searchdemo.rest;

import com.qwersoft.searchdemo.Model.MItemList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by IT02106 on 01/07/2018.
 */

public interface ApiInterface {
    @GET("users")
    Call<MItemList> getMItems(@Query(value = "q", encoded = true) String loginName);;
}
