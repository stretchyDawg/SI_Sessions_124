/*
SONG QUEUE:
0: You can use your laptops for this! Pair up with someone and work together to do this.

1: You have been provided with a text file called songs.txt. It contains 8 songs. Parse and process the file and enqueue all of those songs to some queue.

2: Create a mechanism to ‘play’ songs in the queue. 
2a: While the queue isn’t empty, display the current song that’s playing (you may have to edit your NodeQueue.java class file). Also, display the amount of songs left.
2b: In the terminal, allow for the user to enter ‘play’ to move on to the next song. Once you reach the end of the queue, display on the CLI: “Playlist over!”.
*/

package si.session_activities.unit05;

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

        Scanner scan = new Scanner(System.in);
        while(queue.size() != 0){
            System.out.println();
            // System.out.println("Current song: " + queue.getFront());   Now not working because I got rid of this method. Fix for future uses of this activity.
            System.out.println("Songs left: " + queue.size());
            System.out.print(">> ");
            String input = scan.nextLine();
            if(input.toLowerCase().equals("play")){
                queue.dequeue();
                continue;
            }
            continue;
        }
        scan.close();
        System.out.println("\nPlaylist done!");
    }
}
