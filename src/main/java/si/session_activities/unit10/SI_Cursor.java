package si.session_activities.unit10;

import java.io.FileWriter;

public class SI_Cursor extends Thread{
    /*
     * Part 2: Cursor.java
- Create a Cursor.java class that calls the click method every second
- In the main method in CookieClicker.java, create a new command:
    - "cursor" which creates an instance of the Cursor.java class. It will forever click every second.
     */ 
    private FileWriter fw; 

    public SI_Cursor(FileWriter fw) 
    { 
        this.fw = fw; 
    }

     @Override
     public void run() { 
        try { 
            while (true) 
            { 
               Thread.sleep(1000); 
                SI_Cookie.click(this.fw);  
            }

        } catch (Exception e) { } 
     }

}
