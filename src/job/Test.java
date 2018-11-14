package job;

import java.util.ArrayList;

public class Test {

    public static void createJob() {
//        jobfunction.Model jf = new jobfunction.Model("Software Developer");
//        jobfunction.Controller.controller.add(jf);
//
//        joblevel.Model jl = new joblevel.Model("Software Developer");
//        joblevel.Controller.controller.add(jl);
//
//        jobtype.Model jt = new jobtype.Model("Software Developer");
//        jobtype.Controller.controller.add(jt);
//
//        skill.Model ski = new skill.Model("C/C++");
//        skill.Controller.controller.add(ski);

        company.Model ind = company.Controller.controller.getModels().get(0);
        jobfunction.Model jf = jobfunction.Controller.controller.getModels().get(0);
        joblevel.Model jl = joblevel.Controller.controller.getModels().get(0);
        jobtype.Model jt = jobtype.Controller.controller.getModels().get(0);
        location.Model loc = location.Controller.controller.getModels().get(0);

        skill.Model ski = skill.Controller.controller.getModels().get(0);
        ArrayList<skill.Model> skill = new ArrayList<skill.Model>();
        skill.add(ski);

        job.Model j = new job.Model("Computer Vision", ind, jf, jl, jt, loc, skill, 30000, 50000);
        Controller.controller.addModel(j);
    }

    public static void printModel() {
        System.out.println(Controller.controller.getModels().get(0));
    }
}
