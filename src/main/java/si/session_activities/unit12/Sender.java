package si.session_activities.unit12;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Sender {
    
    public static void main(String[] args) {
        // Connect to the server on localhost, port 54321

        // (Even longer line of code)
        try (Socket socket = new Socket("christians-baby", 54321);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connected to the server. Type 'exit' to quit.");

            String message;
            while (true) {
                System.out.print(">> ");
                message = scanner.nextLine();
                if (message.equals("exit")) {
                    break;
                }

                writer.write(message);
                writer.newLine(); // Important: BufferedWriter MUST be flushed or use newLine to actually send data
                writer.flush();
            }

            System.out.println("\n<client sender closed>");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
