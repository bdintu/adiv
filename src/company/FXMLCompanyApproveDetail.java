package company;

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

public class FXMLCompanyApproveDetail implements Initializable {
    @FXML
    private TextField jobNameField;
    @FXML
    private TextField companyNameField;
    @FXML
    private TextArea detailApproveField;

    @FXML
    private ImageView backButton;
    @FXML
    private ImageView okButton;

    @FXML
    private Label label;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        job.Model sel = job.Controller.controller.getSelect();
        jobNameField.setText(sel.getName());
        companyNameField.setText(sel.getCompany().getName());

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

            if (detailApproveField.getText().trim().isEmpty()) {
                label.setText("pless key detail");
            } else {
                job.Controller.controller.approveJobThis(detailApproveField.getText());
                try {
                    Stage.stage.changeStage("viewSeekerToApprove");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}