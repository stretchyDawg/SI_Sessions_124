package si.review.networking_review.duplexer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Duplexer {
    
    private Socket socket;
    private Scanner in; // For receiving data
    private PrintWriter out; // For writing data

    public Duplexer(Socket socket) throws IOException{
        this.socket = socket;
        this.in = new Scanner(socket.getInputStream());    
        this.out = new PrintWriter(socket.getOutputStream());
    }

    public void close() throws IOException{
        this.socket.close();
        this.in.close();
        this.out.close();
    }

    public void send(String message){
        this.out.println(message);
        this.out.flush();
    }

    public String read(){
        return this.in.nextLine();
    }
}
