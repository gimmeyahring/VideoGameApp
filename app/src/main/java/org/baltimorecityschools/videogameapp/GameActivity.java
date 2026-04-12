package org.baltimorecityschools.videogameapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GameActivity extends AppCompatActivity {

    ScrollView gameScrollView;
    ImageView heroBannerIV;
    TextView gameUpdatesTV;
    TextView gameDeveloperTV;
    TextView gamePublisherTV;
    ImageView heroThumbnailIV;
    TextView gameTitleTV;
    TextView gameDescriptionTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String description = intent.getStringExtra("description");
        String developer = intent.getStringExtra("developer");
        String publisher = intent.getStringExtra("publisher");
        int banner = intent.getIntExtra("banner", 0);
        int thumbnail = intent.getIntExtra("thumbnail", 0);

        gameScrollView = findViewById(R.id.gamescrollviewid);
        gameUpdatesTV = findViewById(R.id.gameexpandableupdatesTextview);
        gameDeveloperTV = findViewById(R.id.gamedeveloperTextview);
        gamePublisherTV = findViewById(R.id.gamepublisherTextview);
        heroBannerIV = findViewById(R.id.herobannerid);
        heroThumbnailIV = findViewById(R.id.herothumbnailid);
        gameTitleTV = findViewById(R.id.gametitleTextview);
        gameDescriptionTV = findViewById(R.id.gameexpandabledescriptionTextview);

        gameUpdatesTV.setText(description);
        gameDeveloperTV.setText(developer);
        gamePublisherTV.setText(publisher);
        heroBannerIV.setImageResource(banner);
        heroThumbnailIV.setImageResource(thumbnail);
        gameTitleTV.setText(title);
        gameDescriptionTV.setText(description);

        gameDescriptionTV.setOnClickListener(v -> {

        });

    }
}