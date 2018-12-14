package company;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLprofileCompany implements Initializable {
    @FXML
    private TextField nameField;
    @FXML
    private TextField websiteField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField biographyField;
    @FXML
    private  TextField addressField;

    @FXML
    private ImageView backButton;
    @FXML
    private ImageView   editButton;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        backButton.setPickOnBounds(true);
        backButton.setOnMouseClicked((MouseEvent event) -> {

            try {


                Stage.stage.changeStage("HomeCompany");


            } catch (Exception e) {
                e.printStackTrace();
            }


        });

        editButton.setPickOnBounds(true);
        editButton.setOnMouseClicked((MouseEvent event) -> {

            try {


                Stage.stage.changeStage("UpdateCompany");


            } catch (Exception e) {
                e.printStackTrace();
            }


        });
    }
}
