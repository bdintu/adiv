package user;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLController implements Initializable {

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginButton;

    @FXML
    private Hyperlink createUserHyperlink;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Stage.stage.changeStage("Home-user");
                    email.setText("login");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        createUserHyperlink.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Stage.stage.changeStage("Register-user");
                    email.setText("createUser");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}