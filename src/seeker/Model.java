package seeker;

public class Model extends user.Model {

    int seekerId;
    long telephone;

    String name;
    String email;
    String educationLevel;
    String biography;

    public Model(int uid, String email, String username, String password, int seekerId, long telephone, String name, String email1, String educationLevel, String biography) {
        super(uid, email, username, password);
        this.seekerId = seekerId;
        this.telephone = telephone;
        this.name = name;
        this.email = email1;
        this.educationLevel = educationLevel;
        this.biography = biography;
    }

    public int getSeekerId() {
        return seekerId;
    }

    public void setSeekerId(int seekerId) {
        this.seekerId = seekerId;
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

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
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
}
