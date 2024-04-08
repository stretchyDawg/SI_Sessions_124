package si.session_activities.unit10.cookie_clicker;

import java.io.FileWriter;
import java.io.IOException;

public class Grandma implements Runnable{
    private FileWriter writer;

    public Grandma(FileWriter writer) {
        this.writer = writer;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(100);
                CookieClicker.click(writer);
            } catch (IOException | InterruptedException e) {}
        }
    }
}
