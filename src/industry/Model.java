package industry;

public class Model {

    private int IndustryId;
    private String name;

    public Model(int industryId, String name) {
        IndustryId = industryId;
        this.name = name;
    }

    public int getIndustryId() {
        return IndustryId;
    }

    public void setIndustryId(int industryId) {
        IndustryId = industryId;
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
                "IndustryId=" + IndustryId +
                ", name='" + name + '\'' +
                '}';
    }
}
