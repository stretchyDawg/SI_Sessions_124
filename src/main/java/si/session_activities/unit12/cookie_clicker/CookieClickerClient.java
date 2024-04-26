package si.session_activities.unit12.cookie_clicker;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import si.review.networking_review.duplexer.Duplexer;

public class CookieClickerClient {
    private Duplexer duplexer;
    private Scanner scanner;

    public CookieClickerClient(String host, int port) throws IOException {
        Socket socket = new Socket(host, port);
        this.duplexer = new Duplexer(socket);
        this.scanner = new Scanner(System.in);
        System.out.println("\nConnected to server with port " + port + ".");
    }

    public void start() throws IOException {
        String input;
        while(true){
            System.out.print(">> ");
            input = scanner.nextLine();
            this.duplexer.send(input);
            if(input.toLowerCase().equals("exit")){
                break;
            }            
        }
        this.close();
    }

    public void close() throws IOException {
        this.duplexer.close();
        this.scanner.close();
    }

    public static void main(String[] args) {
        try {
            CookieClickerClient client = new CookieClickerClient("localhost", 1234); // Connect to server at localhost:1234
            client.start();
        } catch (IOException e) {
            System.out.println("No server found on port 1234...");
        }
    }
}

