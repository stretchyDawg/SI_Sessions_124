package si.review.networking_review.socket_review;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SendingData {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 54321);
        OutputStream out = socket.getOutputStream();
        PrintWriter printer = new PrintWriter(out);
        printer.println("John Denver");
        printer.flush();
        socket.close();
    }
}
