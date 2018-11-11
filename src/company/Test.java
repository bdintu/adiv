package company;

public class Test {

    public static void createCompany() {
        industry.Model ind = industry.Controller.getModels().get(0);
        Model seeker = new Model(user.Controller.getSession(), ind,"Kbank", "0998061524", "Nontraburi", "-", "kbank.com");
        Controller.createCompany(seeker);
    }

    public static void setSession() {
        if (user.Controller.isLogin()) {
            if (Controller.isCompany(user.Controller.getSession())) {
                Controller.setSession(user.Controller.getSession());
            }
        }
    }

    public static void getSession() {
        System.out.println(Controller.getSession());
    }

}