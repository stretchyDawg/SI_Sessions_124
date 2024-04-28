import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

public class ShiningClient {
    private Duplexer duplexer;
    
    
    public ShiningClient(Socket sock) throws IOException, InterruptedException{
        this.duplexer = new Duplexer(sock);
        System.out.println("Connected to " + sock.getInetAddress().getHostName() + ":" + "54321");
        createStory();
    }

    public void createStory() throws IOException, InterruptedException{
        Random random = new Random();
        String rep = duplexer.read();
        while (!rep.equals("DONE")){
            Thread.sleep(1000);
            //rep = rep.toUpperCase();
            System.out.println("Received " + rep +"!");
            String[] out = WordDump.PLACEHOLDERS.get(rep);
            int num = random.nextInt(out.length);

            String outgoing = out[num];

            duplexer.send(outgoing);
            System.out.println("\t...sent " + outgoing);
            rep = duplexer.read();
        }

        System.out.println(duplexer.read());

        duplexer.close();
    }

    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
        Socket socket = new Socket("localhost", 54321);
        new ShiningClient(socket);   
    }

}
