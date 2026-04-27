package org.baltimorecityschools.gamel;

import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Allgames {
    public static List<Game> allgames = new ArrayList<>();

    public static void loadallgames(Context context) {

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




        allgames.add(new Game(context.getString(R.string.gamePeakTitle), context.getString(R.string.gamePeakPublisher), context.getString(R.string.gamePeakDeveloper), context.getString(R.string.gamePeakDescription), context.getString(R.string.gamePeakUpdates), R.drawable.peakherobanner, R.drawable.peakherothumbnail, peakTags));
        allgames.add(new Game(context.getString(R.string.gameDavetitle), context.getString(R.string.gameDavepublisher), context.getString(R.string.gameDavedeveloper), context.getString(R.string.gameDavedesc), context.getString(R.string.gameDaveupdates), R.drawable.daveherobanner, R.drawable.daveherothumbnail2, daveTags));
        allgames.add(new Game(context.getString(R.string.gameEldenringtitle), context.getString(R.string.gameEldenrinpublisher), context.getString(R.string.gameEldenringdeveloper), context.getString(R.string.gameEldendesc), context.getString(R.string.gameEldenringupdates), R.drawable.eldenringherobanner, R.drawable.eldenringherothumbnail, eldenringTags));
        allgames.add(new Game(context.getString(R.string.gameBrawlStarstitle), context.getString(R.string.gameBrawlstarspublisher), context.getString(R.string.gameBrawlstarsdeveloper), context.getString(R.string.gameBrawlStarsdesc), context.getString(R.string.gameBrawlstarsupdate), R.drawable.brawlstarsherobanner, R.drawable.brawlstarsherothumbnail, brawlstarsTags));
        allgames.add(new Game(context.getString(R.string.gameDigimontitle), context.getString(R.string.gameDigimonpublisher), context.getString(R.string.gameDigimondeveloper), context.getString(R.string.gameDigimondesc), context.getString(R.string.gameDigimonUpdates), R.drawable.digimonherobanner, R.drawable.digimonherothumbnail2, digimonTags));
        allgames.add(new Game(context.getString(R.string.gameRocketleauguetitle), context.getString(R.string.gameRocketleaguepublisher), context.getString(R.string.gameRocketleaguedeveloper), context.getString(R.string.gameRocketLeaguedesc), context.getString(R.string.gameRocketleagueupdates), R.drawable.rocketleagueherobanner, R.drawable.rocketleagueherothumbnail, rocketleagueTags));

    }
}
