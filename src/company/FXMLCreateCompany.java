package company;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLCreateCompany implements Initializable {
    @FXML
    private TextField companyNameField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField websiteField;
    @FXML
    private TextArea addressField;
    @FXML
    private TextArea biographyField;
    @FXML
    private ImageView okButton;
    @FXML
    private Label label;


    @Override
    public void initialize(URL url, ResourceBundle resources) {

        okButton.setPickOnBounds(true);
        okButton.setOnMouseClicked((MouseEvent event) -> {
            if (companyNameField.getText().trim().isEmpty() && phoneField.getText().trim().isEmpty() && addressField.getText().trim().isEmpty()) {
                label.setText("Please fill your detail");
            } else if (companyNameField.getText().trim().isEmpty()) {
                label.setText("Please fill your name");
            } else if (phoneField.getText().trim().isEmpty()) {
                label.setText("Please fill your telephone number");
            } else if (addressField.getText().trim().isEmpty()) {
                label.setText("Please fill your Address");
            } else {

                try {

                    industry.Model ind = industry.Controller.controller.getModels().get(0);
                    Model seeker = new Model(user.Controller.controller.getSession(), ind, companyNameField.getText(), phoneField.getText(), addressField.getText(), websiteField.getText(), biographyField.getText());
                    Controller.controller.addModel(seeker);
                    Controller.controller.syncSession();

                    Stage.stage.changeStage("homeCompany");
                    Stage.stage.setTitle("Home Company");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
