package company;

import java.util.ArrayList;

public class Controller {

    public static Controller controller;

    private ArrayList<Model> models;
    private Model session;

    public static void Controller() {
        controller = new Controller();
        controller.models = new ArrayList<Model>();
    }

    public void add(Model company) {
        if (!isDuplicate(company)) {
            models.add(company);
        }

        System.out.println("Error: duplicate company");

    }

    public void login() {
        if (isCompany(user.Controller.controller.getSession())) {
            setSession(user.Controller.controller.getSession());
        }
    }

    public boolean isCompany(user.Model user) {
        for (Model company : models) {
            if (company.getUser().getEmail().equals(user.getEmail())) {
                return true;
            }
        }

        return false;
    }

    private Model getCompany(user.Model user) {
        for (Model company : models) {
            if (company.getUser().getEmail().equals(user.getEmail())) {
                return company;
            }
        }

        return null;
    }

    private boolean isDuplicate(Model company_input) {
        for (Model company : models) {
            if (company.equals(company_input)) {
                return true;
            }
        }

        return false;
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
        this.session = getCompany(user);
    }
}
