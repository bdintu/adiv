package seeker;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLSeekerViewApprove implements Initializable {

    @FXML
    private TableView<job.Model> table;
    @FXML
    private TableColumn<Model, String> jobNameTable;
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

    @FXML
    private ImageView backButton;
    @FXML
    private ImageView viewButton;

    private static ObservableList<job.Model> list;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        jobNameTable.setCellValueFactory(new PropertyValueFactory<>("name"));
        companyTable.setCellValueFactory(new PropertyValueFactory<>("company"));
        jobTypeTable.setCellValueFactory(new PropertyValueFactory<>("jobType"));
        jobFunctionTable.setCellValueFactory(new PropertyValueFactory<>("jobFunction"));
        jobLevelTable.setCellValueFactory(new PropertyValueFactory<>("jobLevel"));
        locationTable.setCellValueFactory(new PropertyValueFactory<>("location"));
        salaryTable.setCellValueFactory(new PropertyValueFactory<>("salary"));

        table.setItems(getJobModelList());

        table.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<job.Model>() {

                    @Override
                    public void changed(
                            ObservableValue<? extends job.Model> observable,
                            job.Model oldValue, job.Model newValue) {

                        job.Controller.controller.setSelectJob(newValue);
                    }
                });

        backButton.setPickOnBounds(true);
        backButton.setOnMouseClicked((MouseEvent event) -> {

            try {
                Stage.stage.changeStage("HomeSeeker");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        viewButton.setPickOnBounds(true);
        viewButton.setOnMouseClicked((MouseEvent event) -> {
            if (table.getSelectionModel().getSelectedIndex() != -1) {
                try {
                    Stage.stage.changeStage("SeekerViewApproveDetail");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private ObservableList<job.Model> getJobModelList() {

        list = FXCollections.observableArrayList();
        seeker.Model seekerr = seeker.Controller.controller.getSession();
        for (job.Model i : job.Controller.controller.getApprove(seekerr)) {
            list.add(i);
        }
        return list;
    }
}