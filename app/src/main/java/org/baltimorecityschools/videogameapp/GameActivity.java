package org.baltimorecityschools.videogameapp;

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

    Game peak;

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

        gameScrollView = findViewById(R.id.gamescrollviewid);
        gameUpdatesTV = findViewById(R.id.gameexpandableupdatesTextview);
        gameDeveloperTV = findViewById(R.id.gamedeveloperTextview);
        gamePublisherTV = findViewById(R.id.gamepublisherTextview);
        heroBannerIV = findViewById(R.id.herobannerid);
        heroThumbnailIV = findViewById(R.id.herothumbnailid);
        gameTitleTV = findViewById(R.id.gametitleTextview);
        gameDescriptionTV = findViewById(R.id.gameexpandabledescriptionTextview);


        gameTitleTV.setText(peak.getTitle());
        gameDescriptionTV.setText(peak.getDescription());
        heroBannerIV.setImageResource(peak.getHeroBanner());
        heroThumbnailIV.setImageResource(peak.getHeroThumbnail());
        gameDeveloperTV.setText(peak.getDevelopers());
        gamePublisherTV.setText(peak.getPublishers());







    }
}