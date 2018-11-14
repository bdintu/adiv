package job;

import java.util.ArrayList;

public class Controller {

    public static Controller controller;

    private ArrayList<Model> models;

    public static void Controller() {
        controller = new Controller();
        controller.models = new ArrayList<Model>();
    }

    public void add(Model job) {
        models.add(job);
    }

    public void postJob() {

    }

    public void approveJob() {

    }

    public void applyJob() {

    }

    public ArrayList<Model> getModels() {
        return models;
    }

    public void setModels(ArrayList<Model> models) {
        this.models = models;
    }
}
