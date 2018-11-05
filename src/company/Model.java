package company;

import java.io.Serializable;
import java.util.ArrayList;

public class Model implements Serializable {
    int id;

    user.Model user;
    ArrayList<industry.Model> industry;

    long telephone;

    String name;
    String Address;
    String biography;
    String website;

    public Model(int id, user.Model user, ArrayList<industry.Model> industry, long telephone, String name, String address, String biography, String website) {
        this.id = id;
        this.user = user;
        this.industry = industry;
        this.telephone = telephone;
        this.name = name;
        Address = address;
        this.biography = biography;
        this.website = website;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public user.Model getUser() {
        return user;
    }

    public void setUser(user.Model user) {
        this.user = user;
    }

    public ArrayList<industry.Model> getIndustry() {
        return industry;
    }

    public void setIndustry(ArrayList<industry.Model> industry) {
        this.industry = industry;
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

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", user=" + user +
                ", industry=" + industry +
                ", telephone=" + telephone +
                ", name='" + name + '\'' +
                ", Address='" + Address + '\'' +
                ", biography='" + biography + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}
