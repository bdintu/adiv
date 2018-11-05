package skill;

import java.io.Serializable;

public class Model implements Serializable {

    private int skillId;
    private String name;

    public Model(int skillId, String name) {
        this.skillId = skillId;
        this.name = name;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
