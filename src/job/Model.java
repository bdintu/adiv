package job;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Model implements Serializable {

    private String name;

    private company.Model company;
    private jobfunction.Model jobFunction;
    private joblevel.Model jobLevel;
    private jobtype.Model jobType;
    private ArrayList<skill.Model> skill;

    int salary_begin;
    int salary_end;

    public Model(String name, company.Model company, jobfunction.Model jobFunction, joblevel.Model jobLevel, jobtype.Model jobType, ArrayList<skill.Model> skill, int salary_begin, int salary_end) {
        this.name = name;
        this.company = company;
        this.jobFunction = jobFunction;
        this.jobLevel = jobLevel;
        this.jobType = jobType;
        this.skill = skill;
        this.salary_begin = salary_begin;
        this.salary_end = salary_end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public company.Model getCompany() {
        return company;
    }

    public void setCompany(company.Model company) {
        this.company = company;
    }

    public jobfunction.Model getJobFunction() {
        return jobFunction;
    }

    public void setJobFunction(jobfunction.Model jobFunction) {
        this.jobFunction = jobFunction;
    }

    public joblevel.Model getJobLevel() {
        return jobLevel;
    }

    public void setJobLevel(joblevel.Model jobLevel) {
        this.jobLevel = jobLevel;
    }

    public jobtype.Model getJobType() {
        return jobType;
    }

    public void setJobType(jobtype.Model jobType) {
        this.jobType = jobType;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Model)) return false;
        Model model = (Model) o;
        return Objects.equals(getName(), model.getName()) &&
                Objects.equals(getCompany(), model.getCompany());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCompany());
    }

    @Override
    public String toString() {
        return "Job{" +
                "name='" + name + '\'' +
                ", company=" + company +
                ", jobFunction=" + jobFunction +
                ", jobLevel=" + jobLevel +
                ", jobType=" + jobType +
                ", skill=" + skill +
                ", salary_begin=" + salary_begin +
                ", salary_end=" + salary_end +
                '}';
    }
}