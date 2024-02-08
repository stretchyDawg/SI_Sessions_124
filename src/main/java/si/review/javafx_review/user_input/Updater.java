package si.review.javafx_review.user_input;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Updater implements EventHandler<ActionEvent>{
    private final Label label;
    private final TextField textField;

    @SuppressWarnings("exports")
    public Updater(Label label,TextField textField) {
        this.label = label;
        this.textField = textField;
    }
    @Override
    public void handle(ActionEvent event) {
        label.setText(textField.getText()); 
    }

    
}
