package com.example.hpelitebook.githubstats;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hpelitebook.githubstats.controller.DetailActivity;
import com.example.hpelitebook.githubstats.model.Item;

import java.util.List;

/**
 * Created by Vitaliy Lazorishinets on 18.04.2020.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private List<Item> items;
    private Context context;

    public ItemAdapter(Context applicationContext, List<Item> itemArrayList) {
        this.context = applicationContext;
        this.items = itemArrayList;
    }

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_repo, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemAdapter.ViewHolder viewHolder, int i) {
        viewHolder.title.setText(items.get(i).getName());
        Log.d("MyDebug:","GetDescription = "+items.get(i).getDescription());
        viewHolder.description.setText(items.get(i).getDescription());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title, description;

        public ViewHolder(View view) {
            super(view);
            Log.d("MyDebug:", "ViewHolder is loading");
            title = view.findViewById(R.id.title);
            description = view.findViewById(R.id.description1);

            Log.d("MyDebug:", "ViewHolder initialize items");

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        Log.d("MyDebug:", "Items.get with pos = "+pos);
                        Intent intent = new Intent(context, DetailActivity.class);
                        Log.d("MyDebug:", "ItemAdapter - intent created");
                        intent.putExtra("name", items.get(pos).getName());
                        intent.putExtra("html_url", items.get(pos).getHtmlUrl());
                        intent.putExtra("description", items.get(pos).getDescription());
                        intent.putExtra("forks_count", items.get(pos).getForkCount());
                        intent.putExtra("stargazers_count", items.get(pos).getStarsCount());
                        intent.putExtra("watchers_count", items.get(pos).getWatchersCount());
                        Log.d("MyDebug:", "ItemAdapter - intent put extras has succes");
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        Log.d("MyDebug:", "Preparing to open new activity");
                        context.startActivity(intent);
                    }
                }

            });
        }
    }
}
