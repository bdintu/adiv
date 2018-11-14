package company;

import java.util.ArrayList;

public class Controller {

    private static ArrayList<Model> models;
    private static Model session;

    public static void Controller() {
        models = new ArrayList<Model>();

        Test.createCompany();
        Test.login();
        Test.printModel();
    }

    public static void add(Model company) {
        if (!isDuplicate(company)) {
            models.add(company);
        }

        System.out.println("Error: duplicate company");

    }

    public static void login() {
        if (isCompany(user.Controller.controller.getSession())) {
            setSession(user.Controller.controller.getSession());
        }
    }

    public static boolean isCompany(user.Model user) {
        for (Model company : models) {
            if (company.getUser().getEmail().equals(user.getEmail())) {
                return true;
            }
        }

        return false;
    }

    private static Model getCompany(user.Model user) {
        for (Model company : models) {
            if (company.getUser().getEmail().equals(user.getEmail())) {
                return company;
            }
        }

        return null;
    }

    private static boolean isDuplicate(Model company_input) {
        for (Model company : models) {
            if (company.equals(company_input)) {
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
        Controller.session = getCompany(user);
    }
}
