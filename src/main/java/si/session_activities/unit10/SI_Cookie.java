package si.session_activities.unit10;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SI_Cookie {
    /* Inside the main method you will design a game that has a CLI, here are the commands:
       - "click" which will write to a text file "Click!" and the amount of clicks (example shown below)
    - "exit" which will stop the game (you don't have to write "<end game>" at the end)
    - Additionally, display the amount of clicks as the game progresses (example shown below) */

    public static int counter = 0;

    public static void click(FileWriter fw) throws IOException{
        fw.write("Click!" + counter + "\n");
        counter++;
    }

    public static void main(String[] args) throws IOException{
        FileWriter fw = new FileWriter("src/main/java/si/session_activities/unit10/poop.txt");
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while(!input.toLowerCase().equals("exit")){
            System.out.print("(Clicks: " + counter + ")>> ");
            input = scanner.nextLine();

            if (input.toLowerCase().equals("click"))click(fw);
            if (input.toLowerCase().equals("cursor") && counter > 20) 
            { 
                counter -= 20;
                SI_Cursor cursor = new SI_Cursor(fw);
                cursor.start();  
            }
            if(input.toLowerCase().equals("grandma") && counter >= 1){
                counter -= 0;
                Thread thread = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        try { 
                            while (true) 
                            { 
                               Thread.sleep(10); 
                                SI_Cookie.click(fw);  
    
                            }
                
                        } catch (Exception e) { } 
                        
                    }
                    
                });
                thread.start();
            }
            
        }
        scanner.close();
        fw.close();
    }

}
