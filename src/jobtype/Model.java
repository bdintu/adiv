package jobtype;

public class Model {

    private int jobtypeId;
    private String name;

    public Model(int jobtypeId, String name) {
        this.jobtypeId = jobtypeId;
        this.name = name;
    }

    public int getJobtypeId() {
        return jobtypeId;
    }

    public void setJobtypeId(int jobtypeId) {
        this.jobtypeId = jobtypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Model{" +
                "jobtypeId=" + jobtypeId +
                ", name='" + name + '\'' +
                '}';
    }
}
