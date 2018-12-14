package seeker;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLUpdateSeeker implements Initializable {
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField educationLevelField;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private TextArea addressField;
    @FXML
    private TextArea biographyField;

    @FXML
    private ImageView backButton;
    @FXML
    private ImageView okButton;

    @FXML
    private Label label;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Model user = Controller.controller.getSession();

        firstNameField.setText(user.getFirstName());
        lastNameField.setText(user.getLastName());
        phoneField.setText(user.getPhone());
        addressField.setText(user.getAddress());
        educationLevelField.setText(user.getEducationLevel());
        biographyField.setText(user.getBiography());
        emailField.setText(user.getUser().getEmail());

        backButton.setPickOnBounds(true);
        backButton.setOnMouseClicked((MouseEvent event) -> {

            try {

                Stage.stage.changeStage("HomeSeeker");

            } catch (Exception e) {
                e.printStackTrace();
            }


        });

        okButton.setPickOnBounds(true);
        okButton.setOnMouseClicked((MouseEvent event) -> {
            if (firstNameField.getText().trim().isEmpty() && lastNameField.getText().trim().isEmpty() && phoneField.getText().trim().isEmpty() && addressField.getText().trim().isEmpty() && educationLevelField.getText().trim().isEmpty()) {
                label.setText("Please fill your detail");
            } else if (firstNameField.getText().trim().isEmpty()) {
                label.setText("Please fill your name");
            } else if (lastNameField.getText().trim().isEmpty()) {
                label.setText("Please fill your name");
            } else if (phoneField.getText().trim().isEmpty()) {
                label.setText("Please fill your telephone number");
            } else if (addressField.getText().trim().isEmpty()) {
                label.setText("Please fill your Address");
            } else if (educationLevelField.getText().trim().isEmpty()) {
                label.setText("Please fill your Education level");
            } else if (emailField.getText().trim().isEmpty()) {
                label.setText("Please fill your email");
            } else if (passwordField.getText().trim().isEmpty()) {
                label.setText("Please fill your password");
            } else if (confirmPasswordField.getText().trim().isEmpty()) {
                label.setText("Please fill your confirm password");
            } else if (passwordField.getText().equals(confirmPasswordField.getText()) == false) {
                label.setText("Error: password mai tong kun");
            } else {
                try {

                    user.setFirstName(firstNameField.getText());
                    user.setLastName(lastNameField.getText());
                    user.setPhone(phoneField.getText());
                    user.setAddress(addressField.getText());
                    user.setEducationLevel(educationLevelField.getText());
                    user.setBiography(biographyField.getText());
                    user.getUser().setEmail(emailField.getText());
                    user.getUser().setPassword(passwordField.getText());

                    Stage.stage.changeStage("homeSeeker");
                    Stage.stage.setTitle("Home Seeker");

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }
}
