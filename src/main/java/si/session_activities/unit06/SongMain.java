package si.session_activities.unit06;

import java.util.Collections;
import java.util.LinkedList;

public class SongMain {
    public static void main(String[] args) {
        System.out.println();

        Song song1 = new Song("a", "c", 100);
        Song song2 = new Song("b", "b", 100);
        Song song3 = new Song("c", "a", 100);

        LinkedList<Song> songs = new LinkedList<>(); 
        songs.add(song1);
        songs.add(song2);
        songs.add(song3);

        Collections.sort(songs);
        System.out.println("Class Comparator:");
        for(Song song: songs){
            System.out.println(song);
        }
        System.out.println();

        System.out.println("External Song Comparator:");
        Collections.sort(songs, new SongComparator());
        for(Song song: songs){
            System.out.println(song);
        }
        System.out.println();
    }
}
