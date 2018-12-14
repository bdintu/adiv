package job;

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

public class FXMLViewApplySeeker implements Initializable {
    @FXML
    private ImageView backButton;
    @FXML
    private ImageView delButton;
    @FXML
    private  ImageView viewButton;

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

    private ObservableList<job.Model> list;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        System.out.println("adasdasdasd");

        System.out.println(Controller.controller.getApplyJobThis().size());

        jobNameTable.setCellValueFactory(new PropertyValueFactory<>("name"));
        companyTable.setCellValueFactory(new PropertyValueFactory<>("company"));
        jobTypeTable.setCellValueFactory(new PropertyValueFactory<>("jobType"));
        jobFunctionTable.setCellValueFactory(new PropertyValueFactory<>("jobFunction"));
        jobLevelTable.setCellValueFactory(new PropertyValueFactory<>("jobLevel"));
        locationTable.setCellValueFactory(new PropertyValueFactory<>("location"));
        salaryTable.setCellValueFactory(new PropertyValueFactory<>("salary"));

        table.setItems(getJobModelList());

        backButton.setPickOnBounds(true);
        backButton.setOnMouseClicked((MouseEvent event) -> {

            try {


                Stage.stage.changeStage("homeSeeker");


            } catch (Exception e) {
                e.printStackTrace();
            }


        });

        viewButton.setPickOnBounds(true);
        viewButton.setOnMouseClicked((MouseEvent event) -> {

            try {
                if (table.getSelectionModel().getSelectedIndex() != -1) {
                    Stage.stage.changeStage("viewJobForRemove");
                }
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

        delButton.setPickOnBounds(true);
        delButton.setOnMouseClicked((MouseEvent event) -> {



        });
    }

    private ObservableList<Model> getJobModelList() {

        list = FXCollections.observableArrayList();
        for(Model i: Controller.controller.getApplyJobThis()) {
            list.add(i);
        }
        return list;
    }
}
