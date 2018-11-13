package seeker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
    private MenuButton jobType;
    @FXML
    private MenuButton educationLevel;
    @FXML
    private MenuButton location;
    @FXML
    private MenuButton jobLevel;
    @FXML
    private MenuButton salary;
    @FXML
    private MenuButton skill;
    @FXML
    private MenuButton jobFunction;

    @FXML
    private TableView<job.Model> table;
    @FXML
    private TableColumn<job.Model, String> jobFunction1;
    @FXML
    private TableColumn<job.Model, String> company1;
    @FXML
    private TableColumn<job.Model, String> jobLevel1;
    @FXML
    private TableColumn<job.Model, String> salary1;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        jobFunction1.setCellValueFactory(new PropertyValueFactory<>("jobFunction"));
        company1.setCellValueFactory(new PropertyValueFactory<>("company"));
        jobLevel1.setCellValueFactory(new PropertyValueFactory<>("jobLevel"));
        salary1.setCellValueFactory(new PropertyValueFactory<>("salary_begin"));

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
                Stage.stage.changeStage("Login");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


    }

    private ObservableList<job.Model> getJobModelList() {


        ObservableList<job.Model> list = FXCollections.observableArrayList();
        for(job.Model i: job.Controller.getModels())
            list.add(i);

        return list;
    }

}
