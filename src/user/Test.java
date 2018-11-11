package user;

public class Test {

    public static void login() {
        Model user = new Model("j@adiv.com", "j");

        Controller.login(user);
        System.out.println(Controller.isLogin());
        if (Controller.isLogin()) {
            Controller.getSession().setEmail("j@adiv.com");
            System.out.println(Controller.getSession().getEmail());
        }
    }

    public static void createUser() {
        Model user = new Model("j@adiv.com", "j");
        Controller.createUser(user);
    }
}
