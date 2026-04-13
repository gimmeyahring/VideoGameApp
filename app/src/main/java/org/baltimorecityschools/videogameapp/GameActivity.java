package org.baltimorecityschools.videogameapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.flexbox.FlexboxLayout;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    ScrollView gameScrollView;
    ImageView heroBannerIV;
    TextView gameUpdatesTV;
    TextView gameDeveloperTV;
    TextView gamePublisherTV;
    ImageView heroThumbnailIV;
    TextView gameTitleTV;
    TextView gameDescriptionTV;

    boolean isDescriptionExpanded = false;
    boolean isUpdatesExpanded = false;

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
        String updates = getString(R.string.Loremispumparagraph);
        ArrayList<String> tags = getIntent().getStringArrayListExtra("tags");
        FlexboxLayout tagContainer = findViewById(R.id.tagContainer);


        gameScrollView = findViewById(R.id.gamescrollviewid);
        gameUpdatesTV = findViewById(R.id.gameexpandableupdatesTextview);
        gameDeveloperTV = findViewById(R.id.gamedeveloperTextview);
        gamePublisherTV = findViewById(R.id.gamepublisherTextview);
        heroBannerIV = findViewById(R.id.herobannerid);
        heroThumbnailIV = findViewById(R.id.herothumbnailid);
        gameTitleTV = findViewById(R.id.gametitleTextview);
        gameDescriptionTV = findViewById(R.id.gameexpandabledescriptionTextview);

        gameUpdatesTV.setText(updates);
        gameDeveloperTV.setText(developer);
        gamePublisherTV.setText(publisher);
        heroBannerIV.setImageResource(banner);
        heroThumbnailIV.setImageResource(thumbnail);
        gameTitleTV.setText(title);
        gameDescriptionTV.setText(description);

        gameDescriptionTV.setOnClickListener(v -> {
            if (isDescriptionExpanded) {
                gameDescriptionTV.setMaxLines(4);
                isDescriptionExpanded = false;
            } else {
                gameDescriptionTV.setMaxLines(Integer.MAX_VALUE);
                isDescriptionExpanded = true;
            }
        });

        gameUpdatesTV.setOnClickListener(v -> {
            if (isUpdatesExpanded) {
                gameUpdatesTV.setMaxLines(4);
                isUpdatesExpanded = false;
            } else {
                gameUpdatesTV.setMaxLines(Integer.MAX_VALUE);
                isUpdatesExpanded = true;
            }
        });

        if (tags != null) {
            for (String tag : tags) {
                TextView tagTextView = new TextView(this);
                tagTextView.setText(tag);
                tagTextView.setTextColor(getResources().getColor(R.color.white));
                tagTextView.setPadding(30, 15, 30, 15);
                tagTextView.setBackgroundResource(R.drawable.tagback);

                FlexboxLayout.LayoutParams params =
                        new FlexboxLayout.LayoutParams(
                                FlexboxLayout.LayoutParams.WRAP_CONTENT,
                                FlexboxLayout.LayoutParams.WRAP_CONTENT
                        );

                params.setMargins(10, 10, 10, 10);
                tagTextView.setLayoutParams(params);

                // 4. Click behavior
                tagTextView.setOnClickListener(v -> {
                    Toast.makeText(this, "Clicked: " + tag, Toast.LENGTH_SHORT).show();
                });

                // 5. Add to screen
                tagContainer.addView(tagTextView);

            }
        }




    }
}