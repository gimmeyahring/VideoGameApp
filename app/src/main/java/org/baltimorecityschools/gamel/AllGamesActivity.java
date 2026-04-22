package org.baltimorecityschools.gamel;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
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
        Allgames.allgames = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        List<Game> gameList = new ArrayList<>();



        List<String> peakTags = new ArrayList<>(
                Arrays.asList("Multiplayer", "Co-op", "Indie", "Platformer", "Adventure"));
        List<String> daveTags = new ArrayList<>(
                Arrays.asList("Adventure", "Simulation", "Indie", "RPG", "Relaxing"));
        List<String>eldenringTags = new ArrayList<>(
                Arrays.asList("Soulslike", "Singleplayer", "Action", "RPG", "Open World"));
        List<String> rocketleagueTags = new ArrayList<>(
                Arrays.asList("Sports", "Racing", "Indie", "Co-op", "Multiplayer"));
        List<String> digimonTags = new ArrayList<>(
                Arrays.asList("Anime", "RPG", "Fantasy", "Singleplayer", "Story Rich"));
        List<String> brawlstarsTags = new ArrayList<>(
                Arrays.asList("Mobile", "Action", "Shooter", "Multiplayer", "MOBA"));




        gameList.add(new Game(getString(R.string.gamePeakTitle), getString(R.string.gamePeakPublisher), getString(R.string.gamePeakDeveloper), getString(R.string.gamePeakDescription), getString(R.string.gamePeakUpdates), R.drawable.peakherobanner, R.drawable.peakherothumbnail, peakTags));
        gameList.add(new Game(getString(R.string.gameDavetitle), getString(R.string.gameDavepublisher), getString(R.string.gameDavedeveloper), getString(R.string.gameDavedesc), getString(R.string.gameDaveupdates), R.drawable.daveherobanner, R.drawable.daveherothumbnail2, daveTags));
        gameList.add(new Game(getString(R.string.gameEldenringtitle), getString(R.string.gameEldenrinpublisher), getString(R.string.gameEldenringdeveloper), getString(R.string.gameEldendesc), getString(R.string.gameEldenringupdates), R.drawable.eldenringherobanner, R.drawable.eldenringherothumbnail, eldenringTags));
        gameList.add(new Game(getString(R.string.gameBrawlStarstitle), getString(R.string.gameBrawlstarspublisher), getString(R.string.gameBrawlstarsdeveloper), getString(R.string.gameBrawlStarsdesc), getString(R.string.gameBrawlstarsupdate), R.drawable.brawlstarsherobanner, R.drawable.brawlstarsherothumbnail, brawlstarsTags));
        gameList.add(new Game(getString(R.string.gameDigimontitle), getString(R.string.gameDigimonpublisher), getString(R.string.gameDigimondeveloper), getString(R.string.gameDigimondesc), getString(R.string.gameDigimonUpdates), R.drawable.digimonherobanner, R.drawable.digimonherothumbnail2, digimonTags));
        gameList.add(new Game(getString(R.string.gameRocketleauguetitle), getString(R.string.gameRocketleaguepublisher), getString(R.string.gameRocketleaguedeveloper), getString(R.string.gameRocketLeaguedesc), getString(R.string.gameRocketleagueupdates), R.drawable.rocketleagueherobanner, R.drawable.rocketleagueherothumbnail, rocketleagueTags));

        MyAdapter adapter = new MyAdapter(gameList);
        Allgames.allgames.addAll(gameList);
        recyclerView.setAdapter(adapter);



    }
}