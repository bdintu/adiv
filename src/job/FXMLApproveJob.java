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

public class FXMLApproveJob implements Initializable {

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextArea biographyField;
    @FXML
    private TextArea detailField;
    @FXML
    private TextField jobNameField;
    @FXML
    private TextField jobLevelField;
    @FXML
    private TextField salaryField;
    @FXML
    private TextField skillField;
    @FXML
    private TextField jobFunctionField;

    @FXML
    private ImageView backButton;
    @FXML
    private  ImageView okButton;
    @FXML
    private  ImageView delButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

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

            try {


                Stage.stage.changeStage("CompanyApproveDetail");


            } catch (Exception e) {
                e.printStackTrace();
            }


        });

        delButton.setPickOnBounds(true);
        delButton.setOnMouseClicked((MouseEvent event) -> {

            try {


                Stage.stage.changeStage("viewSeekerToApprove");


            } catch (Exception e) {
                e.printStackTrace();
            }


        });

    }
}
