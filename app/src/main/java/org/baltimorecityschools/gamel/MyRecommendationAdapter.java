package org.baltimorecityschools.gamel;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MyRecommendationAdapter extends RecyclerView.Adapter<MyRecommendationAdapter.MyViewHolder> {
    List<Game> recommendationData;
    Set<String> savedGenres;

    public MyRecommendationAdapter(List<Game> recommendationData, Set<String> savedGenres) {
        this.recommendationData = recommendationData;
        this.savedGenres = savedGenres;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        MaterialCardView recommendationMediacard;
        ImageView recommendationMediacardImage;
        TextView recommendMediacardTitleTextView;
        TextView recommendMediacardDescriptionTextView;
        ChipGroup recommendMediacardtagContainer;

        public MyViewHolder(View itemView) {
            super(itemView);

            recommendationMediacard = itemView.findViewById(R.id.recomendationMediacardId);
            recommendationMediacardImage = itemView.findViewById(R.id.recommendationMediacardImage);
            recommendMediacardTitleTextView = itemView.findViewById(R.id.recommendMediacardTitleTextView);
            recommendMediacardDescriptionTextView = itemView.findViewById(R.id.recommendMediacardDescriptionTextView);
            recommendMediacardtagContainer = itemView.findViewById(R.id.recommendMediacardtagContainer);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recommendationmediacard, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Game game = recommendationData.get(position);

        holder.recommendationMediacardImage.setImageResource(game.getHeroBanner());
        holder.recommendMediacardTitleTextView.setText(game.getTitle());
        holder.recommendMediacardDescriptionTextView.setText(game.getDescription());
        holder.recommendMediacardtagContainer.removeAllViews();

        if (game.getTags() != null) {
            for (String tag : game.getTags()) {
                String editedTags = tag.trim().toLowerCase();
                if (savedGenres.contains(editedTags)) {
                    Chip chip = new Chip(holder.itemView.getContext());
                    chip.setText(tag);
                    if(chip.isChecked()){
                        chip.setChipBackgroundColorResource(R.color.coolblue);
                    }else {
                        chip.setChipBackgroundColorResource(R.color.asphaltwhisper);
                    }
                    chip.setTextColor(holder.itemView.getResources().getColor(R.color.white));
                    chip.setChipCornerRadius(50f);
                    chip.setTextSize(12f);
                    holder.recommendMediacardtagContainer.addView(chip);



                    chip.setOnClickListener(v -> {
                        Intent intent = new Intent(v.getContext(), TagActivity.class);
                        intent.putExtra("tag", tag);
                        v.getContext().startActivity(intent);
                    });



                }


            }

        }
        holder.recommendationMediacard.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), GameActivity.class);

            intent.putExtra("title", game.getTitle());
            intent.putExtra("description", game.getDescription());
            intent.putExtra("developer", game.getDevelopers());
            intent.putExtra("publisher", game.getPublishers());
            intent.putExtra("banner", game.getHeroBanner());
            intent.putExtra("thumbnail", game.getHeroThumbnail());
            intent.putExtra("updates", game.getUpdates());
            intent.putStringArrayListExtra("tags", new ArrayList<>(game.getTags()));

            v.getContext().startActivity(intent);
        });

    }
    @Override
    public int getItemCount() {
        return recommendationData.size();
    }
}
