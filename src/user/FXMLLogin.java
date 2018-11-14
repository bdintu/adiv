package user;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLLogin implements Initializable {

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private ImageView loginButton;

    @FXML
    private Hyperlink createUserButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        loginButton.setPickOnBounds(true);
        loginButton.setOnMouseClicked((MouseEvent event) -> {

            try {
                Model user = new Model(email.getText(), password.getText());
                Controller.controller.login(user);

                if (Controller.controller.isLogin()) {
                    Stage.stage.changeStage("homeSeeker");
                } else {
                    int i=0;
                    // show label error
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        createUserButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Stage.stage.changeStage("CreateUser");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}