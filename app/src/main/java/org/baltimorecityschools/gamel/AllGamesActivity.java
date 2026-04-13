package org.baltimorecityschools.gamel;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
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

        List<String> peakTags = new ArrayList<>(
                Arrays.asList("Multiplayer", "Co-op", "Indie", "Platformer"));

        gameList.add(new Game(getString(R.string.gamePeakTitle), getString(R.string.gamePeakPublisher), getString(R.string.gamePeakDeveloper), getString(R.string.gamePeakDescription), getString(R.string.loremispumparagraph), R.drawable.peakherobanner, R.drawable.peakherothumbnail, peakTags));

        MyAdapter adapter = new MyAdapter(gameList);
        recyclerView.setAdapter(adapter);



    }
}