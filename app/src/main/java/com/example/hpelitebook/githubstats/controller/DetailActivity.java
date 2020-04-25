package com.example.hpelitebook.githubstats.controller;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.util.Linkify;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.hpelitebook.githubstats.R;
import com.example.hpelitebook.githubstats.model.Item;

import org.w3c.dom.Text;


/**
 * Created by Vitaliy Lazorishinets on 18.04.2020.
 */

public class DetailActivity extends AppCompatActivity{
    TextView  Reponame, Description, Forks, Stars, Watchers;
    Button ShowDetail;

    //ImageView imageView;

    public void onCreate(Bundle savedInstanseState){
        Log.d("MyDebug:", "DebugDetali created");

        super.onCreate(savedInstanseState);
        setContentView(R.layout.activity_detail);
        ActionBar bar = getActionBar();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Reponame = findViewById(R.id.reponame);
        Description = findViewById(R.id.description);
        ShowDetail =  findViewById(R.id.detalibut);
        Forks = findViewById(R.id.forksView);
        Stars = findViewById(R.id.starsView);
        Watchers = findViewById(R.id.watchesView);

        String reponame = getIntent().getExtras().getString("name");
        String description = getIntent().getExtras().getString("description");
        String stars_count = getIntent().getExtras().getString("stargazers_count");
        String forks_count = getIntent().getExtras().getString("forks_count");
        String watches_count = getIntent().getExtras().getString("watchers_count");
        final String link = getIntent().getExtras().getString("html_url");

        Log.d("MyDebug: ", reponame+" "+description+" "+link);
        ShowDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                startActivity(browserIntent);
            }
        });
        Reponame.setText(reponame);
        Description.setText(description);
        Forks.setText(forks_count);
        Stars.setText(stars_count);
        Watchers.setText(watches_count);
        getSupportActionBar().setTitle("Деталі");
    }
}
