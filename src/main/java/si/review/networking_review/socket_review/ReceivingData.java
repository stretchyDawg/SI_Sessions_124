package si.review.networking_review.socket_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceivingData {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 54321); // <-- Arbitrary fields inputted, will not work (see unit 12 activity for a working receiver)
        InputStream input = client.getInputStream();
        InputStreamReader ir = new InputStreamReader(input);
        BufferedReader reader = new BufferedReader(ir);
        
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            line = reader.readLine();
        }
        client.close();
    }
}



        // can also use Scanners: 

        // Socket client = new Socket("localhost", 54321);
        // InputStream input = client.getInputStream();
        // Scanner scanner = new Scanner(input);

        // System.out.println();
        // while(scanner.hasNext()){
        //     System.out.print(scanner.next() + " ");
        // }

        // client.close();
        // scanner.close();
        // System.out.println();
