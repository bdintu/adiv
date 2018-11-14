package company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Model implements Serializable {

    user.Model user;
    industry.Model industry;
    location.Model location;

    String name;
    String phone;
    String website;
    String biography;

    public Model(user.Model user, industry.Model industry, location.Model location, String name, String phone, String website, String biography) {
        this.user = user;
        this.industry = industry;
        this.location = location;
        this.name = name;
        this.phone = phone;
        this.website = website;
        this.biography = biography;
    }

    public user.Model getUser() {
        return user;
    }

    public void setUser(user.Model user) {
        this.user = user;
    }

    public industry.Model getIndustry() {
        return industry;
    }

    public void setIndustry(industry.Model industry) {
        this.industry = industry;
    }

    public location.Model getLocation() {
        return location;
    }

    public void setLocation(location.Model location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Model)) return false;
        Model model = (Model) o;
        return Objects.equals(getName(), model.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return name;
    }
}
