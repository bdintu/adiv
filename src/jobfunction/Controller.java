package jobfunction;

import java.util.ArrayList;

public class Controller {

    private static ArrayList<Model> models;

    public static void Controller() {
//        models = new ArrayList<Model>();

    }

    public static void add(Model jobFunction) {
        models.add(jobFunction);
    }

    public static ArrayList<Model> getModels() {
        return models;
    }

    public static void setModels(ArrayList<Model> models) {
        Controller.models = models;
    }
}
