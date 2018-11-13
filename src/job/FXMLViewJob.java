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

public class FXMLViewJob implements Initializable {
    @FXML
    private TextField jobFunction;
    @FXML
    private TextField salary;
    @FXML
    private TextField jobType;
    @FXML
    private  TextField skill;
    @FXML
    private  TextField educationLevel;
    @FXML
    private  TextField location;
    @FXML
    private TextField jobLevel;

    @FXML
    private  TextArea detail;

    @FXML
    private ImageView backButton;
    @FXML
    private ImageView okButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

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


                Stage.stage.changeStage("viewApplySeeker");


            } catch (Exception e) {
                e.printStackTrace();
            }


        });

    }
}
