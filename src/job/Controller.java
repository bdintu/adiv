package job;

import java.util.ArrayList;

public class Controller {

    private static ArrayList<Model> models;

    public static void Controller() {
//        models = new ArrayList<Model>();

        Test.createJob();
    }

    public static void createJob(Model job) {
        models.add(job);
    }

    public void postJob() {

    }

    public void approveJob() {

    }

    public void applyJob() {

    }

    public static ArrayList<Model> getModels() {
        return models;
    }

    public static void setModels(ArrayList<Model> models) {
        Controller.models = models;
    }
}
