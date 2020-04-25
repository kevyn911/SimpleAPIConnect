package com.example.hpelitebook.githubstats.controller;

import android.app.ProgressDialog;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hpelitebook.githubstats.ItemAdapter;
import com.example.hpelitebook.githubstats.R;
import com.example.hpelitebook.githubstats.api.Client;
import com.example.hpelitebook.githubstats.api.Service;
import com.example.hpelitebook.githubstats.model.Item;
import com.example.hpelitebook.githubstats.model.ItemResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListOfRepos extends AppCompatActivity {

    private RecyclerView recyclerView;
    TextView Disconnected;
    ProgressDialog pd;
    private SwipeRefreshLayout swipeContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MyDebug:", "Listofrepo created");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listofrepos);

        initViews();
        Log.d("MyDebug:", "initViews finished");

        swipeContainer = findViewById(R.id.swipeContainer);

        swipeContainer.setColorSchemeResources(android.R.color.holo_orange_dark);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh(){
                loadJSON();
                Toast.makeText(ListOfRepos.this, "GitHub репозиторії оновлені", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initViews(){
        pd = new ProgressDialog(this);
        pd.setMessage("Пошук репозиторіїв...");
        pd.setCancelable(false);
        pd.show();
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.smoothScrollToPosition(0);
        loadJSON();
    }

    public static String filter;
    private void loadJSON(){
        Disconnected = findViewById(R.id.disconnected);
        Log.d("MyDebug:", "JSON LOAD");
        try{
            Client Client = new Client();
            Service apiService = Client.getClient().create(Service.class);
            Log.d("MyDebug:", "Try call ItemResponse");
            Call<ItemResponse> call = apiService.getItems(filter);
            Log.d("MyDebug:", "Item response is OK.");
            Log.d("MyDebug:", "Try Call enqueue");
            call.enqueue(new Callback<ItemResponse>() {
                @Override
                public void onResponse(Call<ItemResponse> call, Response<ItemResponse> response) {
                    List<Item> items = response.body().getItems();
                    recyclerView.setAdapter(new ItemAdapter(getApplicationContext(), items));
                    recyclerView.smoothScrollToPosition(0);
                    swipeContainer.setRefreshing(false);
                    pd.hide();
                }

                @Override
                public void onFailure(Call<ItemResponse> call, Throwable t) {
                    Log.d("Помилка", t.getMessage());
                    Toast.makeText(ListOfRepos.this, "Помилка при зчитуванні інформації", Toast.LENGTH_SHORT).show();
                    Disconnected.setVisibility(View.VISIBLE);
                    pd.hide();
                }
            });
            Log.d("MyDebug:", "Enqueue is OK.");


        }catch (Exception e){
            Log.d("Помилка", e.getMessage());
            Toast.makeText(ListOfRepos.this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
