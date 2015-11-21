package vikonda;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class is the controller of log in.fxml.
 */
public class LoginController implements Initializable {
	@FXML
	TextField userField;
    @FXML
    PasswordField passwordBox;
    @FXML
    Label labelInfo;
    Stage stage;
    Parent root;
    /**
    * Method initialize calls when log in.fxml load.
    * It is very important to load before second WindowScene, for fast loading.
    */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    	try{
    		root = FXMLLoader.load(getClass().getResource("table.fxml"));
    	}catch(IOException e){
    		labelInfo.setText("couldn't load table.fxml");
    	}
        
    }
    /**
     * Method validate calls when LoginButton was clicked.
     */
    public void validate(ActionEvent event) throws IOException {
    	String username = userField.getText();
    	String userPassword = passwordBox.getText();
    	if(username.equals("user") && userPassword.equals("user")){
    		labelInfo.setText("valid");
    		loadTableScene();
    	} else {
    		labelInfo.setText("Username/Password is incorrect");
    	}
    	
    }
    /**
     * Method loadTableScene calls if login and password is correct,
     * and do more beautiful change scene.
     */
    public void loadTableScene(){
    	stage=(Stage) userField.getScene().getWindow();
    	Node node = root.lookup("#table");
        node.setOpacity(0);
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(2), node);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    	Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
