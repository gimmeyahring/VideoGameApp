package org.baltimorecityschools.gamel;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<Game> data;
    List<Game> oldData;


    public MyAdapter(List<Game> data) {
        this.data = new ArrayList<>(data);
        this.oldData = new ArrayList<>(data);

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
        holder.itemView.setOnClickListener(v -> {

            Intent intent = new Intent(v.getContext(), GameActivity.class);
            if (game.getTags() != null) {
                intent.putStringArrayListExtra("tags", new ArrayList<>(game.getTags()));
            }

            intent.putExtra("title", game.getTitle());
            intent.putExtra("description", game.getDescription());
            intent.putExtra("developer", game.getDevelopers());
            intent.putExtra("publisher", game.getPublishers());
            intent.putExtra("banner", game.getHeroBanner());
            intent.putExtra("thumbnail", game.getHeroThumbnail());
            intent.putExtra("updates", game.getUpdates());

            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void filter(String text, String filterType) {

        data.clear();
        if (text.isEmpty()) {
            data.addAll(oldData);
        } else {
            text = text.toLowerCase();
            for (Game game : oldData) {
                if (filterType.equals("title")) {
                    if (game.getTitle().toLowerCase().contains(text)) {
                        data.add(game);
                    }
                } else if (filterType.equals("genre")) {
                    if (game.getTags() != null) {
                        for (String tag : game.getTags()) {
                            if (tag.toLowerCase().contains(text)) {
                                data.add(game);
                                break;
                            }
                        }
                    }
                } else if (filterType.equals("developer")) {
                    if (game.getDevelopers() != null) {
                        if (game.getDevelopers().toLowerCase().contains(text)) {
                            data.add(game);
                        }
                    }
                } else if (filterType.equals("publisher")) {
                    if (game.getPublishers() != null) {
                        if (game.getPublishers().toLowerCase().contains(text)) {
                            data.add(game);
                        }
                    }

                }
            }
        }
        notifyDataSetChanged();
    }
}


