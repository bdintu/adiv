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


public class FXMLCreateUser implements Initializable {

    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private CheckBox chooseSeeker;
    @FXML
    private CheckBox chooseCompany;
    @FXML
    private ImageView backButton;
    @FXML
    private ImageView nextButton;
    @FXML
    private Label label;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        backButton.setPickOnBounds(true);
        backButton.setOnMouseClicked((MouseEvent event) -> {

            try {
                Stage.stage.changeStage("Login");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        nextButton.setPickOnBounds(true);
        nextButton.setOnMouseClicked((MouseEvent event) -> {

            try {

                if (emailField.getText().trim().isEmpty()) {
                    label.setText("Error: email is empty");
                } else if (passwordField.getText().trim().isEmpty()) {
                    label.setText("Error: password is empty");
                } else if (confirmPasswordField.getText().trim().isEmpty()) {
                    label.setText("Error: confrime password is empty");
                } else if (passwordField.getText().equals(confirmPasswordField.getText()) == false) {
                    label.setText("Error: password mai tong kun");
                } else if (chooseSeeker.isSelected() && chooseCompany.isSelected()) {
                    label.setText("Error: not select");
                } else if (!chooseSeeker.isSelected() && !chooseCompany.isSelected()) {
                    label.setText("Error: pess select one type");
                } else {

                    Model user = new Model(emailField.getText(), passwordField.getText());
                    Controller.controller.addModel(user);
                    Controller.controller.login(user);

                    if (chooseSeeker.isSelected()) {
                        Stage.stage.changeStage("CreateSeeker");
                        Stage.stage.setTitle("New Seeker Profile");
                    } else if (chooseCompany.isSelected()) {
                        Stage.stage.changeStage("CreateCompany");
                        Stage.stage.setTitle("New Company Profile");
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

}