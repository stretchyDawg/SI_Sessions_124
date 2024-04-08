package si.session_activities.unit10.cookie_clicker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CookieClicker {

    private static int clicks;

    public static void click(FileWriter writer) throws IOException{
        clicks++;
        writer.write("Click! +" + clicks + "\n");
    }
    
    
    public static void main(String[] args) throws IOException{
        FileWriter writer = new FileWriter("src/main/java/si/session_activities/unit10/cookie_clicker/clicks.txt");
        System.out.println("\nWelcome to Cookie Clicker!");
        Scanner scan = new Scanner(System.in);
        System.out.print("(Clicks: 0) >> ");
        String input = scan.nextLine();
        
        while(!input.equals("exit")){
            if(input.equals("click")){
                click(writer);
            }
            if(input.equals("cursor")){
                if(clicks >= 20){
                    System.out.println("Made cursor!");
                    clicks = clicks - 20;
                    Thread thread = new Thread(new Cursor(writer));
                    thread.start();
                }
                else{
                    System.out.println("Not enough for a cursor! <Need 20 clicks>");
                }
            }
            if(input.equals("grandma")){
                if(clicks >= 100){
                    System.out.println("Made grandma!");
                    clicks = clicks - 100;
                    Thread thread = new Thread(new Grandma(writer));
                    thread.start();
                }
                else{
                    System.out.println("Not enough for a grandma! <Need 100 clicks>");
                }
            }
            System.out.print("(Clicks: " + clicks + ") >> ");
            input = scan.nextLine();
        }

        writer.close();
        scan.close();
    }

}
