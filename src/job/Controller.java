package job;

import java.util.ArrayList;

public class Controller {

    private static ArrayList<Model> models;

    public static void Controller() {
//        models = new ArrayList<Model>();

//        Test.createJob();
        Test.printModel();
    }

    public static void add(Model job) {
        models.add(job);
    }

    public static void postJob() {

    }

    public static void approveJob() {

    }

    public static void applyJob() {

    }

    public static ArrayList<Model> getModels() {
        return models;
    }

    public static void setModels(ArrayList<Model> models) {
        Controller.models = models;
    }
}
