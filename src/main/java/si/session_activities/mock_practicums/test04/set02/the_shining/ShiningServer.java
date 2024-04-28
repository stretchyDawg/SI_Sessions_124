package si.session_activities.mock_practicums.test04.set02.the_shining;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import si.review.networking_review.duplexer.Duplexer;

public class ShiningServer {
    private Duplexer duplexer;


    public ShiningServer(Socket client) throws IOException{
        this.duplexer = new Duplexer(client);
        createStory();
    }

    public void createStory() throws IOException{
        String each;
        String file = WordDump.STORY_FILES[0];

        FileReader freader = new FileReader(file);
        BufferedReader bf = new BufferedReader(freader);
        String line = bf.readLine();
        String[] tokens = line.split(" ");
        
        for (int i=0; i< tokens.length; i++){
            each = tokens[i];
            if (each.equals("STUDENT") || each.equals("SIleader")  ){
                
                duplexer.send(each);
                System.out.println("\t...sent " + each);
                String rep = duplexer.read();
                
                System.out.println("Received " + rep +"!");
                tokens[i] = rep;
            }
        }

        duplexer.send("DONE");
        String str = "";                         
        for (int i=0; i< tokens.length; i++){
            each = tokens[i];
            str += each + " ";
            System.out.print(each + " ");
        }
        str += "\n";

        duplexer.send(str);

        duplexer.close();
        bf.close();        
    }

    public static void main(String[] args) throws IOException {
        try(ServerSocket sock = new ServerSocket(54321);){
            System.out.println("Listening on port 54321");
            System.out.println("Waiting for a client ....");
            Socket client = sock.accept();
            System.out.println(" Client Connected");
    
            new ShiningServer(client);
        }
    }
}
