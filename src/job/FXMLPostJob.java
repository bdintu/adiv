package job;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLPostJob implements Initializable {
    @FXML
    private TextField name;
    @FXML
    private MenuButton jobType;
    @FXML
    private MenuButton salary;
    @FXML
    private  MenuButton educationLevel;
    @FXML
    private  MenuButton skill;
    @FXML
    private  MenuButton location;
    @FXML
    private  MenuButton jobFunction;
    @FXML
    private  MenuButton jobLevel;
    @FXML
    private  TextField detail;
    @FXML
    private ImageView okButton;
    @FXML
    private  ImageView backButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        okButton.setPickOnBounds(true);
        okButton.setOnMouseClicked((MouseEvent event) -> {

            try {


                Stage.stage.changeStage("viewPostJob");


            } catch (Exception e) {
                e.printStackTrace();
            }


        });



        backButton.setPickOnBounds(true);
        backButton.setOnMouseClicked((MouseEvent event) -> {

            try {


                Stage.stage.changeStage("homeCompany");


            } catch (Exception e) {
                e.printStackTrace();
            }


        });
    }
}
