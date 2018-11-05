package company;

public class Model extends user.Model {
    int id;
    long telephone;

    String name;
    String email;
    String Address;
    String biography;

    public Model(int uid, String email, String password, int id, long telephone, String name, String email1, String address, String biography) {
        super(uid, email, password);
        this.id = id;
        this.telephone = telephone;
        this.name = name;
        this.email = email1;
        Address = address;
        this.biography = biography;
    }

    public int getSeekerId() {
        return id;
    }

    public void setSeekerId(int seekerId) {
        this.id = seekerId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
