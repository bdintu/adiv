package job;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLViewJobForRemove implements Initializable {
    @FXML
    private TextField jobNameField;
    @FXML
    private TextField jobTypeField;
    @FXML
    private TextField locationField;
    @FXML
    private TextField jobLevelField;
    @FXML
    private TextField salaryField;
    @FXML
    private TextField skillField;
    @FXML
    private TextArea detailField;

    @FXML
    private ImageView backButton;
    @FXML
    private ImageView delButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Model sel = Controller.controller.getSelect();

        jobNameField.setText(sel.getName());
        jobTypeField.setText(sel.getJobType().getName());
        jobLevelField.setText(sel.getJobLevel().getName());
        locationField.setText(sel.getLocation().getName());
        salaryField.setText(sel.getSalary().getName());
        skillField.setText(sel.getSkill().toString());
        detailField.setText((sel.getDetail()));

        backButton.setPickOnBounds(true);
        backButton.setOnMouseClicked((MouseEvent event) -> {

            try {

                Controller.controller.delApplyJobThis();
                try {
                    Stage.stage.changeStage("homeSeeker");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        delButton.setPickOnBounds(true);
        delButton.setOnMouseClicked((MouseEvent event) -> {

            try {

                Stage.stage.changeStage("viewApplySeeker");

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
