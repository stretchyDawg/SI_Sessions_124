package si.session_activities.mock_practicums.test04.set01.madlibs;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

public class MadLibsClient {
    private Random RNG;
    private Duplexer duplexer;
    private String story;

    public MadLibsClient(Socket socket) throws IOException {
        this.duplexer = new Duplexer(socket);
        this.RNG = new Random();
        this.story = "";
    }

    public void createStory(){
        while(true){
            String message = duplexer.receive();
            if(message != null){
                if(message.equals("DONE")){
                    System.out.println("Received: " + message);
                    System.out.println(story);
                    duplexer.send(story);
                }
                if(message.equals("NOUNS")){
                    System.out.println("Received: " + message);

                    int i = RNG.nextInt(MadLibsUtil.NOUNS.length);
                    String randomNoun = MadLibsUtil.NOUNS[i];
                    this.story += randomNoun + " ";
                }
                else if(message.equals("VERBS")){
                    System.out.println("Received: " + message);

                    int i = RNG.nextInt(MadLibsUtil.VERBS.length);
                    String randomVerb = MadLibsUtil.VERBS[i];
                    this.story += randomVerb + " ";
                }
                else if(message.equals("ADJECTIVE")){
                    System.out.println("Received: " + message);

                    int i = RNG.nextInt(MadLibsUtil.ADJECTIVES.length);
                    String randomAdj = MadLibsUtil.ADJECTIVES[i];
                    this.story += randomAdj + " ";
                }
                else if(message.equals("NAMES")){
                    System.out.println("Received: " + message);

                    int i = RNG.nextInt(MadLibsUtil.NAMES.length);
                    String randomName = MadLibsUtil.NAMES[i];
                    this.story += randomName + " ";
                }
                else if(message.equals("ADVERBS")){
                    System.out.println("Received: " + message);

                    int i = RNG.nextInt(MadLibsUtil.ADVERBS.length);
                    String randomAdv = MadLibsUtil.ADVERBS[i];
                    this.story += randomAdv + " ";
                }
                else{
                    this.story += message + " ";
                }
            }
        }
    }
    
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket = new Socket("localhost", 54321);
        System.out.println("Connected to localhost:54321");
        MadLibsClient mlc = new MadLibsClient(socket);
        mlc.createStory();

        System.out.println("Closing socket");
    }
}
