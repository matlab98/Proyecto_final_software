package com.sabana.appsabana.servicios;

import com.sabana.appsabana.modelos.Bus;
import com.sabana.appsabana.modelos.Train;
import com.sabana.appsabana.modelos.User;

import java.util.List;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface APIService {

    @GET("login")
    Call<User> login(@QueryMap Map<String, String> params);

    @GET("createBus")
    Call<Bus> createBus(@QueryMap Map<String, String> params);

    @GET("createTren")
    Call<Train> createTrain(@QueryMap Map<String, String> params);

    @GET("searchBus")
    Call<List<Bus>> getBuses(@QueryMap Map<String, String> params);

    /*
    @GET("searchTren")
    Call<User> searchTrain(@QueryMap Map<String, String> params);

    */
}
