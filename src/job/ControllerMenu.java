package job;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;

public class ControllerMenu {

    private static ObservableList<job.Model> list;

    public static ObservableList<Model> getJobModelList() {

        Controller.controller.filterJob();

        list = FXCollections.observableArrayList();
        for (Model i : Controller.controller.getFilter()) {
            list.add(i);
        }

        return list;
    }
    
    public static void addJobTypeField(MenuButton jobTypeField, TableView<Model> table) {
        for (jobtype.Model i : jobtype.Controller.controller.getModels()) {
            MenuItem item = new MenuItem(i.getName());
            item.setOnAction(a -> {
                jobTypeField.setText(i.getName());
                Controller.controller.setJobTypeFilter(i);
                table.setItems(getJobModelList());
            });
            jobTypeField.getItems().add(item);
        }
    }

    public static void addJobFunctionField(MenuButton jobFunctionField, TableView<Model> table) {
        for (jobfunction.Model i : jobfunction.Controller.controller.getModels()) {
            MenuItem item = new MenuItem(i.getName());
            item.setOnAction(a -> {
                Controller.controller.setJobFunctionFilter(i);
                jobFunctionField.setText(i.getName());
                table.setItems(getJobModelList());
            });
            jobFunctionField.getItems().add(item);
        }
    }

    public static void addJobLevelField(MenuButton jobLevelField, TableView<Model> table) {
        for (joblevel.Model i : joblevel.Controller.controller.getModels()) {
            MenuItem item = new MenuItem(i.getName());
            item.setOnAction(a -> {
                jobLevelField.setText(i.getName());
                Controller.controller.setJobLevelFilter(i);
                table.setItems(getJobModelList());
            });
            jobLevelField.getItems().add(item);
        }
    }

    public static void addLocationField(MenuButton locationField, TableView<Model> table) {
        for (location.Model i : location.Controller.controller.getModels()) {
            MenuItem item = new MenuItem(i.getName());
            item.setOnAction(a -> {
                locationField.setText(i.getName());
                Controller.controller.setLocationFilter(i);
                table.setItems(getJobModelList());
            });
            locationField.getItems().add(item);
        }
    }

    public static void addSkillField(MenuButton skillField, TableView<Model> table) {
        for (skill.Model i : skill.Controller.controller.getModels()) {
            MenuItem item = new MenuItem(i.getName());
            item.setOnAction(a -> {
                skillField.setText(i.getName());
                Controller.controller.setSkilFilterl(i);
                table.setItems(getJobModelList());
            });
            skillField.getItems().add(item);
        }
    }

    public static void addSalaryField(MenuButton salaryField, TableView<Model> table) {
        for (salary.Model i : salary.Controller.controller.getModels()) {
            MenuItem item = new MenuItem(i.getName());
            item.setOnAction(a -> {
                salaryField.setText(i.getName());
                Controller.controller.setSalaryFilter(i);
                table.setItems(getJobModelList());
            });
            salaryField.getItems().add(item);
        }
    }
}
