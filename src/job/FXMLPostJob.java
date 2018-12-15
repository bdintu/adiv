package job;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLPostJob implements Initializable {
    @FXML
    private TextField jobNameField;
    @FXML
    private MenuButton jobTypeField;
    @FXML
    private MenuButton salaryField;
    @FXML
    private MenuButton skillField;
    @FXML
    private MenuButton locationField;
    @FXML
    private MenuButton jobFunctionField;
    @FXML
    private MenuButton jobLevelField;
    @FXML
    private TextArea detailField;

    @FXML
    private Label label;
    @FXML
    private ImageView okButton;
    @FXML
    private ImageView backButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        job.ControllerMenu.addJobTypeField(jobTypeField);
        job.ControllerMenu.addJobFunctionField(jobFunctionField);
        job.ControllerMenu.addJobLevelField(jobLevelField);
        job.ControllerMenu.addLocationField(locationField);
        job.ControllerMenu.addSkillField(skillField);
        job.ControllerMenu.addSalaryField(salaryField);

        okButton.setPickOnBounds(true);
        okButton.setOnMouseClicked((MouseEvent event) -> {

            if (jobNameField.getText().trim().isEmpty() && jobTypeField.getText().equals("Employment type") && salaryField.getText().equals("Salary") && locationField.getText().equals("Location") && jobFunctionField.getText().equals("Job Function") && jobLevelField.getText().equals("Career level")) {
                label.setText("Please fill something to make post job perfect");
            } else {

                try {
                    Stage.stage.changeStage("viewPostJob");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        backButton.setPickOnBounds(true);
        backButton.setOnMouseClicked((MouseEvent event) -> {

            try {
                Stage.stage.changeStage("viewPostJob");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
