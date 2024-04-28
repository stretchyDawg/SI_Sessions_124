package si.session_activities.mock_practicums.test04.set02.the_shining;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import si.review.networking_review.duplexer.Duplexer; 
// Import YOUR duplexer, you can use the one we provided

public class ShiningServer {
    private Duplexer duplexer;

    public ShiningServer(Socket client) throws IOException{
        this.duplexer = new Duplexer(client);
        this.createStory();
    }

    public void createStory() throws IOException{
        String token;
        String file = WordDump.STORY_FILES[0];

        FileReader fr = new FileReader(file);
        BufferedReader buffReader = new BufferedReader(fr);
        String line = buffReader.readLine();
        String[] tokens = line.split(" ");
        
        for (int i=0; i< tokens.length; i++){
            token = tokens[i];
            if (token.equals("STUDENT") || token.equals("SIleader")){
                this.duplexer.send(token);
                System.out.println("\t...sent " + token);
                String rep = duplexer.read();
                
                System.out.println("Received " + rep +"!");
                tokens[i] = rep;
            }
        }

        duplexer.send("DONE");
        String str = "";                         
        for (int i=0; i< tokens.length; i++){
            token = tokens[i];
            str += token + " ";
            System.out.print(token + " ");
        }
        str += "\n";

        this.duplexer.send(str);

        this.duplexer.close();
        buffReader.close();        
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

