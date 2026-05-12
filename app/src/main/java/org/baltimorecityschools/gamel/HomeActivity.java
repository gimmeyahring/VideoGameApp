package org.baltimorecityschools.gamel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HomeActivity extends AppCompatActivity {



    BottomNavigationView bottomNavigationView;
    RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = findViewById(R.id.recyclerView);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.homeNavigationButton);
        NavigationBarLogic.setupNavigationBar(this, bottomNavigationView);

        Allgames.loadallgames(this);

        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        Set<String> savedGenres = prefs.getStringSet("preferredGenres", new HashSet<>());

        List<Game> recommendedGames = new ArrayList<>();

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

            if(gameRecommendationScore > 0){
                recommendedGames.add(game);
            }

        }

        RecyclerView.Adapter adapter = new MyRecommendationAdapter(recommendedGames, savedGenres);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
    @Override
    protected void onResume() {
        super.onResume();
        bottomNavigationView.setSelectedItemId(R.id.homeNavigationButton);
    }
}