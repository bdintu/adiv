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

public class FXMLSeekerViewApproveDetail implements Initializable {

    @FXML
    private TextField jobNameField;
    @FXML
    private TextField companyNameField;
    @FXML
    private TextArea detailApproveField;
    @FXML
    private ImageView backButton;
    @FXML
    private Label label;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        job.Model sel = job.Controller.controller.getSelect();

        jobNameField.setText(sel.getName());
        companyNameField.setText(sel.getCompany().getName());
        detailApproveField.setText(sel.getDetail());

        backButton.setPickOnBounds(true);
        backButton.setOnMouseClicked((MouseEvent event) -> {

            try {
                Stage.stage.changeStage("SeekerViewApprove");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
