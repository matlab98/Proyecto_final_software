package com.sabana.appsabana.servicios;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpClient {

    private static Retrofit retrofit;

    private final static String baseUrl = "http://190.249.18.206:8080/user/";

    private HttpClient() {}

    public static Retrofit getClient() {
        if (retrofit == null) retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }
}
