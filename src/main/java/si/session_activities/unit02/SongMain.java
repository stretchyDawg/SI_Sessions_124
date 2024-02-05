package si.session_activities.unit02;

public class SongMain {
    public static void main(String[] args) {
        System.out.println();

        Song song1 = new Song("Only If", "Steve Lacy", 100, SongType.ALBUM);
        System.out.println(song1 + "\n");

        Song song2 = new Song("Kelly Green Hardcore", "Destructo Disk", 115, SongType.SINGLE);
        System.out.println(song2 + "\n");

        Song song3 = new Song("Kelly Green Hardcore", "Destructo Disk", 115, SongType.EP);
        System.out.println(song3 + "\n");
        
        System.out.println("Is song2 equal to song3?: " + song2.equals(song3));
    }
}
