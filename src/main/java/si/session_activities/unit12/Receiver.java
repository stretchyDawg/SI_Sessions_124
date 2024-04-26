package si.session_activities.unit12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Receiver {
    private static int portNum = 54321;

    public static void main(String[] args) throws IOException {
        
        ServerSocket serverSocket = new ServerSocket(portNum); 
        System.out.println("\nServer is listening on port " + Integer.toString(portNum) +": ");
            
            // Longest line of code ever lol
        Socket clientSocket = serverSocket.accept(); 
        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.print(clientSocket.getInetAddress().getHostName() +": ");
            System.out.println(line);
        }
        serverSocket.close();
            
        


        // try (ServerSocket serverSocket = new ServerSocket(portNum)) {
        //     System.out.println("\nServer is listening on port " + Integer.toString(portNum) +": ");
            
        //     // Longest line of code ever lol
        //     try(Socket clientSocket = serverSocket.accept(); 
        //         BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
        //         String line;
        //         while ((line = reader.readLine()) != null) {
        //             System.out.print(clientSocket.getInetAddress().getHostName() +": ");
        //             System.out.println(line);
        //         }
        //     }
        // }

    }
}



