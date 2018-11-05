package user;

import java.io.Serializable;

public class Model implements Serializable {

    private static final long serialVersionUID = 1L;

    private int uid;
    private String email;
    private String password;
    private String phone;

    public Model(int uid, String email, String password, String phone) {
        this.uid = uid;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Model{" +
                "uid=" + uid +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}