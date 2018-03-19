package restaurantapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    TextField username;
    
    @FXML
    PasswordField password;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if(username.getText().equals("testuser") && password.getText().equals("123")) {
            System.out.println("Log-in Successful!");
            
            Parent tableLayoutView = FXMLLoader.load(getClass().getResource("TableLayout.fxml"));
            Scene tableLayoutScene = new Scene(tableLayoutView);
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableLayoutScene);
            window.show();
        } else {
            System.out.println("no");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
