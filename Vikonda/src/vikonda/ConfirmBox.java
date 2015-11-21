package vikonda;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

/**
* This class is a Object of little window which calls after click Exit Button.
*/
public class ConfirmBox {

    //Create variable
    static boolean answer;

    public static boolean display(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label();
        label.setStyle("-fx-text-fill: #BCC6CC;-fx-font-weight: bold;-fx-font-size: 12;-fx-font-family:Segoe UI Semibold;");
        label.setText(message);


        //Create two buttons
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");
        yesButton.setMinSize(60, 15);
        noButton.setMinSize(60, 15);
        yesButton.setStyle("-fx-text-fill: #BCC6CC; -fx-background-color:#303030;");
        noButton.setStyle("-fx-text-fill: #BCC6CC; -fx-background-color:#303030;");
        //Clicking will set answer and close window
        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });
        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });
        VBox Vlayout = new VBox(10);
        HBox layout = new HBox(10);

        //Add buttons
        layout.getChildren().addAll(yesButton, noButton);
        layout.setAlignment(Pos.CENTER);
        Vlayout.getChildren().addAll(label, layout);
        Vlayout.setStyle("-fx-background-color: #404040;");
        Vlayout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(Vlayout);
        window.setScene(scene);
        window.showAndWait();

        //Make sure to return answer
        return answer;
    }

}