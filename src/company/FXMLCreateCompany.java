package company;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLCreateCompany implements Initializable {
    @FXML
    private TextField name;
    @FXML
    private  TextField phone;
    @FXML
    private TextField website;
    @FXML
    private TextArea address;
    @FXML
    private  TextArea biography;
    @FXML
    private ImageView backButton;
    @FXML
    private  ImageView okButton;



    @Override
    public void initialize(URL url, ResourceBundle resources) {

        backButton.setPickOnBounds(true);
        backButton.setOnMouseClicked((MouseEvent event) -> {

            try {


                Stage.stage.changeStage("Login");


            } catch (Exception e) {
                e.printStackTrace();
            }


        });

        okButton.setPickOnBounds(true);
        okButton.setOnMouseClicked((MouseEvent event) -> {

            try {

                industry.Model ind = industry.Controller.controller.getModels().get(0);
                location.Model loc = location.Controller.controller.getModels().get(0);
                Model seeker = new Model(user.Controller.controller.getSession(), ind, loc, name.getText(), phone.getText(),website.getText(), biography.getText());
                Controller.controller.addModel(seeker);
                Controller.controller.syncSession();

                Stage.stage.changeStage("homeCompany");


            } catch (Exception e) {
                e.printStackTrace();
            }


        });
    }
}
