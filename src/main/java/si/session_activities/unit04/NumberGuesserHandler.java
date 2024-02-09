package si.session_activities.unit04;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class NumberGuesserHandler implements EventHandler<ActionEvent>{

    private int randomInt;
    private TextField inputLabel;
    private int amountOfGuesses;
    private Label guessLabel;
    private Label outcomeLabel;

    @SuppressWarnings("exports")
    public NumberGuesserHandler(int randomInt, TextField inputLabel, int amountOfGuesses, Label guessLabel, Label outcomeLabel){
        this.randomInt = randomInt;
        this.inputLabel = inputLabel;
        this.amountOfGuesses = amountOfGuesses;
        this.guessLabel = guessLabel;
        this.outcomeLabel = outcomeLabel;
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            if(this.amountOfGuesses == 0){
                this.outcomeLabel.setText("Stop trying... YOU LOST!");
                this.outcomeLabel.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(25), new Insets(4)))); 
                return;
            }
            else{    
                if(Integer.parseInt(this.inputLabel.getText()) == this.randomInt){
                    this.outcomeLabel.setText("YOU WIN! You guessed correctly :)");
                    this.outcomeLabel.setBackground(new Background(new BackgroundFill(Color.YELLOW, new CornerRadii(25), new Insets(4))));   
                    return;   
                }
                else if(Integer.parseInt(this.inputLabel.getText()) != this.randomInt){
                    this.amountOfGuesses = this.amountOfGuesses-1;
                    this.guessLabel.setText("   Available Guesses: " + String.valueOf(amountOfGuesses));
                    if(this.amountOfGuesses == 0){
                        this.outcomeLabel.setText("YOU LOST! You ran out of guesses :(");
                        this.outcomeLabel.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(25), new Insets(4)))); 
                        return;
                    }
                    this.outcomeLabel.setText("Nope! Try again.");
                    return;
                }
            }
        }
        catch (NumberFormatException e){
            this.outcomeLabel.setText("Please input a number");
            return;   
        }
    }
}
