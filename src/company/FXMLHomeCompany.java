package company;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLHomeCompany implements Initializable {

    @FXML
    private ImageView postJobButton;
    @FXML
    private ImageView approveButton;
    @FXML
    private ImageView logoutButton;
    @FXML
    private ImageView profileButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        postJobButton.setPickOnBounds(true);
        postJobButton.setOnMouseClicked((MouseEvent event) -> {

            try {
                Stage.stage.changeStage("viewPostJob");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        logoutButton.setPickOnBounds(true);
        logoutButton.setOnMouseClicked((MouseEvent event) -> {

            Controller.controller.clearSession();
            user.Controller.controller.clearSession();

            try {
                Stage.stage.changeStage("Login");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        approveButton.setPickOnBounds(true);
        approveButton.setOnMouseClicked((MouseEvent event) -> {

            try {
                Stage.stage.changeStage("viewSeekerToApprove");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        profileButton.setPickOnBounds(true);
        profileButton.setOnMouseClicked((MouseEvent event) -> {

            try {
                Stage.stage.changeStage("profileCompany");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
