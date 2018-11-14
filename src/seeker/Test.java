package seeker;

public class Test {

    public static void init() {
        location.Model cloc = new location.Model("Latkrabang");
        location.Controller.controller.add(cloc);

        location.Model loc = location.Controller.controller.getModels().get(0);
        Model seeker = new Model(user.Controller.controller.getSession(), location.Controller.controller.getModels().get(0),"Bundit", "Seedao", "0998061524", "3D KMITL", "-");
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