package job;

import java.util.ArrayList;

public class Controller {

    public static Controller controller;

    private ArrayList<Model> models;
    private ArrayList<Model> filter;
    private Model select;

    private jobfunction.Model jobFunctionFilter;
    private joblevel.Model jobLevelFilter;
    private jobtype.Model jobTypeFilter;
    private location.Model locationFilter;
    private salary.Model salaryFilter;
    private skill.Model skilFilterl;

    public static void Controller() {
        controller = new Controller();
        controller.models = new ArrayList<Model>();
        controller.filter = new ArrayList<Model>();
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
        for (user.Model user : job_input.getApply()) {
            if (user.equals(user_input)) {
                return true;
            }
        }

        return false;
    }

    public boolean delApplyJob(Model job_input, user.Model user_input) {
        for (int i=0; i<job_input.getApply().size(); ++i) {
            if (job_input.getApply().get(i).equals(user_input)) {
                job_input.getApply().remove(i);
                return true;
            }
        }

        return false;
    }

    public void delApplyJobThis() {
        user.Model user1 = user.Controller.controller.getSession();
        Model job = getSelect();
        delApplyJob(job, user1);
    }

    public void applyJob(Model job_input, user.Model user_input) {
        if (hasApplyJob(job_input, user_input)) {
            System.out.println("Error: duplicate apply job");
            return;
        }

        job_input.getApply().add(user_input);
    }

    public void applyJobThis() {
        user.Model user1 = user.Controller.controller.getSession();
        Model job = getSelect();
        applyJob(job, user1);
    }

    public ArrayList<Model> getApplyJobByUser(user.Model user_input) {
        ArrayList<Model> applyJobs = new ArrayList<Model>();

        for(Model job: models) {
            if (job.getApply().contains(user_input)) {
                applyJobs.add(job);
            }
        }

        return applyJobs;
    }

    public ArrayList<Model> getApplyJobThis() {
        user.Model user1 = user.Controller.controller.getSession();
        return getApplyJobByUser(user1);
    }

    public void approveJob(Model job_input, user.Model user_input) {
        if (hasApplyJob(job_input, user_input)) {
            delApplyJob(job_input, user_input);
            job_input.setApprove(user_input);
        } else {
            System.out.println("Error: user not yet apply");
        }
    }

    public void filterJob() {

        filter = new ArrayList<>(models);

        for (int i=0; i<filter.size(); ++i) {
            if (jobFunctionFilter != null)
                if (!filter.get(i).getJobFunction().equals(jobFunctionFilter)) {
                    filter.remove(i);
                    continue;
                }

            if (jobLevelFilter != null)
                if (!filter.get(i).getJobLevel().equals(jobLevelFilter)) {
                    filter.remove(i);
                    continue;
                }

            if (jobTypeFilter != null)
                if (!filter.get(i).getJobType().equals(jobTypeFilter)) {
                    filter.remove(i);
                    continue;
                }

            if (locationFilter != null)
                if (!filter.get(i).getLocation().equals(locationFilter)) {
                    filter.remove(i);
                    continue;
                }

            if (salaryFilter != null)
                if (!filter.get(i).getSalary().equals(salaryFilter)) {
                    filter.remove(i);
                    continue;
                }

            if (skilFilterl != null)
                for (skill.Model skill : filter.get(i).getSkill())
                    if (!skill.equals(skilFilterl)) {
                        filter.remove(i);
                        continue;
                    }
        }
    }

    public ArrayList<Model> getModels() {
        return models;
    }

    public void setModels(ArrayList<Model> models) {
        this.models = models;
    }

    public ArrayList<Model> getFilter() {
        return filter;
    }

    public void setFilter(ArrayList<Model> filter) {
        this.filter = filter;
    }

    public Model getSelect() {
        return select;
    }

    public void setSelect(Model select) {
        this.select = select;
    }

    public jobfunction.Model getJobFunctionFilter() {
        return jobFunctionFilter;
    }

    public void setJobFunctionFilter(jobfunction.Model jobFunctionFilter) {
        this.jobFunctionFilter = jobFunctionFilter;
    }

    public joblevel.Model getJobLevelFilter() {
        return jobLevelFilter;
    }

    public void setJobLevelFilter(joblevel.Model jobLevelFilter) {
        this.jobLevelFilter = jobLevelFilter;
    }

    public jobtype.Model getJobTypeFilter() {
        return jobTypeFilter;
    }

    public void setJobTypeFilter(jobtype.Model jobTypeFilter) {
        this.jobTypeFilter = jobTypeFilter;
    }

    public location.Model getLocationFilter() {
        return locationFilter;
    }

    public void setLocationFilter(location.Model locationFilter) {
        this.locationFilter = locationFilter;
    }

    public salary.Model getSalaryFilter() {
        return salaryFilter;
    }

    public void setSalaryFilter(salary.Model salaryFilter) {
        this.salaryFilter = salaryFilter;
    }

    public skill.Model getSkilFilterl() {
        return skilFilterl;
    }

    public void setSkilFilterl(skill.Model skilFilterl) {
        this.skilFilterl = skilFilterl;
    }
}
