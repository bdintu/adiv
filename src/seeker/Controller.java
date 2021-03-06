package seeker;

import java.util.ArrayList;

public class Controller {

    public static Controller controller;

    private static ArrayList<Model> models;
    private static Model session;

    public static void Controller() {
        controller = new Controller();
        controller.models = new ArrayList<Model>();
    }

    public void addSeeker(Model seeker) {

        if (hasSeeker(seeker)) {
            System.out.println("Error: duplicate seeker");
        } else {
            models.add(seeker);
        }
    }

    public Model getSeeker(Model seeker_input) {
        for (Model seeker : models) {
            if (seeker.equals(seeker_input)) {
                return seeker;
            }
        }

        return null;
    }

    public Model getSeeker(String firstName, String lastName) {
        for (Model seeker : models) {
            if (seeker.getFirstName().equals(firstName) && seeker.getLastName().equals(lastName)) {
                return seeker;
            }
        }

        return null;
    }

    private boolean hasSeeker(Model seeker_input) {
        for (Model seeker : models) {
            if (seeker.equals(seeker_input)) {
                return true;
            }
        }

        return false;
    }

    private Model getSeeker(user.Model user) {
        for (Model seeker : models) {
            if (seeker.getUser().getEmail().equals(user.getEmail())) {
                return seeker;
            }
        }

        return null;
    }

    public boolean isSeeker(user.Model user) {
        for (Model seeker : models) {
            if (seeker.getUser().getEmail().equals(user.getEmail())) {
                return true;
            }
        }

        return false;
    }

    public void syncSession() {
        if (isSeeker(user.Controller.controller.getSession())) {
            setSession(user.Controller.controller.getSession());
        }
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

    public void setSession(user.Model user) {
        this.session = getSeeker(user);
    }
}
