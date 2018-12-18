package job;

import java.util.ArrayList;

public class Controller {

    public static Controller controller;

    private ArrayList<Model> models;
    private ArrayList<Model> filterJob;
    private Model selectJob;
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
        controller.filterJob = new ArrayList<Model>();
    }

    public void addJob(Model job) {
        if (hasJob(job) == false) {
            models.add(job);
        }
    }

    public void delJob(Model job) {
        models.remove(job);
    }

    public void delJobThis() {
        delJob(selectJob);
    }

    private boolean hasJob(Model job_input) {
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
        Model job = getSelectJob();
        delApplyJob(job, seekerr);
    }

    public void delApplyJobs(Model job_input) {
        job_input.getApply().clear();
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
        Model job = getSelectJob();
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
//            delApplyJob(job_input, seeker_input);
            delApplyJobs(job_input);
            job_input.setApprove(seeker_input);
            job_input.setDetail(detail_input);
        } else {
            System.out.println("Error: user not yet apply");
        }
    }

    public void approveJobThis(String detail_input) {
        Model job_input = selectJob;
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

        filterJob = new ArrayList<>(models);

        for (int i = 0; i < filterJob.size(); ++i) {
            if (filterJob.get(i).getApprove() != null) {
                filterJob.remove(i);
            }

            if (jobFunctionFilter != null)
                if (!filterJob.get(i).getJobFunction().equals(jobFunctionFilter)) {
                    filterJob.remove(i);
                    continue;
                }

            if (jobLevelFilter != null)
                if (!filterJob.get(i).getJobLevel().equals(jobLevelFilter)) {
                    filterJob.remove(i);
                    continue;
                }

            if (jobTypeFilter != null)
                if (!filterJob.get(i).getJobType().equals(jobTypeFilter)) {
                    filterJob.remove(i);
                    continue;
                }

            if (locationFilter != null)
                if (!filterJob.get(i).getLocation().equals(locationFilter)) {
                    filterJob.remove(i);
                    continue;
                }

            if (salaryFilter != null)
                if (!filterJob.get(i).getSalary().equals(salaryFilter)) {
                    filterJob.remove(i);
                    continue;
                }

            if (skilFilterl != null)
                for (skill.Model skill : filterJob.get(i).getSkill())
                    if (!skill.equals(skilFilterl)) {
                        filterJob.remove(i);
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

    public ArrayList<Model> getJobAfterFilter() {
        return filterJob;
    }

    public void setFilterJob(ArrayList<Model> filterJob) {
        this.filterJob = filterJob;
    }

    public Model getSelectJob() {
        return selectJob;
    }

    public void setSelectJob(Model selectJob) {
        this.selectJob = selectJob;
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
