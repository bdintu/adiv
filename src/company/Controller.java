package company;

import java.util.ArrayList;

public class Controller {

    public static ArrayList<Model> models;

    public static void Controller() {
    }

    public void createSeeker(company.Model company_input) {
        Controller.models.add(company_input);
    }
}