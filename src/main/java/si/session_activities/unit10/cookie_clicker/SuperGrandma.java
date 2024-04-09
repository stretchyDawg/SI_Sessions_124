package si.session_activities.unit10.cookie_clicker;

import java.io.FileWriter;
import java.io.IOException;

public class SuperGrandma implements Runnable {
    private FileWriter writer;

    public SuperGrandma(FileWriter writer) {
        this.writer = writer;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1);
                CookieClicker.click(writer);
            } catch (IOException | InterruptedException e) {}
        }
    }
}
