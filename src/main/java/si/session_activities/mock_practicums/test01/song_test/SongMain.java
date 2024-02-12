package si.session_activities.mock_practicums.test01.song_test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SongMain {    
    public static Song[] getSongs(String filename) throws FileNotFoundException, IOException{
        try(FileReader fw = new FileReader(filename); BufferedReader br = new BufferedReader(fw);){
            String line = br.readLine();
            int length = Integer.parseInt(line);
            Song[] songArray = new Song[length];

            for(int i = 0; i < songArray.length; i++){
                line = br.readLine();
                String[] splitLine = line.split("[,]");

                String title = splitLine[0];
                String author = splitLine[1];
                int runtime = Integer.parseInt(splitLine[2]);
                // String genreString = splitLine[3]; If statements for assigning genres.
                String albumOrSingle = splitLine[4];
                if(albumOrSingle.equals("Album")){
                    String albumTitle = splitLine[5];
                    AlbumSong albumSong = new AlbumSong(title, author, null, runtime, albumTitle);
                    songArray[i] = albumSong;
                }
                else if(albumOrSingle.equals("Single")){
                    SingleSong singleSong = new SingleSong(title, author, null, runtime);
                    songArray[i] = singleSong;
                }
            }
            return songArray;
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println();
        Song[] songs = getSongs("C:/songs.txt");
        for(Song song : songs){
            System.out.println(song);
        }
    }
}
