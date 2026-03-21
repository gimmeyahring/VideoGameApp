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

    ConstraintLayout mainLayout;
    ScrollView gameScrollView;
    ConstraintLayout scrollViewLayout;
    ImageView heroBannerIV;
    ImageView heroThumbnailIV;
    TextView gameTitleTV;
    TextView gameDescriptionTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        mainLayout = findViewById(R.id.main);
        gameScrollView = findViewById(R.id.gamescrollviewid);
        scrollViewLayout = findViewById(R.id.mainLayout2);
        heroBannerIV = findViewById(R.id.herobannerid);
        heroThumbnailIV = findViewById(R.id.herothumbnailid);
        gameTitleTV = findViewById(R.id.gametitleTextview);
        gameDescriptionTV = findViewById(R.id.gameexpandabledescriptionTextview);
        peak = new Game(getString(R.string.gamePeakTitle), "Landfall", getString(R.string.gamePeakDescription), R.drawable.peakherobanner, R.drawable.peakherothumbnail);






    }
}