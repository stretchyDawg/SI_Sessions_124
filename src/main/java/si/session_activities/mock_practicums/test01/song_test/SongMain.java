package si.session_activities.mock_practicums.test01.song_test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SongMain {
    public static Song[] getSongs(String filename) throws FileNotFoundException, IOException{
        try(FileReader fw = new FileReader(filename); BufferedReader br = new BufferedReader(fw);){
            
            Song[] songArray = new Song[10];

            return songArray;
        }
    }
    
    public static void main(String[] args) {
        
    }
}
