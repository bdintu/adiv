package job;

import java.util.ArrayList;

public class Controller {

    public static Controller controller;

    private ArrayList<Model> models;
    private Model select;

    public static void Controller() {
        controller = new Controller();
        controller.models = new ArrayList<Model>();
    }

    public void addModel(Model job) {
        if (hasModel(job) == false) {
            models.add(job);
        }
    }

    private boolean hasModel(Model job_input) {
        for (Model job : models) {
            if (job.equals(job_input)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasApplyJob(Model job_input, user.Model user_input) {
        for (user.Model user: job_input.getApply()) {
            if (user.equals(user_input)) {
                return true;
            }
        }

        return false;
    }

    public void applyJob(Model job_input, user.Model user_input) {
        if (hasApplyJob(job_input, user_input)) {
            System.out.println("Error: duplicate apply job");
            return;
        }

        job_input.getApply().add(user_input);
    }

    public void approveJob(Model job_input, user.Model user_input) {
        if (hasApplyJob(job_input, user_input)) {
            job_input.setApprove(user_input);
        } else {
            System.out.println("Error: user not yet apply");
        }
    }

    public ArrayList<Model> getModels() {
        return models;
    }

    public void setModels(ArrayList<Model> models) {
        this.models = models;
    }

    public Model getSelect() {
        return select;
    }

    public void setSelect(Model select) {
        this.select = select;
    }
}
