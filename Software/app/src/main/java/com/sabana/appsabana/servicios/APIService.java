package com.sabana.appsabana.servicios;

import com.sabana.appsabana.User;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface APIService {

    @GET("login")
    Call<User> login(@QueryMap Map<String, String> params);
}
