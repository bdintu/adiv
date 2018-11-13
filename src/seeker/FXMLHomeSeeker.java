package seeker;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLHomeSeeker implements Initializable {
    @FXML
    private ImageView logoutButton;
    @FXML
    private ImageView viewButton;

    @FXML
    private MenuButton jobType;
    @FXML
    private MenuButton educationLevel;
    @FXML
    private MenuButton location;
    @FXML
    private MenuButton jobLevel;
    @FXML
    private MenuButton salary;
    @FXML
    private MenuButton skill;
    @FXML
    private MenuButton jobFunction;


    @Override
    public void initialize(URL location, ResourceBundle resources) {



        logoutButton.setPickOnBounds(true);
        logoutButton.setOnMouseClicked((MouseEvent event) -> {

            try {
                Stage.stage.changeStage("Login");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        viewButton.setPickOnBounds(true);
        viewButton.setOnMouseClicked((MouseEvent event) -> {

            try {
                Stage.stage.changeStage("Login");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


    }

}
