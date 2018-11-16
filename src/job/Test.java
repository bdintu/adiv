package job;

import java.util.ArrayList;

public class Test {

    public static void init() {
        jobfunction.Model cjf = new jobfunction.Model("Software Developer");
        jobfunction.Controller.controller.add(cjf);

        joblevel.Model cjl = new joblevel.Model("Software Developer");
        joblevel.Controller.controller.add(cjl);

        jobtype.Model cjt = new jobtype.Model("Software Developer");
        jobtype.Controller.controller.add(cjt);

        skill.Model cski = new skill.Model("C/C++");
        skill.Controller.controller.add(cski);

        salary.Model csa = new salary.Model("10000-20000");
        salary.Controller.controller.add(csa);

        company.Model ind = company.Controller.controller.getModels().get(0);
        jobfunction.Model jf = jobfunction.Controller.controller.getModels().get(0);
        joblevel.Model jl = joblevel.Controller.controller.getModels().get(0);
        jobtype.Model jt = jobtype.Controller.controller.getModels().get(0);
        location.Model loc = location.Controller.controller.getModels().get(0);
        salary.Model sa = salary.Controller.controller.getModels().get(0);

        skill.Model ski = skill.Controller.controller.getModels().get(0);
        ArrayList<skill.Model> skill = new ArrayList<skill.Model>();
        skill.add(ski);

        job.Model j = new job.Model("Computer Vision", ind, jf, jl, jt, loc, sa, skill);
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
