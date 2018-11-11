package skill;

import java.util.ArrayList;

public class Controller {

    public static ArrayList<Model> models;

    public static void Controller() {
//        models = new ArrayList<Model>();

    }

    public static void add(Model industry) {
        models.add(industry);
    }

    public static ArrayList<Model> getModels() {
        return models;
    }

    public static void setModels(ArrayList<Model> models) {
        Controller.models = models;
    }
}