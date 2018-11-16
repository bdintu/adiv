package job;

import java.util.ArrayList;

public class Test {

    public static void init() {
        String[] jfs = {"Software Developer", "System Administrator", "Data & Analytics", "Content Creator", "UI/UX Designer", "Graphic Designer", "QA & Tester", "Project Manager"};
        for (String i : jfs)
            jobfunction.Controller.controller.add(new jobfunction.Model(i));

        String[] jls = {"Entry", "Middle", "Senior"};
        for (String i : jls)
            joblevel.Controller.controller.add(new joblevel.Model(i));

        String[] jts = {"Full time", "Part time", "Freelance", "Internship"};
        for (String i : jts)
            jobtype.Controller.controller.add(new jobtype.Model(i));

        String[] sas = {"Under 20000", "20000-30000", "30000-40000", "40000-50000", "50000-60000", "60000-70000", "70000-80000", "Upper 80000"};
        for (String i : sas)
            salary.Controller.controller.add(new salary.Model(i));

        String[] sks = {"Andriod", "C/C++", "CSS", "Java", "Javascript", "Python", "Tensorflow","React", "SQL", "Swift", "Vue"};
        for (String i : sks)
            skill.Controller.controller.add(new skill.Model(i));

        company.Model ind = company.Controller.controller.getModels().get(0);
        jobfunction.Model jf = jobfunction.Controller.controller.getModels().get(0);
        joblevel.Model jl = joblevel.Controller.controller.getModels().get(0);
        jobtype.Model jt = jobtype.Controller.controller.getModels().get(0);
        location.Model loc = location.Controller.controller.getModels().get(0);
        salary.Model sa = salary.Controller.controller.getModels().get(0);

        skill.Model ski = skill.Controller.controller.getModels().get(0);
        ArrayList<skill.Model> skill = new ArrayList<skill.Model>();
        skill.add(ski);

        job.Model j = new job.Model("Computer Vision App", "Ba ba ba",ind, jf, jl, jt, loc, sa, skill);
        Controller.controller.addModel(j);
    }

    public static void applyJob() {
        user.Model u = user.Controller.controller.getModels().get(0);
        Model j = Controller.controller.getModels().get(0);
        Controller.controller.applyJob(j, u);

        System.out.println(Controller.controller.getModels().get(0).getApply());
    }

    public static void approveJob() {
        user.Model u = user.Controller.controller.getModels().get(0);
        Model j = Controller.controller.getModels().get(0);
        Controller.controller.approveJob(j, u);

        System.out.println(Controller.controller.getModels().get(0).getApprove());
    }

    public static void print() {
        System.out.println(Controller.controller.getModels().get(0));
    }
}
