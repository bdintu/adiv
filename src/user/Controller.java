package user;

import main.Main;

public class Controller  {

    public static void register(user.Model user) {
        Main.users.add(user);
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
        for(user.Model user: Main.users) {
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
