package com.jamiecoe;

import java.util.ArrayList;

public class AlbumList {
    private ArrayList<Album> albumList;

    public AlbumList() {
        this.albumList = new ArrayList<Album>();
    }

    public void addAlbum(Album newAlbum) {
        this.albumList.add(newAlbum);
    }

    public Song searchForSong(String searchSongTitle) {
        for (Album album: this.albumList) {
            Song searchSong = album.searchForSong(searchSongTitle);
            if (searchSong != null) {
                return searchSong;
            }
        }

        return null;
    }
}
