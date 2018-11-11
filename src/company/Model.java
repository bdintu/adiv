package company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Model implements Serializable {

    user.Model user;
    industry.Model industry;

    String name;
    String phone;
    String address;
    String biography;
    String website;

    public Model(user.Model user, industry.Model industry, String name, String phone, String address, String biography, String website) {
        this.user = user;
        this.industry = industry;
        this.phone = phone;
        this.name = name;
        this.address = address;
        this.biography = biography;
        this.website = website;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        address = address;
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
        return "Company{" +
                "user=" + user +
                ", industry=" + industry +
                ", phone=" + phone +
                ", name='" + name + '\'' +
                ", Address='" + address + '\'' +
                ", biography='" + biography + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}
