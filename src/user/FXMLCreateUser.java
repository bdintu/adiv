package user;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;


public class FXMLCreateUser implements Initializable {

    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    private CheckBox seeker;
    @FXML
    private CheckBox company;
    @FXML
    private ImageView backButton;
    @FXML
    private ImageView nextButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        backButton.setPickOnBounds(true);
        backButton.setOnMouseClicked((MouseEvent event) -> {

            try {


                Stage.stage.changeStage("Login");


                //Stage.stage.changeStage("homeSeeker");

            } catch (Exception e) {
                e.printStackTrace();
            }


        });

        nextButton.setPickOnBounds(true);
        nextButton.setOnMouseClicked((MouseEvent event) -> {

            try {

                // check null field

                if (password.getText().equals(confirmPassword.getText()) == false) {
                    System.out.println("Error: password mai tong kun");
                } else if (seeker.isSelected() && company.isSelected()) {
                    System.out.println("Error: not select");
                } else if (!seeker.isSelected() && !company.isSelected()) {
                    System.out.println("Error: pess select one type");
                } else if (seeker.isSelected()) {

                    System.out.println(email.getText() + password.getText());

                    Model user = new Model(email.getText(), password.getText());
                    Controller.controller.addModel(user);
                    Controller.controller.login(user);

                    Stage.stage.changeStage("CreateSeeker");
                } else if (company.isSelected()) {

                    Model user = new Model(email.getText(), password.getText());
                    Controller.controller.addModel(user);
                    Controller.controller.login(user);

                    Stage.stage.changeStage("CreateCompany");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

}