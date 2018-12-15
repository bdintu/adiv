package job;

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

public class FXMLViewJob implements Initializable {
    @FXML
    private TextField jobNameField;
    @FXML
    private TextField jobTypeField;
    @FXML
    private TextField locationField;
    @FXML
    private  TextField jobLevelField;
    @FXML
    private  TextField salaryField;
    @FXML
    private  TextField skillField;
    @FXML
    private TextArea detailField;
    @FXML
    private Label label;
    @FXML
    private ImageView backButton;
    @FXML
    private ImageView okButton;


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
                Stage.stage.changeStage("homeSeeker");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        okButton.setPickOnBounds(true);
        okButton.setOnMouseClicked((MouseEvent event) -> {

            try {
                if (Controller.controller.applyJobThis()) {
                    Stage.stage.changeStage("viewApplySeeker");
                } else {
                    label.setText("You already apply this job!");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
