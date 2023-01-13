package com.dongguk.meeting;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Retrofit_interface2 {

    @GET("v1/api/subwayPath?")
    Call<SubwayResultSet> test_api_get(@Query("lang") String lang,
                                  @Query("CID") String x,
                                  @Query("SID") String y,
                                  @Query("EID") String radius,
                                  @Query("Sopt") String stationClass,
                                  @Query("apiKey") String apiKey);
}