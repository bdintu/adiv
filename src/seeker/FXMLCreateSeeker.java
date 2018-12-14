package seeker;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLCreateSeeker implements Initializable {
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField educationLevelField;

    @FXML
    private TextArea addressField;
    @FXML
    private TextArea biographyField;

    @FXML
    private ImageView backButton;
    @FXML
    private ImageView   nextButton;

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
            if (firstNameField.getText().trim().isEmpty()&&lastNameField.getText().trim().isEmpty()&&phoneField.getText().trim().isEmpty()&&addressField.getText().trim().isEmpty()&&educationLevelField.getText().trim().isEmpty() ) {
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
            } else {
                try {


                    Stage.stage.changeStage("homeSeeker");


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
