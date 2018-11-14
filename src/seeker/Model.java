package seeker;

import java.io.Serializable;
import java.util.Objects;

public class Model implements Serializable {

    private user.Model user;
    private location.Model location;

    private String firstName;
    private String lastName;
    private String phone;
    private String educationLevel;
    private String biography;

    public Model(user.Model user, location.Model location, String firstName, String lastName, String phone, String educationLevel, String biography) {
        this.user = user;
        this.location = location;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.educationLevel = educationLevel;
        this.biography = biography;
    }

    public user.Model getUser() {
        return user;
    }

    public void setUser(user.Model user) {
        this.user = user;
    }

    public location.Model getLocation() {
        return location;
    }

    public void setLocation(location.Model location) {
        this.location = location;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Model)) return false;
        Model model = (Model) o;
        return Objects.equals(getFirstName(), model.getFirstName()) &&
                Objects.equals(getLastName(), model.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName());
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
