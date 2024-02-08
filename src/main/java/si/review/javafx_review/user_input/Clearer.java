package si.review.javafx_review.user_input;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Clearer implements EventHandler<ActionEvent>{
    private final String defaultText;
    private final Label label;
    private final TextField textField;

    @SuppressWarnings("exports")
    public Clearer(String defaultText, Label label,TextField textField) {
        this.defaultText = defaultText;
        this.label = label;
        this.textField = textField;
    }
    @Override
    public void handle(ActionEvent event) {
        label.setText(defaultText); 
        textField.setText("");
    }
}
