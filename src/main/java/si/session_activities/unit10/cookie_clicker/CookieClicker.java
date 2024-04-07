package si.session_activities.unit10.cookie_clicker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CookieClicker {
    




    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        
        FileWriter writer = new FileWriter("src/main/java/si/session_activities/unit10/cookie_clicker/clicks.txt");
        while(!input.equals("exit")){
            writer.write("Hello, this is a sample text written to a file.\n");
            System.out.println("<wrote to file>");
            input = scan.nextLine();
        }
        writer.write("<end game instance>\n\n");
        writer.close();

        scan.close();
    }
}
