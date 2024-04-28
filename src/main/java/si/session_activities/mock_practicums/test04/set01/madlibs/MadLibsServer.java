package si.session_activities.mock_practicums.test04.set01.madlibs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class MadLibsServer {
    private Duplexer duplexer;
    private Random RNG;

    public MadLibsServer(Socket socket) throws IOException {
        this.duplexer = new Duplexer(socket);
        this.RNG = new Random();
    }

    public void createStory() throws IOException{
        int i = RNG.nextInt(MadLibsUtil.STORY_FILES.length);
        String storyfile = MadLibsUtil.STORY_FILES[i];
        FileReader fileReader = new FileReader(storyfile);
        BufferedReader reader = new BufferedReader(fileReader);
        System.out.println(storyfile);
        
        String line = reader.readLine();
        String[] splitLine = line.split(" ");
        for(String word : splitLine){
            if(word.equals("NOUNS")){
                System.out.println("Sent: " + word);
                duplexer.send(word);
            }
            else if(word.equals("VERBS")){
                System.out.println("Sent: " + word);
                duplexer.send(word);
            }
            else if(word.equals("ADJECTIVE")){
                System.out.println("Sent: " + word);
                duplexer.send(word);
            }
            else if(word.equals("NAMES")){
                System.out.println("Sent: " + word);
                duplexer.send(word);
            }
            else if(word.equals("ADVERBS")){
                System.out.println("Sent: " + word);
                duplexer.send(word);
            }
            else if(word.equals("DONE")){
                System.out.println("Sent: " + word);
                String story = duplexer.receive();
                System.out.println("Sent: " + story);
                duplexer.send(story);
            }
            duplexer.send(word);
        }
        reader.close();
    }
    
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(54321);
        System.out.println("The server is listening and waiting for a client...");
        Socket client = server.accept();
        System.out.println("A client connects!");
        MadLibsServer mls = new MadLibsServer(client);
        mls.createStory();

        System.out.println("Closing Client Socket");
        System.out.println("Closing Server Socket");
        server.close();
    }
}
