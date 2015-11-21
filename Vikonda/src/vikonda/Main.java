package vikonda;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * This is the main class of application.
 */
public class Main extends Application {
	Stage window;
/**
* This is the main method of application.
*/
	public static void main(String[] args) {
		launch(args);
	}
/**
* Override method, which call in the method launch.
*/
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		Parent root = FXMLLoader.load(getClass().getResource("log in.fxml"));
		primaryStage.getIcons().add(
                new Image(Main.class.getResourceAsStream("icon.png")));
        primaryStage.initStyle(StageStyle.DECORATED);
		Node node = root.lookup("#LogIn");
        node.setOpacity(0);
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2), node);
        fadeTransition.setToValue(1);
        fadeTransition.play();
        primaryStage.setTitle("vikonda");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
        primaryStage.setOnCloseRequest(e ->{
        	e.consume();
       	 closePrograme();
       });
	}
/**
* Method, which call when you click close button.
*/
	private void closePrograme(){
    	boolean answer = ConfirmBox.display("Title of Window", "Sure you want to exit?");
    	if(answer)
        window.close();
    }

}
