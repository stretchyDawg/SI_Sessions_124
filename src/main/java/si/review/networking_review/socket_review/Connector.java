package si.review.networking_review.socket_review;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connector {
    public static void main(String[] args) throws UnknownHostException, IOException {
        // Socket x = new Socket(hostname / url / ip address, port);
        
        Socket google = new Socket("www.google.com", 80);
        Socket npr = new Socket("www.npr.org", 443);
        google.close();
        npr.close();
    }
}

