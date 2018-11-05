package com.jamiecoe;

import java.util.ArrayList;

public class Album {
    private String title;
    private ArrayList<Song> songs;

    public Album(String title) {
        this.title = title;
        this.songs = new ArrayList<Song>();
    }

    public void addSong(String title, double duration) {
        this.songs.add(new Song(title, duration));
    }

    public Song searchForSong(String searchSongTitle) {
        for (Song song: this.songs) {
            if (song.getTitle().equals(searchSongTitle)) {
                return song;
            }
        }

        return null;
    }
}
