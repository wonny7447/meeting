package com.dongguk.meeting;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Retrofit_interface {

    @GET("v1/api/pointSearch?")
    Call<data_model> test_api_get(@Query("lang") String lang,
                                  @Query("x") String x,
                                  @Query("y") String y,
                                  @Query("radius") String radius,
                                  @Query("stationClass") String stationClass,
                                  @Query("apiKey") String apiKey);
}