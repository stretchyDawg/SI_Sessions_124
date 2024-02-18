package si.session_activities.unit04.username.username.username.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Cleaner implements EventHandler<ActionEvent> {
    private UsernameGUI gui;

    public Cleaner(UsernameGUI gui){
        this.gui = gui;
    }

    @Override
    public void handle(ActionEvent event) {
       gui.textfield.setText("");
       gui.usernameDisplay.setText("");
    }
    
}
