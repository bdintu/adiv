package serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Serialize {

    public static Serialize serialize;

    private final String dbpath = "adiv.db";
    private HashMap<String, ArrayList> map;

    public static void Serialize() {
        serialize = new Serialize();
    }

    public void objRead() {
        serializeRead();
        System.out.println("The Object  was succesfully read");

        user.Controller.controller.setModels(map.get("user"));
        location.Controller.controller.setModels(map.get("location"));
        seeker.Controller.controller.setModels( map.get("seeker"));
        industry.Controller.controller.setModels(map.get("industry"));
        company.Controller.controller.setModels(map.get("company"));
        skill.Controller.controller.setModels(map.get("skill"));
        jobfunction.Controller.controller.setModels(map.get("jobfunction"));
        joblevel.Controller.controller.setModels(map.get("joblevel"));
        jobtype.Controller.controller.setModels(map.get("jobtype"));
        job.Controller.controller.setModels(map.get("job"));
    }

    public void objWrite() {
        HashMap<String, ArrayList> map = new HashMap<String, ArrayList>();
        map.put("user", user.Controller.controller.getModels());
        map.put("location", location.Controller.controller.getModels());
        map.put("seeker", seeker.Controller.controller.getModels());
        map.put("industry", industry.Controller.controller.getModels());
        map.put("company", company.Controller.controller.getModels());
        map.put("skill", skill.Controller.controller.getModels());
        map.put("jobfunction", jobfunction.Controller.controller.getModels());
        map.put("joblevel", joblevel.Controller.controller.getModels());
        map.put("jobtype", jobtype.Controller.controller.getModels());
        map.put("job", job.Controller.controller.getModels());

        serializeWrite(map);
        System.out.println("The Object  was succesfully written to a file");
    }

    public void serializeWrite(Object serObj) {

        try {
            FileOutputStream fileOut = new FileOutputStream(dbpath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            fileOut.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void serializeRead() {

        try {
            FileInputStream fileIn = new FileInputStream(dbpath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            map = (HashMap<String, ArrayList>) objectIn.readObject();
            objectIn.close();
            fileIn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
