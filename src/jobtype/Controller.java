package jobtype;

import java.util.ArrayList;

public class Controller {

    private static ArrayList<Model> models;

    public static void Controller() {
//        models = new ArrayList<Model>();

    }

    public static void createJobType(Model jobType) {
        models.add(jobType);
    }

    public static ArrayList<Model> getModels() {
        return models;
    }

    public static void setModels(ArrayList<Model> models) {
        Controller.models = models;
    }
}