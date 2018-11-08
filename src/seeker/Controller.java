package seeker;

import java.util.ArrayList;

public class Controller {

    public static ArrayList<Model> models;

    public static void Controller() {
    }

    public void createSeeker(seeker.Model seeker_input) {
        Controller.models.add(seeker_input);
    }
}
