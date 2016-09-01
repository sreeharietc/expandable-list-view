package com.example.qbclct.expandableview.REST;

import com.example.qbclct.expandableview.Model.TopicsResponse;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Query;
import retrofit.http.Url;

/**
 * Created by QBCLCT on 9/8/16.
 */
public interface ApiInterface {
    @GET("topics")
    Call<TopicsResponse> getTopics(@Query("id") String id);
}
