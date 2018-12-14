package company;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import stage.Stage;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLCompanyViewjobforRemove implements Initializable {
    @FXML
    private TextField jobFunction;
    @FXML
    private  TextField salary;
    @FXML
    private  TextField jobType;
    @FXML
    private TextField skill;
    @FXML
    private  TextField educationLevel;
    @FXML
    private  TextField location;
    @FXML
    private TextField jobLevel;
    @FXML
    private TextArea detail;


    @FXML
    private ImageView backButton;
    @FXML
    private ImageView delButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        backButton.setPickOnBounds(true);
        backButton.setOnMouseClicked((MouseEvent event) -> {

            try {

                Stage.stage.changeStage("viewPostJob");

            } catch (Exception e) {
                e.printStackTrace();
            }


        });

        delButton.setPickOnBounds(true);
        delButton.setOnMouseClicked((MouseEvent event) -> {

            try {

                Stage.stage.changeStage("viewPostJob");

            } catch (Exception e) {
                e.printStackTrace();
            }


        });
    }
}
