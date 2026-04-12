package org.baltimorecityschools.videogameapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<Game> data;
    public MyAdapter(List<Game> data) {
        this.data = data;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView gametitletext;
        ImageView gameimage;
        public MyViewHolder(View itemView) {
            super(itemView);
            gametitletext = itemView.findViewById(R.id.media_title);
            gameimage = itemView.findViewById(R.id.mediacard_thumbnail);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mediacard, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Game game = data.get(position);

        holder.gametitletext.setText(game.getTitle());
        holder.gameimage.setImageResource(game.getHeroThumbnail());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}
