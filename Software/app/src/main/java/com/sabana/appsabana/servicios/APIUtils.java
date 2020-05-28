package com.sabana.appsabana.servicios;

public class APIUtils {
    private APIUtils() {}

    public static APIService getAPIService() {
        return HttpClient.getClient().create(APIService.class);
    }
}
