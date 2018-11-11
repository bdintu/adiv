package user;

public class Test {

    public static void login() {
        System.out.println("------------------------------------------------\nlogin:");

        Model user = new Model("j@adiv.com", "j");
        Controller.login(user);
        System.out.println("\tisLogin: "+Controller.isLogin());

        if (Controller.isLogin()) {
            System.out.println("\tSession"+Controller.getSession());
        }
    }

    public static void createUser() {
        System.out.println("------------------------------------------------\ncreateUser:");
        Model user = new Model("j@adiv.com", "j");
        Controller.add(user);
        System.out.println("\tcreateUser" + user);
    }

    public static void printModel() {
        System.out.println("------------------------------------------------\nprintModel:");
        System.out.println("\t"+Controller.getModels().get(0));
    }
}