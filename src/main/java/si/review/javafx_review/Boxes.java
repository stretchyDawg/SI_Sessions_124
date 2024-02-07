package si.review.javafx_review;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Boxes extends Application{ 
    @Override
    public void start(Stage primaryStage) throws Exception {
        Label label1 = new Label("Fart");
        label1.setFont(new Font("Comic Sans", 48));
        label1.setTextFill(Color.PURPLE);
        label1.setPadding(new Insets(40));
        label1.setBackground(new Background(new BackgroundFill(Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY)));
        label1.setAlignment(Pos.CENTER);

        Label label2 = new Label("Poop");
        label2.setFont(new Font("Courier New", 48));
        label2.setTextFill(Color.YELLOW);
        label2.setPadding(new Insets(20, 30, 20, 30));
        label2.setBackground(new Background(new BackgroundFill(Color.BROWN, CornerRadii.EMPTY, Insets.EMPTY)));
        label2.setAlignment(Pos.CENTER);

        HBox hBox1 = new HBox();
        hBox1.getChildren().add(label1);
        hBox1.getChildren().add(label2);

        Label label3 = new Label("Fart");
        label3.setFont(new Font("Arial", 60));
        label3.setTextFill(Color.RED);
        label3.setPadding(new Insets(100, 20, 100, 20));
        label3.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        label3.setAlignment(Pos.CENTER);

        Label label4 = new Label("Poop");
        label4.setFont(new Font("Comic Sans", 48));
        label4.setTextFill(Color.GREEN);
        label4.setPadding(new Insets(10, 20, 30, 40));
        label4.setBackground(new Background(new BackgroundFill(Color.GOLDENROD, CornerRadii.EMPTY, new Insets(10))));
        label4.setAlignment(Pos.CENTER);

        HBox hBox2 = new HBox();
        hBox2.getChildren().addAll(label3, label4);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(hBox1, hBox2);

        Scene scene = new Scene(vBox);
        primaryStage.setTitle("Boxes Activity");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
