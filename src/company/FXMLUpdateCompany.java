package company;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLUpdateCompany implements Initializable {
    @FXML
    private TextField companyNameField;
    @FXML
    private TextField websiteField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private TextArea addressField;
    @FXML
    private TextArea biographyField;

    @FXML
    private ImageView backButton;
    @FXML
    private ImageView okButton;

    @FXML
    private Label label;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Model company = Controller.controller.getSession();

        companyNameField.setText(company.getName());
        websiteField.setText(company.getWebsite());
        phoneField.setText(company.getPhone());
        addressField.setText(company.getAddress());
        biographyField.setText(company.getBiography());
        emailField.setText(company.getUser().getEmail());

        backButton.setPickOnBounds(true);
        backButton.setOnMouseClicked((MouseEvent event) -> {

            try {
                Stage.stage.changeStage("HomeCompany");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        okButton.setPickOnBounds(true);
        okButton.setOnMouseClicked((MouseEvent event) -> {
            if (companyNameField.getText().trim().isEmpty() & phoneField.getText().trim().isEmpty() && addressField.getText().trim().isEmpty()) {
                label.setText("Please fill your detail");
            } else if (companyNameField.getText().trim().isEmpty()) {
                label.setText("Please fill your company name");
            } else if (phoneField.getText().trim().isEmpty()) {
                label.setText("Please fill your telephone number");
            } else if (addressField.getText().trim().isEmpty()) {
                label.setText("Please fill your Address");
            } else if (emailField.getText().trim().isEmpty()) {
                label.setText("Please fill your email");
            } else if (passwordField.getText().trim().isEmpty()) {
                label.setText("Please fill your password");
            } else if (confirmPasswordField.getText().trim().isEmpty()) {
                label.setText("Please fill your confirm password");
            } else if (passwordField.getText().equals(confirmPasswordField.getText()) == false) {
                label.setText("Error: password mai tong kun");
            } else {
                try {

                    company.setName(companyNameField.getText());
                    company.setWebsite(websiteField.getText());
                    company.setPhone(phoneField.getText());
                    company.setAddress(addressField.getText());
                    company.setBiography(biographyField.getText());
                    company.getUser().setEmail(emailField.getText());
                    company.getUser().setPassword(passwordField.getText());

                    Stage.stage.changeStage("homeCompany");
                    Stage.stage.setTitle("Home Company");

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }
}
