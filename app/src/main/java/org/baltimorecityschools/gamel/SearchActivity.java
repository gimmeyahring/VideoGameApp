package org.baltimorecityschools.gamel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SearchActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    EditText searchBar;
    ChipGroup searchChipGroup;
    Chip titleChip;
    Chip genreChip;
    Chip developerChip;
    Chip publisherChip;
    String filterType;
    RecyclerView recyclerView;
    MyAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchBar = findViewById(R.id.search_bar);
        searchChipGroup = findViewById(R.id.searchChipGroup);
        titleChip = findViewById(R.id.titleChip);
        genreChip = findViewById(R.id.genreChip);
        developerChip = findViewById(R.id.developerChip);
        publisherChip = findViewById(R.id.publisherChip);
        recyclerView = findViewById(R.id.recyclerView);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavigationBarLogic.setupNavigationBar(this, bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.searchNavigationButton);


        Allgames.loadallgames(this);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        adapter = new MyAdapter(Allgames.allgames);
        recyclerView.setAdapter(adapter);

        filterType = "title";


        Chip[] chips = {titleChip, genreChip, developerChip, publisherChip};
        for (Chip chip : chips) {
            chip.setOnClickListener(v -> {
                for (Chip c : chips) {
                    c.setChecked(false);
                }
                chip.setChecked(true);
            });
        }
        searchChipGroup.setOnCheckedStateChangeListener((group, checkedIds) -> {

            int checkId = group.getCheckedChipId();

            if (checkId == R.id.titleChip) {
                filterType = "title";

            }
            else if (checkId == R.id.genreChip) {
                filterType = "genre";

            }
            else if (checkId == R.id.developerChip) {
                filterType = "developer";

            }
            else if (checkId == R.id.publisherChip) {
                filterType = "publisher";

            }
        });


        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                adapter.filter(s.toString(), filterType);
            }
            @Override
            public void afterTextChanged(Editable s) {

            }



        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        bottomNavigationView.setSelectedItemId(R.id.searchNavigationButton);
    }


}