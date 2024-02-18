package si.session_activities.unit04.observer_pattern_activity.song_queue.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import si.data_structures.queues.NodeQueue;

public class SpotifyQueue {
    private NodeQueue<String> queue;

    public SpotifyQueue() {
        this.queue = new NodeQueue<String>();
    }

    public void enqueueSong(String song){
        this.queue.enqueue(song);
    }
    public String dequeueSong(){
        return this.queue.dequeue();
    }
    public void enqueueFile(String filename) throws FileNotFoundException, IOException{
        try(FileReader fr = new FileReader(filename); BufferedReader br = new BufferedReader(fr);){
            String line = br.readLine();
            while(line != null){
                queue.enqueue(line);
                line = br.readLine();
            }
        }
    }

    public String getSongsLeft(){
        return Integer.toString(queue.size());
    }

}
