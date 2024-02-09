package si.session_activities.unit04;

import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NumberGuesserGame extends Application{

// - Generate some random number (int).
// - Create a TextField that enables you to enter a guess.
// - Create a "Guess" button & event handler that checks if the entered value is correct.
// - Create a guess display Label that displays the amount of available guesses you have.
// - If the amount of available guesses reaches zero, do not let the user enter submit a guess.


    @Override
    public void start(Stage primaryStage) throws Exception {
        Random rand = new Random();
        int randomInt = rand.nextInt(101); // 0 - 100
        int amountOfGuesses = 5;
        
        TextField input = new TextField();
        input.setAlignment(Pos.CENTER);
        input.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        input.setPromptText("Enter Your Guess: ");

        HBox displayHBox = new HBox();
        Button submitGuess = new Button("Submit your Guess");
        submitGuess.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        Label guessCount = new Label("   Available Guesses: " + String.valueOf(amountOfGuesses));
        guessCount.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        Label outcome = new Label("");
        displayHBox.getChildren().addAll(
            submitGuess,
            guessCount    
        );
            
        submitGuess.setOnAction(new NumberGuesserHandler(randomInt, input, amountOfGuesses, guessCount, outcome));

        Label answer = new Label("Answer (for testing purposes): " + String.valueOf(randomInt));

        VBox vBox = new VBox();
        vBox.getChildren().addAll(
            input,
            displayHBox,
            outcome,
            answer
        );

        Scene scene = new Scene(vBox);
        primaryStage.setTitle("Number Guesser");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
