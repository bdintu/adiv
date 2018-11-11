package seeker;

import java.util.ArrayList;

public class Controller {

    private static ArrayList<Model> models;
    private static Model session;

    public static void Controller() {
//        models = new ArrayList<Model>();

        Test.createSeeker();
        Test.setSession();
        Test.getSession();
    }

    public static void createSeeker(Model seeker) {
        if (!duplicateSeeker(seeker)) {
            models.add(seeker);
        }

        System.out.println("Error: duplicate seeker profile");

    }

    public static boolean isSeeker(user.Model user) {
        for (Model seeker : models) {
            if (seeker.getUser().getEmail().equals(user.getEmail())) {
                return true;
            }
        }

        return false;
    }

    private static Model getSeeker(user.Model user) {
        for (Model seeker : models) {
            if (seeker.getUser().getEmail().equals(user.getEmail())) {
                return seeker;
            }
        }

        return null;
    }

    private static boolean duplicateSeeker(Model seeker_input) {
        for (Model seeker : models) {
            if (seeker.equals(seeker_input)) {
                return true;
            }
        }

        return false;
    }

    public static ArrayList<Model> getModels() {
        return models;
    }

    public static void setModels(ArrayList<Model> models) {
        Controller.models = models;
    }

    public static Model getSession() {
        return session;
    }

    public static void setSession(user.Model user) {
        Controller.session = getSeeker(user);
    }
}
