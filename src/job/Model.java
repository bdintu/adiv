package job;

import java.util.ArrayList;

public class Model {
    int jobId;

    company.Model company;
    jobtype.Model jobType;
    joblevel.Model jobLevel;
    jobfunction.Model jobFunction;

    ArrayList<skill.Model> skill;

    int salary_begin;
    int salary_end;

    public Model(int jobId, company.Model company, jobtype.Model jobType, joblevel.Model jobLevel, jobfunction.Model jobFunction, ArrayList<skill.Model> skill, int salary_begin, int salary_end) {
        this.jobId = jobId;
        this.company = company;
        this.jobType = jobType;
        this.jobLevel = jobLevel;
        this.jobFunction = jobFunction;
        this.skill = skill;
        this.salary_begin = salary_begin;
        this.salary_end = salary_end;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public company.Model getCompany() {
        return company;
    }

    public void setCompany(company.Model company) {
        this.company = company;
    }

    public jobtype.Model getJobType() {
        return jobType;
    }

    public void setJobType(jobtype.Model jobType) {
        this.jobType = jobType;
    }

    public joblevel.Model getJobLevel() {
        return jobLevel;
    }

    public void setJobLevel(joblevel.Model jobLevel) {
        this.jobLevel = jobLevel;
    }

    public jobfunction.Model getJobFunction() {
        return jobFunction;
    }

    public void setJobFunction(jobfunction.Model jobFunction) {
        this.jobFunction = jobFunction;
    }

    public ArrayList<skill.Model> getSkill() {
        return skill;
    }

    public void setSkill(ArrayList<skill.Model> skill) {
        this.skill = skill;
    }

    public int getSalary_begin() {
        return salary_begin;
    }

    public void setSalary_begin(int salary_begin) {
        this.salary_begin = salary_begin;
    }

    public int getSalary_end() {
        return salary_end;
    }

    public void setSalary_end(int salary_end) {
        this.salary_end = salary_end;
    }

    @Override
    public String toString() {
        return "Model{" +
                "jobId=" + jobId +
                ", company=" + company +
                ", jobType=" + jobType +
                ", jobLevel=" + jobLevel +
                ", jobFunction=" + jobFunction +
                ", skill=" + skill +
                ", salary_begin=" + salary_begin +
                ", salary_end=" + salary_end +
                '}';
    }
}