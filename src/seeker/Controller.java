package seeker;

import java.util.ArrayList;

public class Controller {

    public static ArrayList<Model> models;

    public void Controller() {
    }

    public void createSeeker(Model seeker_input) {
        models.add(seeker_input);
    }
}
