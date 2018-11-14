package user;

import java.util.ArrayList;

public class Controller {

    public static Controller controller;

    private ArrayList<Model> models;
    private Model session;

    public static void Controller() {
        controller = new Controller();
        controller.models = new ArrayList<Model>();
    }

    public void addModel(Model user) {

        if (hasModel(user)) {
            System.out.println("Error: duplicate email");
        } else {
            models.add(user);
        }
    }

    private Model getModel(Model user_input) {
        for (Model user : models) {
            if (user.equals(user_input)) {
                return user;
            }
        }

        return null;
    }

    private boolean hasModel(Model user_input) {
        for (Model user : models) {
            if (user.equals(user_input)) {
                return true;
            }
        }

        return false;
    }

    public void login(Model user_input) {

        if (hasModel(user_input) && checkPassword(user_input)) {
            session = getModel(user_input);
        }
    }

    private boolean checkPassword(Model user_input) {
        Model user = getModel(user_input);
        return user.getPassword().equals(user_input.getPassword());
    }

    public boolean isLogin() {
        return session != null;
    }

    public ArrayList<Model> getModels() {
        return models;
    }

    public void setModels(ArrayList<Model> models) {
        this.models = models;
    }

    public Model getSession() {
        return session;
    }

    public void setSession(Model session) {
        this.session = session;
    }
}
