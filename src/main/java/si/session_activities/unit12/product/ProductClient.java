package si.session_activities.unit12;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import si.review.networking_review.duplexer.Duplexer;

// You can figure this out, just a client

public class ProductClient {
    private Duplexer duplexer;      //Client's personal duplexer       
    private Scanner userIn;

    public ProductClient(int port) throws IOException {
        Socket socket = new Socket("localhost", port);         // server lives on localhost  
        duplexer = new Duplexer(socket);
        userIn = new Scanner(System.in);
        task();
    }

    public void task() throws IOException {
        String number = "";
        int product = 1; // Initialize product to 1
        while (!number.equals("0")) {
            System.out.print("Enter a number: ");
            number = userIn.nextLine();
            duplexer.send(number);

            String receivedProduct = duplexer.read();
            try{                                              // if this wasn't put in a try block, client would try to parse "He dipped" as an integer
            product = Integer.parseInt(receivedProduct);
            System.out.println("Product = " + product);
            }
            catch (Exception e){
                System.out.println(receivedProduct);
            }
        }
        duplexer.close();
        userIn.close();
    }

    public static void main(String[] args) throws IOException {
        new ProductClient(9999);
    }
}
