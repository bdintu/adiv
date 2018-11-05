package seeker;

import java.io.Serializable;

public class Model implements Serializable {

    private int seekerId;

    private user.Model user;

    private long telephone;

    private String name;
    private String educationLevel;
    private String biography;

    public int getSeekerId() {
        return seekerId;
    }

    public void setSeekerId(int seekerId) {
        this.seekerId = seekerId;
    }

    public user.Model getUser() {
        return user;
    }

    public void setUser(user.Model user) {
        this.user = user;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    @Override
    public String toString() {
        return "Model{" +
                "seekerId=" + seekerId +
                ", user=" + user +
                ", telephone=" + telephone +
                ", name='" + name + '\'' +
                ", educationLevel='" + educationLevel + '\'' +
                ", biography='" + biography + '\'' +
                '}';
    }
}
