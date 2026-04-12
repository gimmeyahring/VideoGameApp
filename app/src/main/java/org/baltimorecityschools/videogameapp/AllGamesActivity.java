package org.baltimorecityschools.videogameapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AllGamesActivity extends AppCompatActivity {

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_games);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Game> gameList = new ArrayList<>();

        gameList.add(new Game(getString(R.string.gamePeakTitle), getString(R.string.gamePeakPublisher), getString(R.string.gamePeakDeveloper), getString(R.string.gamePeakDescription), R.drawable.peakherobanner, R.drawable.peakherothumbnail));

        MyAdapter adapter = new MyAdapter(gameList);
        recyclerView.setAdapter(adapter);



    }
}