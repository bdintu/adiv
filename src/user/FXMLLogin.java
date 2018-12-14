package user;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLLogin implements Initializable {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ImageView loginButton;

    @FXML
    private Hyperlink createUserButton;

    @FXML
    private Label label;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        loginButton.setPickOnBounds(true);
        loginButton.setOnMouseClicked((MouseEvent event) -> {

            if (emailField.getText().trim().isEmpty()) {
                label.setText("email is empty");
            } else if (passwordField.getText().trim().isEmpty()) {
                label.setText("password is empty");
            } else {

                try {
                    Model user = new Model(emailField.getText(), passwordField.getText());
                    Controller.controller.login(user);

                    if (Controller.controller.isLogin()) {

                        if (company.Controller.controller.isCompany(Controller.controller.getSession())) {

                            company.Controller.controller.syncSession();

                            Stage.stage.changeStage("homeCompany");
                            Stage.stage.setTitle("Home Company");
                        } else if (seeker.Controller.controller.isSeeker(Controller.controller.getSession())) {

                            seeker.Controller.controller.syncSession();

                            Stage.stage.changeStage("homeSeeker");
                            Stage.stage.setTitle("Home Seeker");
                        }

                    } else {
                        label.setText("Error: email or password incorrect");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
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