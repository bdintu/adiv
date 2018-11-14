package seeker;

public class Test {

    public static void createSeeker() {
        System.out.println("------------------------------------------------\ncreateSeeker:");
        Model seeker = new Model(user.Controller.controller.getSession(), "Bundit", "Seedao", "0998061524", "Bangkok", "3D", "-");
        Controller.add(seeker);
    }

    public static void login() {
        System.out.println("------------------------------------------------\nisSeeker:");
        if (user.Controller.controller.isLogin()) {
            Controller.login();
            System.out.println("\tseekerSession"+Controller.getSession());
        }
    }

    public static void printModel() {

        System.out.println("------------------------------------------------\nprintModel:");
        System.out.println("\t"+Controller.getModels().get(0));
    }
}