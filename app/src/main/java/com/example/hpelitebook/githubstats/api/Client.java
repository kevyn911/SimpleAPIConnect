package com.example.hpelitebook.githubstats.api;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Vitaliy Lazorishinets on 18.04.2020.
 */

public class Client {
    public static final String API_URL = "https://api.github.com";
    public static Retrofit retrofit = null;

    public Retrofit getClient(){
        if (retrofit==null) {
            retrofit = new Retrofit.Builder().baseUrl(API_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
