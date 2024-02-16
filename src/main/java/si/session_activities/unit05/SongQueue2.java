package si.session_activities.unit05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import si.data_structures.queues.NodeQueue;

public class SongQueue2 {
    public static void main(String[] args) {
        NodeQueue<String> q = new NodeQueue<String>();

        try (
            FileReader fReader = new FileReader("src\\main\\java\\si\\session_activities\\unit05\\songs2.txt");
            BufferedReader reader = new BufferedReader(fReader);
        ) {
            String song;
            while ((song = reader.readLine()) != null) {
                // enq's songs in the file
                q.enqueue(song);
            }
            System.out.println(q);
        } catch (IOException e) {
            // TODO: handle exception
        }

        Scanner scanner = new Scanner(System.in);
        String input;
        
        while (q.size() > 0) {
            System.out.println("Do you want to play the next song?");
            input = scanner.nextLine();
            if (input.equals("play")) {
                System.out.println(q.dequeue() + ", songs left: " + q.size());
            }        
        }
        System.out.println("good bye!");
    }
}
