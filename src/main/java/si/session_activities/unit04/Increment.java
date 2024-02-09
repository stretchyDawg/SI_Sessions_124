package si.session_activities.unit04;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class Increment implements EventHandler<ActionEvent>{
    private Label label;

    @SuppressWarnings("exports")
    public Increment(Label label) {
        this.label = label;
    }

    @Override
    public void handle(ActionEvent event) {
        int number = Integer.parseInt(this.label.getText());
        this.label.setText(String.valueOf(number + 1));
    }   
}
