package si.session_activities.unit04.username.username.username.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import si.session_activities.unit04.username.username.username.model.Username;

public class Generator implements EventHandler<ActionEvent> {
    private UsernameGUI gui;
    private Username model;
    public Generator(UsernameGUI gui, @SuppressWarnings("exports") Username model){
        this.gui = gui;
        this.model = model;  
    }

    @Override
    public void handle(ActionEvent event) {
        gui.update(model);
    }
}
