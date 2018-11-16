package seeker;

public class Test {

    public static void init() {
        user.Model us = user.Controller.controller.getModels().get(0);
        location.Model lo = location.Controller.controller.getModels().get(0);
        Model seeker = new Model(us, lo,"Bundit", "Seedao", "0998061524", "3D KMITL", "-");
        Controller.controller.addModel(seeker);
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