package com.example.hpelitebook.githubstats.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Vitaliy Lazorishinets on 18.04.2020.
 */

public class Item {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("html_url")
    @Expose
    private String htmlUrl;

    @SerializedName("stargazers_count")
    @Expose
    private String starsCount;

    @SerializedName("watchers_count")
    @Expose
    private String watchersCount;

    @SerializedName("forks_count")
    @Expose
    private String forkCount;



    public String getName() {
        return name;
    }

    public String getStarsCount(){return starsCount;}

    public String getWatchersCount(){return watchersCount;}

    public String getForkCount(){return forkCount;}

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

}
