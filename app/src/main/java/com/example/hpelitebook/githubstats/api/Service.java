package com.example.hpelitebook.githubstats.api;

import com.example.hpelitebook.githubstats.model.ItemResponse;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by Vitaliy Lazorishinets on 18.04.2020.
 */

public interface Service {
    @GET("/search/repositories")
    Call<ItemResponse> getItems(@Query("q") String filter);
}
