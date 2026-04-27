package org.baltimorecityschools.gamel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class OnboardingActivity extends AppCompatActivity {

    ChipGroup onboardingchipGroup;
    Button doneButton;
    TextView onboardingTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
        onboardingchipGroup = findViewById(R.id.onboardingChipGroup);
        onboardingTextview = findViewById(R.id.onboardingTextview);
        doneButton = findViewById(R.id.doneButton);
        doneButton.setEnabled(false);

        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        boolean preferrencesEdit = getIntent().getBooleanExtra("onboarding_edit", false);

        Set<String> savedGenres = new HashSet<>();
        if (preferrencesEdit) {
            doneButton.setEnabled(true);
            doneButton.setBackgroundColor(getResources().getColor(R.color.coolblue));
            onboardingTextview.setText(R.string.preferrencestext);


            savedGenres = prefs.getStringSet("preferredGenres", new HashSet<>());
        }

        Allgames.loadallgames(this);

        boolean onboardingComplete = prefs.getBoolean("onboarding_complete", false);

        Intent intent;

        if (onboardingComplete && !preferrencesEdit) {
            intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            finish();
            return;
        }



        ArrayList<String> genreList = new ArrayList<>();
        for (Game game : Allgames.allgames) {

            if (game.getTags() != null) {

                for (String tag : game.getTags()) {

                    if (!genreList.contains(tag)) {
                        genreList.add(tag);
                    }
                }
            }
        }

        for (String genre : genreList) {
            Chip chip = new Chip(this);
            chip.setText(genre);
            chip.setChipCornerRadius(50f);
            chip.setTextSize(12f);
            chip.setTextColor(getResources().getColor(R.color.white));
            chip.setCheckable(true);
            chip.setClickable(true);
            chip.setChipBackgroundColorResource(R.color.asphaltwhisper);

            if (savedGenres.contains(genre)) {
                chip.setChecked(true);
            }

            chip.setOnCheckedChangeListener((buttonView, isChecked) -> {

                if (isChecked) {
                    chip.setChipBackgroundColorResource(R.color.coolblue);

                } else {
                    chip.setChipBackgroundColorResource(R.color.asphaltwhisper);
                }

            });


            onboardingchipGroup.addView(chip);
        }

        onboardingchipGroup.setOnCheckedStateChangeListener((group, checkedIds) -> {

            boolean checkedIdNotEmpty = !checkedIds.isEmpty();
            if (checkedIdNotEmpty) {
                doneButton.setEnabled(true);
            } else {
                doneButton.setEnabled(false);
            }
            if(checkedIdNotEmpty){
                doneButton.setBackgroundColor(getResources().getColor(R.color.coolblue));
            }else{
                doneButton.setBackgroundColor(getResources().getColor(R.color.asphaltwhisper));
            }

        });

        doneButton.setOnClickListener(v -> {
            ArrayList<String> selectedTags = new ArrayList<>();
            for (int i = 0; i < onboardingchipGroup.getChildCount(); i++) {
                Chip chip = (Chip) onboardingchipGroup.getChildAt(i);
                if (chip.isChecked()) {
                    selectedTags.add(chip.getText().toString());
                }
            }

            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putStringSet("preferredGenres", new HashSet<>(selectedTags));
            editor.putBoolean("onboarding_complete", true);
            editor.apply();

            Intent intent2 = new Intent(this, HomeActivity.class);
            startActivity(intent2);
            finish();

        });





    }
}