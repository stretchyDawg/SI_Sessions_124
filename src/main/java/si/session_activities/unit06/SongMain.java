package si.session_activities.unit06;

import java.util.Collections;
import java.util.LinkedList;

public class SongMain {
    public static void main(String[] args) {
        System.out.println();

        SongSI song1 = new SongSI("a", "c", 100);
        SongSI song2 = new SongSI("b", "b", 100);
        SongSI song3 = new SongSI("c", "a", 100);

        LinkedList<SongSI> songs = new LinkedList<>(); 
        songs.add(song1);
        songs.add(song2);
        songs.add(song3);

        Collections.sort(songs);
        System.out.println("Class Comparator:");
        for(SongSI song: songs){
            System.out.println(song);
        }
        System.out.println();

        System.out.println("External Song Comparator:");
        Collections.sort(songs, new SongComparator());
        for(SongSI song: songs){
            System.out.println(song);
        }
        System.out.println();
    }
}
