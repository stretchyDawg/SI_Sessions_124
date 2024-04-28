package si.session_activities.mock_practicums.test04.set02.the_shining;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Duplexer {
    private Socket socket;

    private BufferedReader in;

    private PrintWriter out;
    
    public Duplexer (Socket socket)  throws IOException {
        this.socket = socket;
        InputStreamReader inputStreamReader = 
            new InputStreamReader(socket.getInputStream());
        in = new BufferedReader(inputStreamReader);
        out = new PrintWriter(socket.getOutputStream ());
    }

    public Socket getSocket() {
        return this.socket;
    }

    public void close() {
        try {
            socket.close();
            out.close();
            in.close();
        } catch(IOException ioe) {}
    }

    public void send(String message) {
        out.println(message);
        out.flush();
    }

    public String receive() {
        try {
            return in.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    // Same implementation as receive, different name
    public String read() {
        return receive();
    }
}
