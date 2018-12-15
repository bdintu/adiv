package job;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLViewPostjob implements Initializable {
    @FXML
    private ImageView backButton;
    @FXML
    private ListView listView;
    @FXML
    private ImageView viewButton;
    @FXML
    private ImageView delButton;
    @FXML
    private ImageView postButton;

    @FXML
    private TableView<Model> table;
    @FXML
    private TableColumn<Model, String> jobNameTable;
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

        jobNameTable.setCellValueFactory(new PropertyValueFactory<>("name"));
        jobTypeTable.setCellValueFactory(new PropertyValueFactory<>("jobType"));
        jobFunctionTable.setCellValueFactory(new PropertyValueFactory<>("jobFunction"));
        jobLevelTable.setCellValueFactory(new PropertyValueFactory<>("jobLevel"));
        locationTable.setCellValueFactory(new PropertyValueFactory<>("location"));
        salaryTable.setCellValueFactory(new PropertyValueFactory<>("salary"));

        table.setItems(getJobModelList());

        backButton.setPickOnBounds(true);
        backButton.setOnMouseClicked((MouseEvent event) -> {

            try {
                Stage.stage.changeStage("homeCompany");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        viewButton.setPickOnBounds(true);
        viewButton.setOnMouseClicked((MouseEvent event) -> {

            try {
                Stage.stage.changeStage("CompanyviewJobForRemove");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        postButton.setPickOnBounds(true);
        postButton.setOnMouseClicked((MouseEvent event) -> {

            try {
                Stage.stage.changeStage("Postjob");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static ObservableList<Model> getJobModelList() {

        Controller.controller.filterJob();

        ObservableList<job.Model> list = FXCollections.observableArrayList();
        for (Model i : Controller.controller.getModels(company.Controller.controller.getSession())) {
            list.add(i);
        }

        return list;
    }
}
