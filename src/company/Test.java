package company;

public class Test {

    public static void createCompany() {
//        industry.Model asd = new industry.Model("Mobile Dev");
//        industry.Controller.controller.add(asd);

        industry.Model ind = industry.Controller.controller.getModels().get(0);
        location.Model loc = location.Controller.controller.getModels().get(0);

        Model seeker = new Model(user.Controller.controller.getSession(), ind, loc,"Kbank", "0998061524","kbank.com", "-");
        Controller.controller.add(seeker);
    }

    public static void login() {
        if (user.Controller.controller.isLogin()) {
            Controller.controller.login();
            System.out.println("\tcompanySession"+Controller.controller.getSession());
        }
    }

    public static void printModel() {
        System.out.println(Controller.controller.getModels().get(0));
    }

}