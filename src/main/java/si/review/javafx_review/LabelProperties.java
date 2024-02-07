package si.review.javafx_review;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LabelProperties extends Application{
    private static Label cornerRadiiExample(CornerRadii cornerRadii) {
        Label label = new Label("CornerRadii: " + (int)cornerRadii.getTopLeftHorizontalRadius());
        label.setFont(new Font("Arial", 24));
        label.setMaxWidth(Double.MAX_VALUE);
        label.setPadding(new Insets(40));
        label.setTextFill(Color.BLACK);
        label.setBackground(new Background(new BackgroundFill(Color.ORANGE, cornerRadii, new Insets(10))));           // <------ I AM CHANGING THIS VALUE 
        label.setAlignment(Pos.CENTER);
        
        return label;   
    }
    private static Label insetsLabelExample(Insets insets) {
        Label label = new Label("Insets - Label Padding: " + (int)insets.getTop());
        label.setFont(new Font("Arial", 24));
        label.setMaxWidth(Double.MAX_VALUE);
        label.setPadding(insets);                      // <------ I AM CHANGING THIS VALUE
        label.setTextFill(Color.BLACK);
        label.setBackground(new Background(new BackgroundFill(Color.ORANGE, new CornerRadii(25), new Insets(10))));    
        label.setAlignment(Pos.CENTER);
        
        return label;   
    }
    private static Label insetsTextExample(Insets insets) {
        Label label = new Label("Insets - Background Padding: " + (int)insets.getTop());
        label.setFont(new Font("Arial", 24));
        label.setMaxWidth(Double.MAX_VALUE);
        label.setPadding(new Insets(40));             
        label.setTextFill(Color.BLACK);
        label.setBackground(new Background(new BackgroundFill(Color.ORANGE, new CornerRadii(25), insets)));        // <------ I AM CHANGING THIS VALUE  
        label.setAlignment(Pos.CENTER);
        
        return label;   
    }
    private static Label labelBorderExample(String strokeStyle, Border border) {
        Label label = new Label("Style: " + strokeStyle);
        label.setFont(new Font("Arial", 24));
        label.setMaxWidth(Double.MAX_VALUE);
        label.setPadding(new Insets(40));             
        label.setTextFill(Color.BLACK);
        label.setBackground(new Background(new BackgroundFill(Color.ORANGE, new CornerRadii(25), new Insets(4))));        // <------ I AM CHANGING THIS VALUE  
        label.setAlignment(Pos.CENTER);
        label.setBorder(border);
        
        return label;   
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label cornerRadiiLabel1 = cornerRadiiExample(new CornerRadii(0));
        Label cornerRadiiLabel2 = cornerRadiiExample(new CornerRadii(10));
        Label cornerRadiiLabel3 = cornerRadiiExample(new CornerRadii(100));
        VBox cornerRadiiLabels = new VBox();
        cornerRadiiLabels.getChildren().addAll(cornerRadiiLabel1, cornerRadiiLabel2, cornerRadiiLabel3);

        Label insetsLabel1 = insetsLabelExample(new Insets(0));
        Label insetsLabel2 = insetsLabelExample(new Insets(10));
        Label insetsLabel3 = insetsLabelExample(new Insets(20));
        Label insetsLabel4 = insetsLabelExample(new Insets(30));
        Label insetsLabel5 = insetsLabelExample(new Insets(40));
        VBox insetsLabels = new VBox();
        insetsLabels.getChildren().addAll(insetsLabel1, insetsLabel2, insetsLabel3, insetsLabel4, insetsLabel5);

        Label insetsText1 = insetsTextExample(new Insets(0));
        Label insetsText2 = insetsTextExample(new Insets(10));
        Label insetsText3 = insetsTextExample(new Insets(20));
        Label insetsText4 = insetsTextExample(new Insets(30));
        Label insetsText5 = insetsTextExample(new Insets(40));
        VBox insetsTexts = new VBox();
        insetsTexts.getChildren().addAll(insetsText1, insetsText2, insetsText3, insetsText4, insetsText5);
        
        Label labelBorder1 = labelBorderExample("Dashed", new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.DASHED, new CornerRadii(25), new BorderWidths(10))));
        Label labelBorder2 = labelBorderExample("Dotted", new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.DOTTED, new CornerRadii(25), new BorderWidths(10))));
        Label labelBorder3 = labelBorderExample("Solid", new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(25), new BorderWidths(10))));
        Label labelBorder4 = labelBorderExample("None", new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.NONE, new CornerRadii(25), new BorderWidths(10))));
        VBox labelBorders = new VBox();
        labelBorders.getChildren().addAll(labelBorder1, labelBorder2, labelBorder3, labelBorder4);



        // Comment out VBox to whatever examples you want (i.e. CornerRadii examples, Insets examples, etc..)
        
        // Scene scene = new Scene(cornerRadiiLabels); 
        // Scene scene = new Scene(insetsLabels); 
        // Scene scene = new Scene(insetsTexts); 
        Scene scene  = new Scene(labelBorders);

        primaryStage.setTitle("Label Property Examples");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }   
}