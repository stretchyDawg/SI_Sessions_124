package si.session_activities.unit12;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import si.review.networking_review.duplexer.Duplexer;

public class ProductServer {
    private ServerSocket serverSocket;
    private static int product;
    private ArrayList<Duplexer> dupps;

    public ProductServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        product = 1;   //initializing it here, so that every handler gets the same product varible
        this.dupps = new ArrayList<>();
        startListening();
    }

    private void startListening() {
        System.out.println("Server is running...");
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();         // we connect to a Sum client (the socket represents the Sumclient)
                System.out.println("New client connected: " + clientSocket);

                // Instead of making a Runnable class (called Proxy), I just
                // used a lambda to make a runnable, which does the same thing Proxy would do (call the handleClient method of the server)
                new Thread(() -> {
                    try {
                        handleClient(clientSocket);     //passing the clientsocket (aka the client), if you have that socket, you can make the duplexer
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();     // starting that thread

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // the method name explains it. You wouldn't wanna make the whole server a runnable, which case you would be 
    // remaking a new server socket for each client, that ruins the purpose
    // We want to make the portion the server runnable that every client needs a exclusive access to 
    // its like server needs to talk with every client, all at the same time, so it needs multiple mediums (duplexers)
    // to do that
    private void handleClient(Socket clientSocket) throws IOException {
        Duplexer duplexer = new Duplexer(clientSocket);      // new duplexer for each new Sumclient
        dupps.add(duplexer);
        String number;

        // server side logic, receive a integer, add it to product, send the product back to the client
        while (!(number = duplexer.read()).equals("0")) {
            System.out.println("Received number from client: " + number);
            int num = Integer.parseInt(number);
            product *= num; // Multiply the number with current product
            System.out.println("Current product: " + product);
            duplexer.send(Integer.toString(product));
        }

        // while loop breaks because the client entered 0, so broadcast now to everyone else
        broadcast();

    
        duplexer.close();
    }


    public void broadcast(){
        for (Duplexer each: dupps){
            each.send("He dipped");  // this might be delayed on a client that hasn't responded yet, you will see it
        }
    }



    public static void main(String[] args) throws IOException {
        new ProductServer(9999);
    }
}

