package seeker;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLProfileSeeker implements Initializable {
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
    private ImageView editButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Model user = Controller.controller.getSession();

        firstNameField.setText(user.getFirstName());
        lastNameField.setText(user.getLastName());
        phoneField.setText(user.getPhone());
        addressField.setText(user.getAddress());
        educationLevelField.setText(user.getEducationLevel());
        biographyField.setText(user.getBiography());

        backButton.setPickOnBounds(true);
        backButton.setOnMouseClicked((MouseEvent event) -> {

            try {


                Stage.stage.changeStage("HomeSeeker");


            } catch (Exception e) {
                e.printStackTrace();
            }


        });

        editButton.setPickOnBounds(true);
        editButton.setOnMouseClicked((MouseEvent event) -> {

            try {


                Stage.stage.changeStage("UpdateSeeker");


            } catch (Exception e) {
                e.printStackTrace();
            }


        });
    }
}
