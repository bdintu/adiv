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

public class FXMLViewApproveSeeker implements Initializable {
    @FXML
    private ImageView backButton;
    @FXML
    private ImageView viewButton;

    @FXML
    private TableView<Model> table;
    @FXML
    private TableColumn<Model, String> jobNameTable;
    @FXML
    private TableColumn<Model, String> jobFunctionTable;
    @FXML
    private TableColumn<Model, String> jobTypeTable;
    @FXML
    private TableColumn<Model, String> jobLevelTable;
    @FXML
    private TableColumn<Model, String> salaryTable;

    private ObservableList<Model> list;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        jobNameTable.setCellValueFactory(new PropertyValueFactory<>("name"));
        jobFunctionTable.setCellValueFactory(new PropertyValueFactory<>("jobFunction"));
        jobTypeTable.setCellValueFactory(new PropertyValueFactory<>("jobType"));
        jobLevelTable.setCellValueFactory(new PropertyValueFactory<>("jobLevel"));
        salaryTable.setCellValueFactory(new PropertyValueFactory<>("salary"));

        table.setItems(getJobModelList());

        table.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<Model>() {

                    @Override
                    public void changed(
                            ObservableValue<? extends Model> observable,
                            Model oldValue, Model newValue) {

                        Controller.controller.setSelectJob(newValue);
                    }
                });

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
            if (table.getSelectionModel().getSelectedIndex() != -1) {
                try {
                    Stage.stage.changeStage("ApproveJob");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private ObservableList<Model> getJobModelList() {

        list = FXCollections.observableArrayList();
        company.Model companyy = company.Controller.controller.getSession();
        for (Model i : Controller.controller.getApplyJob(companyy)) {
            list.add(i);
        }
        return list;
    }
}
