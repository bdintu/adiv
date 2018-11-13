package job;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLApproveJob implements Initializable {

    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField email;
    @FXML
    private TextField phone;
    @FXML
    private  TextField biography;
    @FXML
    private  TextField jobType;
    @FXML
    private  TextField name;
    @FXML
    private  TextField educationLevel;
    @FXML
    private  TextField jobLevel;
    @FXML
    private  TextField salary;
    @FXML
    private  TextField skill;
    @FXML
    private  TextField jobFunction;

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


                Stage.stage.changeStage("viewSeekerToApprove");


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
