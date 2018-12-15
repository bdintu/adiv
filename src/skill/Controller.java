package skill;

import java.util.ArrayList;

public class Controller {

    public static Controller controller;

    public ArrayList<Model> models;

    public static void Controller() {
        controller = new Controller();
        controller.models = new ArrayList<Model>();
    }

    public void add(Model industry) {
        models.add(industry);
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