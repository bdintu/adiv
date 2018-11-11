package company;

import java.util.ArrayList;

public class Controller {

    private static ArrayList<Model> models;
    private static Model session;

    public static void Controller() {
//        models = new ArrayList<Model>();

        Test.createCompany();
        Test.setSession();
        Test.getSession();
    }

    public static void createCompany(Model company_input) {
        models.add(company_input);
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
