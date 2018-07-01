package com.qwersoft.searchdemo.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by IT02106 on 01/07/2018.
 */

public class ApiClient {
    public static final String BASE_URL = "https://api.github.com/search/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient()
    {
        if(retrofit == null)
        {
            retrofit = new Retrofit.Builder().
                    baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
