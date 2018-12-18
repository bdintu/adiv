package user;

public class Test {
    public static void init() {
        Model user = new Model("j@adiv.com", "j");
        Controller.controller.addUser(user);
    }

    public static void login() {
        Model user = new Model("j@adiv.com", "j");
        Controller.controller.login(user);
        System.out.println("\tisLogin: " + Controller.controller.isLogin());

        if (Controller.controller.isLogin()) {
            System.out.println("\tSession" + Controller.controller.getSession());
        }
    }

    public static void print() {
        System.out.println("\t" + Controller.controller.getModels().get(0));
    }
}