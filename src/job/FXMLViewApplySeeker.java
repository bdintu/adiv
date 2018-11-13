package job;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLViewApplySeeker implements Initializable {
    @FXML
    private TableView table;
    @FXML
    private ImageView backButton;
    @FXML
    private ImageView delButton;
    @FXML
    private  ImageView viewButton;
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

        viewButton.setPickOnBounds(true);
        viewButton.setOnMouseClicked((MouseEvent event) -> {

            try {


                Stage.stage.changeStage("viewJobForRemove");


            } catch (Exception e) {
                e.printStackTrace();
            }


        });

        delButton.setPickOnBounds(true);
        delButton.setOnMouseClicked((MouseEvent event) -> {



        });
    }
}
