package seeker;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
    private ImageView viewApplySeekerButton;
    @FXML
    private ImageView SeekerViewApproveButton;
    
    @FXML
    private MenuButton jobTypeField;
    @FXML
    private MenuButton locationField;
    @FXML
    private MenuButton jobLevelField;
    @FXML
    private MenuButton salaryField;
//    @FXML
//    private MenuButton skillField;
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

        Controller.controller.clearSession();

        job.ControllerMenu.addJobTypeFieldTable(jobTypeField, table);
        job.ControllerMenu.addJobFunctionFieldTable(jobFunctionField, table);
        job.ControllerMenu.addJobLevelFieldTable(jobLevelField, table);
        job.ControllerMenu.addLocationFieldTable(locationField, table);
//        job.ControllerMenu.addSkillFieldTable(skillField, table);
        job.ControllerMenu.addSalaryFieldTable(salaryField, table);

        jobNameTable.setCellValueFactory(new PropertyValueFactory<>("name"));
        companyTable.setCellValueFactory(new PropertyValueFactory<>("company"));
        jobTypeTable.setCellValueFactory(new PropertyValueFactory<>("jobType"));
        jobFunctionTable.setCellValueFactory(new PropertyValueFactory<>("jobFunction"));
        jobLevelTable.setCellValueFactory(new PropertyValueFactory<>("jobLevel"));
        locationTable.setCellValueFactory(new PropertyValueFactory<>("location"));
        salaryTable.setCellValueFactory(new PropertyValueFactory<>("salary"));

        table.setItems(job.ControllerMenu.getJobModelList());

        logoutButton.setPickOnBounds(true);
        logoutButton.setOnMouseClicked((MouseEvent event) -> {

            Controller.controller.clearSession();
            user.Controller.controller.clearSession();

            try {
                Stage.stage.changeStage("Login");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        viewButton.setPickOnBounds(true);
        viewButton.setOnMouseClicked((MouseEvent event) -> {

            try {
                if (table.getSelectionModel().getSelectedIndex() != -1) {
                    Stage.stage.changeStage("viewJob");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        table.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<job.Model>() {

                    @Override
                    public void changed(
                            ObservableValue<? extends job.Model> observable,
                            job.Model oldValue, job.Model newValue) {

                        job.Controller.controller.setSelect(newValue);
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

        viewApplySeekerButton.setPickOnBounds(true);
        viewApplySeekerButton.setOnMouseClicked((MouseEvent event) -> {

            try {
                Stage.stage.changeStage("viewApplySeeker");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        SeekerViewApproveButton.setPickOnBounds(true);
        SeekerViewApproveButton.setOnMouseClicked((MouseEvent event) -> {

            try {
                Stage.stage.changeStage("SeekerViewApprove");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
