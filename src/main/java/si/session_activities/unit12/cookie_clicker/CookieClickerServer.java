package si.session_activities.unit12.cookie_clicker;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import si.review.networking_review.duplexer.Duplexer;

public class CookieClickerServer {
    private ServerSocket serverSocket;
    private Duplexer duplexer;

    public CookieClickerServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
        System.out.println("\nServer is listening on port " + port);
    }

    public void start() {
        try {
            System.out.println("Waiting for clients...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.\n");
            duplexer = new Duplexer(clientSocket);
            
            String message = ""; 
            while(!message.equals("exit")){
                message = duplexer.read();
                System.out.println("Received from client: " + message);
            }

            try {
                if (duplexer != null) {
                    duplexer.close();
                }
                serverSocket.close();
            } catch (IOException e) {e.printStackTrace();}
        } catch (IOException e) {e.printStackTrace();} 
    }

    public static void main(String[] args) throws IOException {
        CookieClickerServer server = new CookieClickerServer(1234);
        server.start();
    }
}
