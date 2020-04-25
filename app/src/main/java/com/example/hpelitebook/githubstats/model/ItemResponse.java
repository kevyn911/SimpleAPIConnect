package com.example.hpelitebook.githubstats.model;


import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Vitaliy Lazorishinets on 18.05.2018.
 */

public class ItemResponse {
    @SerializedName("items")
    @Expose
    private List<Item> items;
    public List<Item> getItems(){
        return items;
    }
}

