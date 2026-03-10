package org.baltimorecityschools.videogameapp;

public class Game {
    String title;
    String publishers;
    String description;
    int heroBanner;
    int heroThumbnail;

    public Game(){
        title = "";
        publishers = "";
        description = "";
        heroBanner = 0;
        heroThumbnail = 0;
    }

    public Game(String title, String publishers, String description, int heroBanner, int heroThumbnail) {
        this.title = title;
        this.publishers = publishers;
        this.description = description;
        this.heroBanner = heroBanner;
        this.heroThumbnail = heroThumbnail;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublishers(String publishers) {
        this.publishers = publishers;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHeroBanner(int heroBanner) {
        this.heroBanner = heroBanner;
    }

    public void setHeroThumbnail(int heroThumbnail) {
        this.heroThumbnail = heroThumbnail;
    }

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
