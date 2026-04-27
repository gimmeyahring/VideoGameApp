package org.baltimorecityschools.gamel;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

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
        String updates = intent.getStringExtra("updates");
        ArrayList<String> tags = intent.getStringArrayListExtra("tags");
        ChipGroup tagContainer = findViewById(R.id.tagContainer);



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

                Chip chip = new Chip(this);
                chip.setText(tag);

                // Style
                chip.setTextColor(ContextCompat.getColor(this, R.color.white));
                chip.setChipBackgroundColorResource(R.color.asphaltwhisper);
                chip.setChipCornerRadius(50f);
                chip.setTextSize(12f);
                tagContainer.setChipSpacingVertical(0);


                // Optional: stroke (outline look)
                chip.setChipStrokeWidth(2f);
                chip.setChipStrokeColorResource(R.color.coolasphaltwhisper);

                // Optional: click behavior


                tagContainer.addView(chip);

                chip.setOnClickListener(v -> {
                    Intent tagintent = new Intent(this, TagActivity.class);
                    tagintent.putExtra("tag", tag);
                    startActivity(tagintent);
                });

            }
        }


    }
}