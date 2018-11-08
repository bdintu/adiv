package user;

import java.util.ArrayList;

public class Controller  {

    public static ArrayList<Model> models;

    public static void Controller() {
    }

    public static void register(user.Model user) {
        Controller.models.add(user);
    }

    public static boolean login(user.Model user_input) {
        user.Model user = getUser(user_input);
        if (user == null) {
            System.out.println("Error: user not in system");
            return false;
        }

        boolean is_login = checkPassword(user, user_input);
        if (is_login == false) {
            System.out.println("Error: password is wrong");
        }

        return true;
    }

    private static user.Model getUser(user.Model user_input) {
        for(user.Model user: Controller.models) {
            if (user.getEmail() == user_input.getEmail()) {
                return user;
            }
        }

        return null;
    }

    private static boolean checkPassword(user.Model user, user.Model user_input) {
        return user.getPassword() == user_input.getPassword();
    }
}
