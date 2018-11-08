package user;

import java.util.ArrayList;

public class Controller {

    public static ArrayList<Model> models;
    public Model session;

    public static void Controller() {

        for (Model u : Controller.models)
            System.out.println(u);

        Model um = new user.Model(0, "j@adiv.com", "j", "0998061524");
        Controller u = new Controller();
        boolean gg = u.login(um);
        System.out.println(gg);
        if (gg) {
            u.session.setEmail("j@adiv.com");
            System.out.println(u.session.getEmail());
        }
    }

    public void createUser(user.Model user) {
        models.add(user);
    }

    public boolean login(user.Model user_input) {
        user.Model user = getUser(user_input);
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

    private Model getUser(Model user_input) {
        for (Model user : models) {
            if (user.getEmail().equals(user_input.getEmail())) {
                return user;
            }
        }

        return null;
    }

    private boolean checkPassword(user.Model user, user.Model user_input) {
        return user.getPassword().equals(user_input.getPassword());
    }
}
