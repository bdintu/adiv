package job;

import java.util.ArrayList;

public class Controller {

    public static Controller controller;

    private ArrayList<Model> models;

    public static void Controller() {
        controller = new Controller();
        controller.models = new ArrayList<Model>();
    }

    public void addModel(Model job) {
        if (hasModel(job) == false) {
            models.add(job);
        }
    }

    private boolean hasModel(Model job_input) {
        for (Model job : models) {
            if (job.equals(job_input)) {
                return true;
            }
        }

        return false;
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
