package company;

public class Test {

    public static void init() {
        String[] los = {"Phra Nakhon", "Bang Bon", "Bang Kapi", "Bang Khae", "Bang Khen", "Bang Kho Laem", "Bang Khun Thian", "Bang Na", "Bang Phlat", "Bang Rak", "Bang Sue", "Bangkok Noi", "Bangkok Yai", "Bueng Kum", "Chatuchak", "Chom Thong", "Din Daeng", "Don Mueang", "Dusit", "Huai Khwang", "Khan Na Yao", "Khlong Sam Wa", "Khlong San", "Khlong Toei", "Lak Si", "Lat Krabang", "Lat Phrao", "Min Buri", "Nong Chok", "Nong Khaem", "Pathum Wan", "Phasi Charoen", "Phaya Thai", "Phra Khanong", "Pom Prap Sattru", "Prawet", "Rat Burana", "Ratchathewi", "Sai Mai", "Samphanthawong", "Saphan Sung", "Sathon", "Suan Luang", "Taling Chan", "Thawi Watthana", "Thon Buri", "Thung Khru", "Wang Thonglang", "Vadhana"};
        for (String i : los)
            location.Controller.controller.add(new location.Model(i));

        String[] ins = {"Accounting", "Advertising", "Education", "Financial", "Health care", "Hotel", "IT", "Media", "Retails"};
        for (String i : ins)
            industry.Controller.controller.add(new industry.Model(i));

        user.Model us = user.Controller.controller.getModels().get(0);
        industry.Model ind = industry.Controller.controller.getModels().get(0);
        location.Model loc = location.Controller.controller.getModels().get(0);
        Model seeker = new Model(us, ind, loc,"Kbank", "0998061524","kbank.com", "-");
        Controller.controller.addModel(seeker);
    }

    public static void login() {
        if (user.Controller.controller.isLogin()) {
            Controller.controller.syncSession();
            System.out.println("\tcompanySession"+Controller.controller.getSession());
        }
    }

    public static void print() {
        System.out.println(Controller.controller.getModels().get(0));
    }

}