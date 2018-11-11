package user;

import java.util.ArrayList;

public class Controller {

    private static ArrayList<Model> models;
    private static Model session;

    public static void Controller() {
//        models = new ArrayList<Model>();

        Test.createUser();
        Test.login();
    }

    public static void createUser(Model user) {
        if (!duplicateUser(user)) {
            models.add(user);
        }

        System.out.println("Error: duplicate email");
    }

    public static boolean login(Model user_input) {
        Model user = getUser(user_input);
        if (user == null) {
            System.out.println("Error: user not in system");
            return false;
        }

        boolean is_login = checkPassword(user, user_input);
        if (is_login == false) {
            System.out.println("Error: password is wrong");
        }

        session = user;
        return true;
    }

    private static Model getUser(Model user_input) {
        for (Model user : models) {
            if (user.getEmail().equals(user_input.getEmail())) {
                return user;
            }
        }

        return null;
    }

    private static boolean duplicateUser(Model user_input) {
        for (Model user : models) {
            if (user.equals(user_input)) {
                return true;
            }
        }

        return false;
    }

    private static boolean checkPassword(Model user, Model user_input) {
        return user.getPassword().equals(user_input.getPassword());
    }

    public static boolean isLogin() {
        return session != null;
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

    public static void setSession(Model session) {
        Controller.session = session;
    }
}
