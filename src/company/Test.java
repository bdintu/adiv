package company;

public class Test {

    public static void createCompany() {
        System.out.println("------------------------------------------------\ncreateCompany:");
        industry.Model ind = industry.Controller.getModels().get(0);

        Model seeker = new Model(user.Controller.getSession(), ind,"Kbank", "0998061524", "Nontraburi", "-", "kbank.com");
        Controller.add(seeker);
    }

    public static void login() {
        System.out.println("------------------------------------------------\nisSeeker:");
        if (user.Controller.isLogin()) {
            Controller.login();
            System.out.println("\tcompanySession"+Controller.getSession());
        }
    }

    public static void printModel() {
        System.out.println("------------------------------------------------\nprintModel:");
        System.out.println(Controller.getModels().get(0));
    }

}