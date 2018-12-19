package job;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FXMLPostJob implements Initializable {
    @FXML
    private TextField jobNameField;
    @FXML
    private MenuButton jobTypeField;
    @FXML
    private MenuButton salaryField;
    @FXML
    private MenuButton skillField;
    @FXML
    private MenuButton locationField;
    @FXML
    private MenuButton jobFunctionField;
    @FXML
    private MenuButton jobLevelField;
    @FXML
    private TextArea detailField;

    @FXML
    private Label label;
    @FXML
    private ImageView okButton;
    @FXML
    private ImageView backButton;

    @Override
    public void initialize(URL locationtion, ResourceBundle resources) {

        job.ControllerMenu.addJobTypeField(jobTypeField);
        job.ControllerMenu.addJobFunctionField(jobFunctionField);
        job.ControllerMenu.addJobLevelField(jobLevelField);
        job.ControllerMenu.addLocationField(locationField);
        job.ControllerMenu.addSkillField(skillField);
        job.ControllerMenu.addSalaryField(salaryField);

        okButton.setPickOnBounds(true);
        okButton.setOnMouseClicked((MouseEvent event) -> {



            System.out.println(jobTypeField.getText().equals("Employment type"));
            System.out.println(salaryField.getText().equals("Salary"));
            System.out.println(locationField.getText().equals("Location"));
            System.out.println(jobFunctionField.getText().equals("Job Function"));
            System.out.println(jobLevelField.getText().equals("Career level"));


            if (!jobNameField.getText().trim().isEmpty() && !jobTypeField.getText().equals("Employment type") && !salaryField.getText().equals("Salary") && !locationField.getText().equals("Location") && !jobFunctionField.getText().equals("Job Function") && !jobLevelField.getText().equals("Career level")) {


                jobfunction.Model jf = jobfunction.Controller.controller.getModel(jobFunctionField.getText());
                joblevel.Model jl = joblevel.Controller.controller.getModel(jobLevelField.getText());
                jobtype.Model jt = jobtype.Controller.controller.getModel(jobTypeField.getText());
                location.Model loc = location.Controller.controller.getModel(locationField.getText());
                salary.Model sa = salary.Controller.controller.getModel(salaryField.getText());

                skill.Model ski = skill.Controller.controller.getModel(skillField.getText());
                ArrayList<skill.Model> skil = new ArrayList<skill.Model>();
                skil.add(ski);

                Model jo = new job.Model(jobNameField.getText(), detailField.getText(), company.Controller.controller.getSession(), jf, jl, jt, loc, sa, skil);
                Controller.controller.addModel(jo);

                try {
                    Stage.stage.changeStage("viewPostJob");
                } catch (Exception e) {
                    e.printStackTrace();
                }



            } else {

                label.setText("Please fill something to make post job perfect");

            }
        });

        backButton.setPickOnBounds(true);
        backButton.setOnMouseClicked((MouseEvent event) -> {

            try {
                Stage.stage.changeStage("viewPostJob");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
