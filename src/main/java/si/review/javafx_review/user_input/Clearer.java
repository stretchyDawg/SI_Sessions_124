package unit04;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Clearer implements EventHandler<ActionEvent>{
    private final String defaultText;
    private final Label label;
    private final TextField textField;

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
