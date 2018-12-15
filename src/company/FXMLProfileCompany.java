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

public class FXMLProfileCompany implements Initializable {
    @FXML
    private TextField companyNameField;
    @FXML
    private TextField websiteField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextArea biographyField;
    @FXML
    private TextArea addressField;
    @FXML
    private ImageView backButton;
    @FXML
    private ImageView editButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Model company = Controller.controller.getSession();

        companyNameField.setText(company.getName());
        websiteField.setText(company.getWebsite());
        phoneField.setText(company.getPhone());
        addressField.setText(company.getAddress());
        biographyField.setText(company.getBiography());

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
