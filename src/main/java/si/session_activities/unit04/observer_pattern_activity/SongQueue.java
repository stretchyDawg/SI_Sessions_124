package si.session_activities.unit04.observer_pattern_activity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import si.data_structures.queues.NodeQueue;

public class SongQueue {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        NodeQueue<String> queue = new NodeQueue<String>();
        System.out.println();

        try(FileReader fr = new FileReader("C:\\Users\\Christian Morgado\\Repos\\SI\\SI_Sessions_124\\src\\main\\java\\si\\session_activities\\unit05\\songs2.txt"); BufferedReader br = new BufferedReader(fr);){
            String line = br.readLine();
            while(line != null){
                queue.enqueue(line);
                line = br.readLine();
            }
        }

        System.out.println(queue); // Testing to make sure the queue has everything.
        String song = queue.dequeue();

        Scanner scan = new Scanner(System.in);
        while(queue.size() != 0){
            System.out.println();
            System.out.println("Current song: " + song);
            System.out.println("Songs left: " + queue.size());
            System.out.print(">> ");
            String input = scan.nextLine();
            if(input.toLowerCase().equals("play")){
                song = queue.dequeue();
                continue;
            }
            continue;
        }
        scan.close();
        System.out.println("\nPlaylist done!");
    }
}
