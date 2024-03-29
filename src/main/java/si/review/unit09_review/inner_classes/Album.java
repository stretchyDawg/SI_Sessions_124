package si.review.unit09_review.inner_classes;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private String title;
    private int year;
    private List<Artist> artists;

    public Album(String title, int year) {
        this.title = title;
        this.year = year;
        this.artists = new ArrayList<>();
    }

    public void addArtist(String name, String genre) {
        Artist artist = new Artist(name, genre);
        artists.add(artist);
    }

    public void displayInfo() {
        System.out.println("Album: " + title);
        System.out.println("Year: " + year);
        System.out.println("Artists:");
        for (Artist artist : artists) {
            System.out.println("- " + artist.getName() + " (" + artist.getGenre() + ")");
        }
    }

    // Inner class representing an artist
    public class Artist {
        private String name;
        private String genre;

        public Artist(String name, String genre) {
            this.name = name;
            this.genre = genre;
        }

        public String getName() {
            return name;
        }

        public String getGenre() {
            return genre;
        }
    }

    public static void main(String[] args) {
        // Creating an album
        Album album = new Album("Thriller", 1982);
        album.addArtist("Michael Jackson", "Pop");
        album.addArtist("Quincy Jones", "Producer");

        // Displaying album information
        album.displayInfo();

        System.out.println("\nArtist 1 info: " + album.artists.get(0).getName() + ", " + album.artists.get(0).getGenre());
        System.out.println("\nArtist 2 info: " + album.artists.get(0).name + ", " + album.artists.get(0).genre); // same scope of container class
    }
}