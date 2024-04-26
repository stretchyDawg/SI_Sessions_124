package si.session_activities.unit12.sum;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import si.review.networking_review.duplexer.Duplexer;

public class SumServer {
    private ServerSocket serverSocket;
    private Duplexer duplexer;
    private int sum;
    
    public SumServer(int port) throws IOException {
        this.sum = 0;
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        this.duplexer = new Duplexer(socket);
        handle();

        serverSocket.close();
    }

    public void handle() throws IOException{
        String number = duplexer.read();
        Integer intNumber = Integer.parseInt(number);
        while(intNumber >= 0){
            if(intNumber == 0){
                duplexer.send(String.valueOf(sum));
                duplexer.close();
                serverSocket.close();
            }
            this.sum += intNumber;
            intNumber--;
        }
    }

    // public static void main(String[] args) throws IOException {
    //     System.out.println("Starting server...");
    //     SumServer sumServer = new SumServer(9999);
        

    // }

    //this does not work :/

    
}
