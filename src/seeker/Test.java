package seeker;

public class Test {

    public static void createSeeker() {
        Model seeker = new Model(user.Controller.getSession(), "Bundit", "Seedao", "0998061524", "Bangkok", "3D", "-");
        Controller.createSeeker(seeker);
    }

    public static void setSession() {
        if (user.Controller.isLogin()) {
            if (Controller.isSeeker(user.Controller.getSession())) {
                Controller.setSession(user.Controller.getSession());
            }
        }
    }

    public static void getSession() {
        System.out.println(Controller.getSession());
    }
}
