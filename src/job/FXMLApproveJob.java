package job;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLApproveJob implements Initializable {

    @FXML
    private TextField jobNameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField educationLevelField;
    @FXML
    private TextArea biographyField;

    @FXML
    private MenuButton userField;

    @FXML
    private Button viewButton;

    @FXML
    private ImageView backButton;
    @FXML
    private ImageView okButton;
    @FXML
    private ImageView delButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        job.ControllerMenu.addUserApprove(userField);

        Model sel = Controller.controller.getSelect();
        jobNameField.setText(sel.getName());

        viewButton.setOnMouseClicked((MouseEvent event) -> {

            String[] parts = userField.getText().split(" ");
            seeker.Model selMenu = seeker.Controller.controller.getSeeker(parts[0], parts[1]);

            if (selMenu != null) {
                Controller.controller.setSelectSeeker(selMenu);

                seeker.Model selSeeker = Controller.controller.getSelectSeeker();
                emailField.setText(selSeeker.getUser().getEmail());
                phoneField.setText(selSeeker.getPhone());
                educationLevelField.setText((selSeeker.getEducationLevel()));
                biographyField.setText(selSeeker.getBiography());
            }
        });

        backButton.setPickOnBounds(true);
        backButton.setOnMouseClicked((MouseEvent event) -> {

            try {
                Stage.stage.changeStage("viewSeekerToApprove");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        okButton.setPickOnBounds(true);
        okButton.setOnMouseClicked((MouseEvent event) -> {
            if (!userField.getText().equals("select name seeker")) {
                try {
                    Stage.stage.changeStage("CompanyApproveDetail");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        delButton.setPickOnBounds(true);
        delButton.setOnMouseClicked((MouseEvent event) -> {
            Controller.controller.delApplyJobThis();
            try {
                Stage.stage.changeStage("viewSeekerToApprove");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
