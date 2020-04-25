package com.example.hpelitebook.githubstats;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageButton;

import com.example.hpelitebook.githubstats.controller.ListOfRepos;

import java.io.IOException;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    SoundPool mSoundPool;
    AssetManager assets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSoundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        assets = getAssets();
        final int catSound = loadSound("animal_cat_meow.mp3");
        ImageButton cat = this.findViewById(R.id.imageButton1);

        cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(catSound);
            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    private int loadSound(String fileName) {
        AssetFileDescriptor afd = null;
        try {
            afd = assets.openFd(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
        return mSoundPool.load(afd, 1);
    }
    protected void playSound(int sound) {
        if (sound > 0)
            mSoundPool.play(sound, 1, 1, 1, 0, 1);
    }
    public void onClickText(View v){
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.openDrawer(Gravity.LEFT);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.sharp) {
            ListOfRepos.filter = "language:csharp sort:stars";
            Intent intent = new Intent(this, ListOfRepos.class);
            startActivity(intent);
        } else if (id == R.id.cplus) {
            ListOfRepos.filter = "language:срр sort:stars";
            Intent intent = new Intent(this, ListOfRepos.class);
            startActivity(intent);
        } else if (id == R.id.c) {
            ListOfRepos.filter = "language:c sort:stars";
            Intent intent = new Intent(this, ListOfRepos.class);
            startActivity(intent);
        } else if (id == R.id.html) {
            ListOfRepos.filter = "language:html sort:stars";
            Intent intent = new Intent(this, ListOfRepos.class);
            startActivity(intent);
        }
        else if (id == R.id.shell) {
            ListOfRepos.filter = "language:shell sort:stars";
            Intent intent = new Intent(this, ListOfRepos.class);
            startActivity(intent);
        }
        else if (id == R.id.python) {
            ListOfRepos.filter = "language:python sort:stars";
            Intent intent = new Intent(this, ListOfRepos.class);
            startActivity(intent);
        }
        else if (id == R.id.php) {
            ListOfRepos.filter = "language:php sort:stars";
            Intent intent = new Intent(this, ListOfRepos.class);
            startActivity(intent);
        }
        else if (id == R.id.java) {
            ListOfRepos.filter = "language:java sort:stars";
            Intent intent = new Intent(this, ListOfRepos.class);
            startActivity(intent);
        }
        else if (id == R.id.javascript) {
            ListOfRepos.filter = "language:javascript sort:stars";
            Intent intent = new Intent(this, ListOfRepos.class);
            startActivity(intent);
        }
        else if (id == R.id.ruby) {
            ListOfRepos.filter = "language:ruby sort:stars";
            Intent intent = new Intent(this, ListOfRepos.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
