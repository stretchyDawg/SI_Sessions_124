package si.session_activities.mock_practicums.test02.set2.three;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class Minus implements EventHandler<ActionEvent>{

    private Label displayLabel;

    public Minus(@SuppressWarnings("exports") Label displayLabel){
        this.displayLabel = displayLabel;
    }

    @Override
    public void handle(ActionEvent event) {
        String textNum = displayLabel.getText();
        int intNum = Integer.parseInt(textNum);
        intNum--;
        String newTextNum = Integer.toString(intNum);
        displayLabel.setText(newTextNum);
    }
}
