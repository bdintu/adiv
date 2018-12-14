package job;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLViewPostjob implements Initializable {
    @FXML
    private ImageView backButton;
    @FXML
    private ListView listView;
    @FXML
    private  ImageView viewButton;
    @FXML
    private  ImageView delButton;
    @FXML
    private  ImageView postButton;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        backButton.setPickOnBounds(true);
        backButton.setOnMouseClicked((MouseEvent event) -> {

            try {


                Stage.stage.changeStage("homeCompany");


            } catch (Exception e) {
                e.printStackTrace();
            }


        });

        viewButton.setPickOnBounds(true);
        viewButton.setOnMouseClicked((MouseEvent event) -> {

            try {


                Stage.stage.changeStage("ViewJob");


            } catch (Exception e) {
                e.printStackTrace();
            }


        });

        postButton.setPickOnBounds(true);
        postButton.setOnMouseClicked((MouseEvent event) -> {

            try {


                Stage.stage.changeStage("postJob");


            } catch (Exception e) {
                e.printStackTrace();
            }


        });
    }
}
