package org.baltimorecityschools.gamel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class HomeActivity extends AppCompatActivity {


    MaterialCardView recomendationMediacard;
    ImageView recomendationMediacardImage;
    TextView recommendMediacardTitleTextView;
    TextView recommendMediacardDescriptionTextView;
    ChipGroup recommendMediacardtagContainer;
    BottomNavigationView bottomNavigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recomendationMediacard = findViewById(R.id.recomendationMediacardId);
        recomendationMediacardImage = findViewById(R.id.recommendationMediacardImage);
        recommendMediacardTitleTextView = findViewById(R.id.recommendMediacardTitleTextView);
        recommendMediacardDescriptionTextView = findViewById(R.id.recommendMediacardDescriptionTextView);
        recommendMediacardtagContainer = findViewById(R.id.recommendMediacardtagContainer);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.homeNavigationButton);
        NavigationBarLogic.setupNavigationBar(this, bottomNavigationView);

        Allgames.loadallgames(this);

        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        Set<String> savedGenres = prefs.getStringSet("preferredGenres", new HashSet<>());

        Game recommenedGame = null;
        int gameRecommendationTopScore = -1;

        for(Game game: Allgames.allgames){
            int gameRecommendationScore = 0;
            if(game.getTags() != null){
                for(String tag : game.getTags()){
                    String editedTags = tag.trim().toLowerCase();
                    if(savedGenres.contains(editedTags)){
                        gameRecommendationScore++;
                    }
                }
            }

            if(gameRecommendationScore>gameRecommendationTopScore){
                gameRecommendationTopScore = gameRecommendationScore;
                recommenedGame = game;
            } else if(gameRecommendationScore == gameRecommendationTopScore){
                if(Math.random() < 0.5){
                    recommenedGame = game;
                }
            }
        }

        if(recommenedGame != null){
            Game game = recommenedGame;

            recomendationMediacardImage.setImageResource(game.getHeroBanner());
            recommendMediacardTitleTextView.setText(game.getTitle());
            recommendMediacardDescriptionTextView.setText(game.getDescription());

            for(String tag : recommenedGame.getTags()){
                if(savedGenres.contains(tag.trim().toLowerCase())){
                    Chip chip = new Chip(this);
                    chip.setText(tag);
                    chip.setChipBackgroundColorResource(R.color.asphaltwhisper);
                    chip.setTextColor(getResources().getColor(R.color.white));
                    chip.setChipCornerRadius(50f);
                    chip.setTextSize(12f);
                    chip.setChipStrokeWidth(2f);
                    chip.setChipStrokeColorResource(R.color.coolasphaltwhisper);
                    recommendMediacardtagContainer.setChipSpacingVertical(0);
                    recommendMediacardtagContainer.addView(chip);
                }
            }
            recomendationMediacard.setOnClickListener(v -> {
                Intent intent = new Intent(this, GameActivity.class);
                intent.putExtra("title", game.getTitle());
                intent.putExtra("description", game.getDescription());
                intent.putExtra("developer", game.getDevelopers());
                intent.putExtra("publisher", game.getPublishers());
                intent.putExtra("banner", game.getHeroBanner());
                intent.putExtra("thumbnail", game.getHeroThumbnail());
                intent.putExtra("updates", game.getUpdates());
                intent.putStringArrayListExtra("tags", new ArrayList<>(game.getTags()));
                startActivity(intent);
            });

        }






    }
}