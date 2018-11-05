package com.jamiecoe;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Playlist myPlaylist = new Playlist();
    private static AlbumList myAlbumList = new AlbumList();

    public static void main(String[] args) {
        Album isThisIt = new Album("Is This It");
        isThisIt.addSong("Someday", 3.45);
        isThisIt.addSong("Last Night", 2.43);

        Album scott3 = new Album("Scott 3");
        scott3.addSong("It's raining today", 3.34);
        scott3.addSong("Copenhagan", 4.23);

        myAlbumList.addAlbum(isThisIt);
        myAlbumList.addAlbum(scott3);

        addSongToPlaylist("Last Night");
        addSongToPlaylist("Someday");

        boolean quit = false;

        while (!quit) {
            System.out.println("Enter an action code:");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Quiting playlist");
                    quit = true;
                    break;
                case 1:
                    myPlaylist.printPlayList();
                    break;
                case 2:
                    addSongToPlaylist();
                    break;
                case 3:
                    myPlaylist.enterPlaylist(scanner);
                    break;
                case 4:
                    removeSongFromPlaylist();
                    break;
            }
        }
    }

    public static void addSongToPlaylist() {
        System.out.println("Search for a song to add to playlist:");
        String searchSongTitle = scanner.nextLine();

        Song searchSong = myAlbumList.searchForSong(searchSongTitle);

        if(searchSong != null) {
            myPlaylist.addSong(searchSong);
        } else {
            System.out.println("This song does not exist in your library");
        }
    }

    public static void addSongToPlaylist(String searchSongTitle) {
        Song searchSong = myAlbumList.searchForSong(searchSongTitle);

        if(searchSong != null) {
            myPlaylist.addSong(searchSong);
        } else {
            System.out.println("This song does not exist in your library");
        }
    }

    public static void removeSongFromPlaylist() {
        System.out.println("Search for a song to remove from playlist:");
        String searchSongTitle = scanner.nextLine();

        Song searchSong = myPlaylist.searchForSong(searchSongTitle);

        if(searchSong != null) {
            myPlaylist.removeSong(searchSong);
        } else {
            System.out.println("This song does not exist in your playlist");
        }
    }


}
