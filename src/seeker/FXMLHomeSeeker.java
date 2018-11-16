package seeker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import job.Controller;
import stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLHomeSeeker implements Initializable {
    @FXML
    private ImageView logoutButton;
    @FXML
    private ImageView viewButton;

    @FXML
    private MenuButton jobTypeField;
    @FXML
    private MenuButton locationField;
    @FXML
    private MenuButton jobLevelField;
    @FXML
    private MenuButton salaryField;
    @FXML
    private MenuButton skillField;
    @FXML
    private MenuButton jobFunctionField;

    @FXML
    private TableView<job.Model> table;
    @FXML
    private TableColumn<job.Model, String> jobNameTable;
    @FXML
    private TableColumn<job.Model, String> companyTable;
    @FXML
    private TableColumn<job.Model, String> jobTypeTable;
    @FXML
    private TableColumn<job.Model, String> jobFunctionTable;
    @FXML
    private TableColumn<job.Model, String> jobLevelTable;
    @FXML
    private TableColumn<job.Model, String> locationTable;
    @FXML
    private TableColumn<job.Model, String> salaryTable;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        addJobTypeField();
        addJobFunctionField();
        addJobLevelField();
        addLocationField();
        addSkillField();

        jobNameTable.setCellValueFactory(new PropertyValueFactory<>("name"));
        companyTable.setCellValueFactory(new PropertyValueFactory<>("company"));
        jobTypeTable.setCellValueFactory(new PropertyValueFactory<>("jobType"));
        jobFunctionTable.setCellValueFactory(new PropertyValueFactory<>("jobFunction"));
        jobLevelTable.setCellValueFactory(new PropertyValueFactory<>("jobLevel"));
        locationTable.setCellValueFactory(new PropertyValueFactory<>("location"));

        ObservableList<job.Model> list = getJobModelList();
        table.setItems(list);
        
        logoutButton.setPickOnBounds(true);
        logoutButton.setOnMouseClicked((MouseEvent event) -> {

            try {
                Stage.stage.changeStage("Login");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        viewButton.setPickOnBounds(true);
        viewButton.setOnMouseClicked((MouseEvent event) -> {

            try {
                Stage.stage.changeStage("viewJob");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


    }

    private void addJobTypeField() {
        for(jobtype.Model i: jobtype.Controller.controller.getModels()) {
            MenuItem mi = new MenuItem(i.getName());
            jobTypeField.getItems().add(mi);
        }
    }

    private void addJobFunctionField() {
        for(jobfunction.Model i: jobfunction.Controller.controller.getModels()) {
            MenuItem mi = new MenuItem(i.getName());
            jobFunctionField.getItems().add(mi);
        }
    }

    private void addJobLevelField() {
        for(joblevel.Model i: joblevel.Controller.controller.getModels()) {
            MenuItem mi = new MenuItem(i.getName());
            jobLevelField.getItems().add(mi);
        }
    }

    private void addLocationField() {
        for(location.Model i: location.Controller.controller.getModels()) {
            MenuItem mi = new MenuItem(i.getName());
            locationField.getItems().add(mi);
        }
    }

    private void addSkillField() {
        for(skill.Model i: skill.Controller.controller.getModels()) {
            MenuItem mi = new MenuItem(i.getName());
            skillField.getItems().add(mi);
        }
    }

    private ObservableList<job.Model> getJobModelList() {


        ObservableList<job.Model> list = FXCollections.observableArrayList();
        for(job.Model i: Controller.controller.getModels()) {
            list.add(i);
            System.out.println(i);
        }

        return list;
    }

}
