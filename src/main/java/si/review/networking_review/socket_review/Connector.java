package si.review.networking_review.basic_connections;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connector {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket google = new Socket("www.google.com", 80);
        Socket npr = new Socket("www.npr.org", 443);
        google.close();
        npr.close();
    }
}

