package job;

import java.util.ArrayList;

public class Controller {

    public static Controller controller;

    private ArrayList<Model> models;
    private ArrayList<Model> filter;
    private Model select;
    private seeker.Model selectSeeker;

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

    public void delModel(Model job) {
        models.remove(job);
    }

    public void delModelThis() {
        delModel(select);
    }

    private boolean hasModel(Model job_input) {
        for (Model job : models) {
            if (job.equals(job_input)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasApplyJob(Model job_input, seeker.Model seeker_input) {
        for (seeker.Model seeker : job_input.getApply()) {
            if (seeker.equals(seeker_input)) {
                return true;
            }
        }

        return false;
    }

    public boolean delApplyJob(Model job_input, seeker.Model seeker_input) {
        for (int i = 0; i < job_input.getApply().size(); ++i) {
            if (job_input.getApply().get(i).equals(seeker_input)) {
                job_input.getApply().remove(i);
                return true;
            }
        }

        return false;
    }

    public void delApplyJobThis() {
        seeker.Model seekerr = seeker.Controller.controller.getSession();
        Model job = getSelect();
        delApplyJob(job, seekerr);
    }

    public boolean applyJob(Model job_input, seeker.Model seeker_input) {
        if (hasApplyJob(job_input, seeker_input)) {
            System.out.println("Error: duplicate apply job");
            return false;
        }

        job_input.getApply().add(seeker_input);
        return true;
    }

    public boolean applyJobThis() {
        seeker.Model seekerr = seeker.Controller.controller.getSession();
        Model job = getSelect();
        return applyJob(job, seekerr);
    }

    public ArrayList<Model> getApplyJob(seeker.Model seeker_input) {
        ArrayList<Model> applyJobs = new ArrayList<Model>();

        for (Model job : models) {
            if (job.getApply().contains(seeker_input)) {
                applyJobs.add(job);
            }
        }

        return applyJobs;
    }

    public ArrayList<Model> getApplyJob(company.Model company_input) {
        ArrayList<Model> applyJobs = new ArrayList<Model>();

        for (Model job : models) {
            if (job.getCompany().equals(company_input) && job.getApply().size() != 0) {
                applyJobs.add(job);
            }
        }

        return applyJobs;
    }

    public void approveJob(Model job_input, seeker.Model seeker_input, String detail_input) {
        if (hasApplyJob(job_input, seeker_input)) {
            delApplyJob(job_input, seeker_input);
            job_input.setApprove(seeker_input);
            job_input.setDetail(detail_input);
        } else {
            System.out.println("Error: user not yet apply");
        }
    }

    public void approveJobThis(String detail_input) {
        Model job_input = select;
        seeker.Model seeker_input = selectSeeker;
        approveJob(job_input, seeker_input, detail_input);
    }

    public ArrayList<Model> getApprove(seeker.Model seeker_input) {
        ArrayList<Model> approveJob = new ArrayList<Model>();

        for (Model job : models) {
            if (job.getApprove().equals(seeker_input)) {
                approveJob.add(job);
            }
        }

        return approveJob;
    }

    public void filter() {

        filter = new ArrayList<>(models);

        for (int i = 0; i < filter.size(); ++i) {
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

    public void clearFilter() {
        jobFunctionFilter = null;
        jobLevelFilter = null;
        jobTypeFilter = null;
        locationFilter = null;
        salaryFilter = null;
        skilFilterl = null;
    }

    public ArrayList<Model> getModels(company.Model company_input) {
        ArrayList<Model> companyJob = new ArrayList<Model>();
        for (Model model : models) {
            if (model.getCompany().equals(company_input)) {
                companyJob.add(model);
            }
        }
        return companyJob;
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

    public seeker.Model getSelectSeeker() {
        return selectSeeker;
    }

    public void setSelectSeeker(seeker.Model select) {
        this.selectSeeker = select;
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
