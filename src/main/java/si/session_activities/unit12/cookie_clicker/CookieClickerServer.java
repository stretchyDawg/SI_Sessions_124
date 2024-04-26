package si.session_activities.unit12.cookie_clicker;

import java.net.ServerSocket;

public class CookieClickerServer {
    private ServerSocket serverSocket;

    public CookieClickerServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }
}
