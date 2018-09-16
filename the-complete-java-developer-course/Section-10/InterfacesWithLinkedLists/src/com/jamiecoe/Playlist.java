package com.jamiecoe;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Playlist {
    private List<Song> playlist;
    private ListIterator<Song> playlistIterator;

    public Playlist() {
        this.playlist = new LinkedList<Song>();
    }

    public List<Song> getPlaylist() {
        return playlist;
    }

    public void addSong(Song newSong) {
        System.out.println("Adding '" + newSong.getTitle() + "' to the playlist");
        this.playlist.add(newSong);
    }

    public void removeSong(Song songToRemove) {
        System.out.println("Removing '" + songToRemove.getTitle() + "' from playlist");
        this.playlist.remove(songToRemove);
    }

    public void printPlayList() {
        System.out.println("Printing Playlist");
        System.out.println("=============");
        for (int i = 0; i < this.playlist.size(); i++) {
            Song currentSong = this.playlist.get(i);
            System.out.println((i + 1) + ". " + currentSong.getTitle() + " (" + currentSong.getDuration() + ")");
        }
        System.out.println("=============");
    }

    public Song searchForSong(String searchSongTitle) {
        for (Song song: this.playlist) {
            if (song.getTitle().equals(searchSongTitle)) {
                return song;
            }
        }

        return null;
    }

    public void enterPlaylist(Scanner scanner) {
        boolean quit = false;
        boolean goingForward = true;
        this.playlistIterator = this.playlist.listIterator();

        if (this.playlist.isEmpty()) {
            System.out.println("No songs in playlist!");
            quit = true;
        }

        while (!quit) {
            System.out.println("Enter playlist option:");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Quiting playlist!");
                    quit = true;
                    break;
                case 1:
                    playCurrentSong();
                    break;
                case 2:
                    skipForward();
                    break;
                case 3:
                    skipBackwards();
                    break;
            }
         }
    }

    private void playCurrentSong() {
        if (this.playlistIterator.hasNext()) {
            System.out.println("Now playing '" + this.playlistIterator.next().getTitle() + "'");
            this.playlistIterator.previous();
        } else {
            System.out.println("Reached the end of the playlist!");
        }
    }

    private void skipForward() {
        if (this.playlistIterator.hasNext()) {
            this.playlistIterator.next();

            if (this.playlistIterator.hasNext()) {
                System.out.println("Skipping forward to '" + this.playlistIterator.next().getTitle() + "'");
                this.playlistIterator.previous();
            } else {
                System.out.println("Reached the end of the playlist!");
                this.playlistIterator.previous();
            }

        } else {
            System.out.println("Reached the end of the playlist!");
            this.playlistIterator.previous();
        }
    }

    private void skipBackwards() {
        if (this.playlistIterator.hasPrevious()) {
            System.out.println("Skipping back to '" + this.playlistIterator.previous().getTitle() + "'");
        } else {
            System.out.println("You are at the beginning of the playlist!");
        }
    }
}
