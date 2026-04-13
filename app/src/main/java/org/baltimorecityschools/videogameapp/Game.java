package org.baltimorecityschools.videogameapp;

import java.util.List;

public class Game {
    String title;
    String publishers;
    String developers;
    String description;
    int heroBanner;
    int heroThumbnail;
    List<String> tags;
    

    public Game(){
        title = "";
        publishers = "";
        developers = "";
        description = "";
        heroBanner = 0;
        heroThumbnail = 0;
    }

    public Game(String title, String publishers, String developers, String description, int heroBanner, int heroThumbnail, List<String> tags) {
        this.title = title;
        this.publishers = publishers;
        this.developers = developers;
        this.description = description;
        this.heroBanner = heroBanner;
        this.heroThumbnail = heroThumbnail;
        this.tags = tags;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublishers(String publishers) {
        this.publishers = publishers;
    }

    public void setDevelopers(String developers) {this.developers = developers;}

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHeroBanner(int heroBanner) {
        this.heroBanner = heroBanner;
    }

    public void setHeroThumbnail(int heroThumbnail) {
        this.heroThumbnail = heroThumbnail;
    }

    public String getTitle() {
        return title;
    }

    public String getPublishers() {return publishers;}

    public String getDevelopers() {return developers;}


    public String getDescription() {return description;}

    public int getHeroBanner() {return heroBanner;}

    public int getHeroThumbnail() {return heroThumbnail;}

    public List<String> getTags() {return tags;}

    @Override
    public String toString() {
        return "Game{" +
                "title='" + title + '\'' +
                ", publishers='" + publishers + '\'' +
                ", description='" + description + '\'' +
                ", heroBanner=" + heroBanner +
                ", heroThumbnail=" + heroThumbnail +
                '}';
    }
}
