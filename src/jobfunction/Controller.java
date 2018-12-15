package jobfunction;

import java.util.ArrayList;

public class Controller {

    public static Controller controller;

    private ArrayList<Model> models;

    public static void Controller() {
        controller = new Controller();
        controller.models = new ArrayList<Model>();
    }

    public void add(Model jobFunction) {
        models.add(jobFunction);
    }

    public Model getModel(String text) {
        for(Model model: models) {
            if (model.getName().equals(text)) {
                return model;
            }
        }
        return null;
    }

    public ArrayList<Model> getModels() {
        return models;
    }

    public void setModels(ArrayList<Model> models) {
        this.models = models;
    }
}
