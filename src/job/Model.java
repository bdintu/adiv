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
    private location.Model location;
    private salary.Model salary;
    private ArrayList<skill.Model> skill;

    private ArrayList<user.Model> apply;
    private user.Model approve;

    public Model(String name, company.Model company, jobfunction.Model jobFunction, joblevel.Model jobLevel, jobtype.Model jobType, location.Model location, salary.Model salary, ArrayList<skill.Model> skill) {
        this.name = name;
        this.company = company;
        this.jobFunction = jobFunction;
        this.jobLevel = jobLevel;
        this.jobType = jobType;
        this.location = location;
        this.salary = salary;
        this.skill = skill;

        this.apply = new ArrayList<user.Model>();
        this.approve = new user.Model();
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

    public location.Model getLocation() {
        return location;
    }

    public void setLocation(location.Model location) {
        this.location = location;
    }

    public salary.Model getSalary() {
        return salary;
    }

    public void setSalary(salary.Model salary) {
        this.salary = salary;
    }

    public ArrayList<skill.Model> getSkill() {
        return skill;
    }

    public void setSkill(ArrayList<skill.Model> skill) {
        this.skill = skill;
    }

    public ArrayList<user.Model> getApply() {
        return apply;
    }

    public void setApply(ArrayList<user.Model> apply) {
        this.apply = apply;
    }

    public user.Model getApprove() {
        return approve;
    }

    public void setApprove(user.Model approve) {
        this.approve = approve;
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
        return name;
    }
}