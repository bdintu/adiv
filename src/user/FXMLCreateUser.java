package user;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;


public class FXMLCreateUser implements Initializable {

    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    private CheckBox seeker;
    @FXML
    private CheckBox company;
    @FXML
    private ImageView backButton;
    @FXML
    private ImageView nextButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nextButton.setPickOnBounds(true);
        nextButton.setOnMouseClicked((MouseEvent event) -> {

            try {

                if (1==1) {
                    Stage.stage.changeStage("homeCompany");

                } else {
                    Stage.stage.changeStage("homeSeeker");

                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        });
    }

}