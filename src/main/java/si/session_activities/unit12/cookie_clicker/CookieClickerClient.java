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

    public void start() {
        try {
            String input;
            while(true){
                System.out.print(">> ");
                input = scanner.nextLine();
                this.duplexer.send(input);
                if(input.toLowerCase().equals("exit")){
                    break;
                }            
            }
            try {
                this.duplexer.close();
                this.scanner.close();
            } catch (IOException e) {e.printStackTrace();}
        } catch (Exception e) {e.printStackTrace();} 
    }

    public static void main(String[] args) {
        try {
            CookieClickerClient client = new CookieClickerClient("localhost", 1234); // Connect to server at localhost:1234
            client.start();
        } catch (IOException e) {
            System.out.println("Unable to connect to server: " + e.getMessage());
        }
    }
}

