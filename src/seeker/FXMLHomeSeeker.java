package seeker;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import job.Model;
import stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLHomeSeeker implements Initializable {
    @FXML
    private ImageView logoutButton;
    @FXML
    private ImageView viewButton;
    @FXML
    private ImageView editButton;


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

    private ObservableList<job.Model> list;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        addJobTypeField();
        addJobFunctionField();
        addJobLevelField();
        addLocationField();
        addSkillField();
        addSalaryField();

        jobNameTable.setCellValueFactory(new PropertyValueFactory<>("name"));
        companyTable.setCellValueFactory(new PropertyValueFactory<>("company"));
        jobTypeTable.setCellValueFactory(new PropertyValueFactory<>("jobType"));
        jobFunctionTable.setCellValueFactory(new PropertyValueFactory<>("jobFunction"));
        jobLevelTable.setCellValueFactory(new PropertyValueFactory<>("jobLevel"));
        locationTable.setCellValueFactory(new PropertyValueFactory<>("location"));
        salaryTable.setCellValueFactory(new PropertyValueFactory<>("salary"));

        list = getJobModelList();
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

        table.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<Model>() {

                    @Override
                    public void changed(
                            ObservableValue<? extends Model> observable,
                            Model oldValue, Model newValue ) {

                        Controller.controller.setSelect(newValue);
                    }
                });
        editButton.setPickOnBounds(true);
        editButton.setOnMouseClicked((MouseEvent event) -> {

            try {
                Stage.stage.changeStage("profileSeeker");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void addJobTypeField() {
        for(jobtype.Model i: jobtype.Controller.controller.getModels()) {
            MenuItem item = new MenuItem(i.getName());
            item.setOnAction(a->{
                Controller.controller.setJobTypeFilter(i);
                jobTypeField.setText(i.getName());
                list = getJobModelList();
                table.setItems(list);
            });
            jobTypeField.getItems().add(item);
        }
    }

    private void addJobFunctionField() {
        for(jobfunction.Model i: jobfunction.Controller.controller.getModels()) {
            MenuItem item = new MenuItem(i.getName());
            item.setOnAction(a->{
                Controller.controller.setJobFunctionFilter(i);
                jobFunctionField.setText(i.getName());
                list = getJobModelList();
                table.setItems(list);
            });
            jobFunctionField.getItems().add(item);
        }
    }

    private void addJobLevelField() {
        for(joblevel.Model i: joblevel.Controller.controller.getModels()) {
            MenuItem item = new MenuItem(i.getName());
            item.setOnAction(a->{
                Controller.controller.setJobLevelFilter(i);
                jobLevelField.setText(i.getName());
                list = getJobModelList();
                table.setItems(list);
            });
            jobLevelField.getItems().add(item);
        }
    }

    private void addLocationField() {
        for(location.Model i: location.Controller.controller.getModels()) {
            MenuItem item = new MenuItem(i.getName());
            item.setOnAction(a->{
                Controller.controller.setLocationFilter(i);
                locationField.setText(i.getName());
                list = getJobModelList();
                table.setItems(list);
            });
            locationField.getItems().add(item);
        }
    }

    private void addSkillField() {
        for(skill.Model i: skill.Controller.controller.getModels()) {
            MenuItem item = new MenuItem(i.getName());
            item.setOnAction(a->{
                Controller.controller.setSkilFilterl(i);
                skillField.setText(i.getName());
                list = getJobModelList();
                table.setItems(list);
            });
            skillField.getItems().add(item);
        }
    }

    private void addSalaryField() {
        for(salary.Model i: salary.Controller.controller.getModels()) {
            MenuItem item = new MenuItem(i.getName());
            item.setOnAction(a->{
                Controller.controller.setSalaryFilter(i);
                salaryField.setText(i.getName());
                list = getJobModelList();
                table.setItems(list);
            });
            salaryField.getItems().add(item);
        }
    }

    private ObservableList<job.Model> getJobModelList() {

        Controller.controller.filterJob();

        list = FXCollections.observableArrayList();
        for(job.Model i: Controller.controller.getFilter()) {
            list.add(i);
        }

        return list;
    }

}
