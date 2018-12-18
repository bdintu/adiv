package seeker;

public class Test {

    public static void init() {
        user.Model us = user.Controller.controller.getModels().get(0);
        Model seeker = new Model(us,"Bundit", "Seedao", "0998061524", "11/4", "3D KMITL", "-");
        Controller.controller.addSeeker(seeker);
    }

    public static void login() {
        if (user.Controller.controller.isLogin()) {
            Controller.controller.syncSession();
            System.out.println("\tseekerSession"+Controller.controller.getSession());
        }
    }

    public static void print() {
        System.out.println("\t"+Controller.controller.getModels().get(0));
    }
}